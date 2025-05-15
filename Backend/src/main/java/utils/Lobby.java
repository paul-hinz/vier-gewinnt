package utils;

import code.controller.ClientHandler;
import code.interfaces.IGame;
import code.interfaces.IView;

public class Lobby {

    private final String ownerName;
    private String otherName = "";
    public IView otherView = null;

    public ClientHandler getClientHandler() {
        return ch;
    }

    private ClientHandler ch;

    private IGame game = null;

    private int gameTime = 0;

    public int lobbyID;

    private int ownerID;

    private int otherID;

    public Lobby(String name, ClientHandler ch, int lobbyID) {
        this.ch = ch;
        if(name.equals("")){ System.err.println("Keinen Namen gesetzt"); }
        ownerName = name;
        this.lobbyID = lobbyID;
    }

    public void addPlayer(String name, IView view) {

        otherName = name;
        otherView = view;

    }

    public boolean isFull(boolean aiNeeded){
        return aiNeeded || otherName.length() > 0;
    }

    public void setGame(IGame game) {
        this.game = game;
    }

    public IGame getGame(){
        return game;
    }

    public boolean isGameRunning(){
        return game != null;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public String getOtherName(){
        return otherName;
    }

    public void setGameTime(String owner, int gameTime) {
        if (owner.equals(ownerName)) this.gameTime = gameTime;
    }

    public int getGameTime() {
        return gameTime;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getOtherID() {
        return otherID;
    }

    public void setOtherID(int otherID) {
        this.otherID = otherID;
    }
}
