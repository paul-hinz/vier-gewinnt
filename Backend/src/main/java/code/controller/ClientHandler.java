package code.controller;

import code.interfaces.*;
import code.model.ModelManager;
import org.json.JSONException;
import utils.Lobby;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Der Client Handler bietet das Interface zum Spielen für jeweils genau ein Spiel.
 * Wird gegen eine KI gespielt, gibt es nur eine view, mit der kommuniziert wird,
 * gibt es zwei Spieler wird dieser Handler über join Lobby auch an den zweiten Spieler weitergegeben
 *
 */
public class ClientHandler implements IController {

    private final IView viewOwner;
    private  IView viewGuest = null;
    private boolean ownerActive = true;

    private boolean ownerWon = true;


    private IGame game = null;
    private int rows, columns;
    private boolean aiNeeded;
    private String name = "";
    private Lobby lobby= null;
    public  GameTimer gt = null;
    private boolean done = false;




    public ClientHandler (IView view){
        this.viewOwner = view;
    }

    @Override
    public void makeMove(int move) {
            if (game == null) {
                System.err.println("Fehler: noch kein Spiel gestartet");
                return;
            }
            if (gt == null) {
                System.err.println("Fehler: noch keine Zeit gesetzt");
                return;
            }
            if (done){
                return;
            }

            gt.stopTimer();

            if(aiNeeded){
                handleMoveAI(move);
            }
            else {
                if (ownerActive){
                    viewGuest.setStone(move);
                }
                else {
                    viewOwner.setStone(move);
                }
                handleMovePvP(move);
                checkWinnerAfterMoveInPVP();
                ownerActive = !ownerActive;
            }
            
    }

    private void handleMovePvP(int move){
        gt = new GameTimer(lobby.getGameTime(), this);
        gt.startTimer();
        game.makeMove(move);
    }
    private void checkWinnerAfterMoveInPVP(){
        if(game.checkWinner()){

            if (ownerActive){
                viewGuest.setWinner(false);
                viewOwner.setWinner(true);
            }
            else {
                viewGuest.setWinner(true);
                viewOwner.setWinner(false);
            }
            ownerWon = ownerActive;
            done = true;
            gt.stopTimer();
        }
    }

    private void handleMoveAI(int move){

        gt = new GameTimer(lobby.getGameTime(), this);
        game.makeMove(move);
        if(game.checkWinner()){
            viewOwner.setWinner(true);
            ownerWon = true;
            return;
        } else {
            gt.startTimer();
        }
            //berechnet besten Zug, führt ihn aus und gibt ihn zurück
            int bestMove = game.makeBestMove();
            viewOwner.setStone(bestMove);
            if(game.checkWinner()){
                viewOwner.setWinner(false);
                ownerWon = false;
            }
        gt.stopTimer();
    }

    @Override
    public void setBoardSize(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public void setGameTime(int gameTime) {
        if (lobby == null) {
            System.err.println("Fehler: noch keine Lobby erstellt");
            return;
        }
        lobby.setGameTime(name, gameTime);
    }


    @Override
    public void chooseEnemy(boolean enemy) {
        if(enemy){
            rows = 6;
            columns = 7;
        }
        aiNeeded = enemy;

    }

    @Override
    public List<Lobby> getLobbies() {
        return LobbyManager.getLobbys();
    }

    @Override
    public IController joinLobby(Lobby lobby, IView newView) {
        if (lobby.isFull(false)) return null;
        LobbyManager.joinLobby(lobby, name, newView);
        this.lobby = lobby;
        ClientHandler newHandler = lobby.getClientHandler();

        newView.setBoardParams(newHandler.rows, newHandler.columns);
        newView.setTime(lobby.getGameTime());
        newView.setEnemyName(lobby.getOwnerName());
        newHandler.viewOwner.setEnemyName(lobby.getOtherName());

        return newHandler;
    }

    @Override
    public Lobby createNewLobby() {
        lobby = LobbyManager.newLobby(name, this);
        return lobby;
    }

    @Override
    public void startGame() {
        if (lobby == null) {
            System.err.println("Fehler: noch keine Lobby erstellt");
            return;
        }
        if (lobby.isFull(aiNeeded)) {
            game = new ModelManager(columns, rows, aiNeeded);
            lobby.setGame(game);
            boolean playerBegins = game.getStarter();
            viewOwner.begin(playerBegins);
            if(aiNeeded){
                if(!playerBegins){
                    //berechnet besten Zug, führt ihn aus und gibt ihn zurück
                    int bestMove = game.makeBestMove();
                    activeView().setStone(bestMove);
                }
            }
            else{
                viewGuest = lobby.otherView;
                viewGuest.begin(!playerBegins);
                ownerActive = playerBegins;
            }

            gt = new GameTimer(lobby.getGameTime(), this);
            gt.startTimer();
        }
        else {
            System.err.println("Fehler: Lobby nicht voll");
        }
    }

    @Override
    public void setOwnName(String playerName) {
        name = playerName;
    }

    @Override
    public boolean postTwitter(){
        String gameData;
        String winner = lobby.getOwnerName();
        String loser = lobby.getOtherName();

        if(aiNeeded) {
            loser = "die KI";
        }

        // Tauschen, wenn Owner verloren hat
        if (!ownerWon){
            String temp = winner;
            winner = loser;
            loser = temp;
        }

        gameData = winner + " hat gerade gegen " + loser + " in VierGewinnt gewonnen!";

        //Aktuelle Uhrzeit einfügen
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formattedTime = currentTime.format(formatter);

        gameData = formattedTime + ": \n" + gameData;

        boolean res = true;

        try {
            res = TwitterHandler.postResult(gameData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return res;
    }

    public void updateTimer (int time){
     activeView().updateTimer(time);
    }

    public void gameOver(){
        activeView().setWinner(false);
        if (viewGuest != null){
            ownerActive = !ownerActive;
            activeView().setWinner(true);
        }
    }

    public IView activeView(){
        if(ownerActive){
            return viewOwner;
        }
        else {
            return viewGuest;
        }
    }

    public boolean isOwnerActive() {
        return ownerActive;
    }

    public void setOwnerActive(boolean ownerActive) {
        this.ownerActive = ownerActive;
    }
    public IGame getGame() {
        return game;
    }

}
