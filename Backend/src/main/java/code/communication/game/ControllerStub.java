package code.communication.game;

import code.controller.ControllerFactory;
import code.interfaces.IController;
import code.interfaces.IView;
import utils.Lobby;

import java.util.List;

public class ControllerStub implements IController{

    private final int myID;

    private IController controller;


    public ControllerStub(int myID, IView view) {
        this.myID = myID;
        controller = ControllerFactory.getInstance(view);
    }


    @Override
    public void makeMove(int move) {
        controller.makeMove(move);
    }

    @Override
    public void setBoardSize(int rows, int columns) {
        controller.setBoardSize(rows, columns);
    }

    @Override
    public void setGameTime(int time) {
        controller.setGameTime(time);
    }

    @Override
    public void chooseEnemy(boolean enemy) {
        controller.chooseEnemy(enemy);
    }

    @Override
    public List<Lobby> getLobbies() {
        return controller.getLobbies();
    }

    @Override
    public IController joinLobby(Lobby lobby, IView view) {
        lobby.setOtherID(myID);
        IController res = controller.joinLobby(lobby, view);
        controller = res;
        return res;
    }

    @Override
    public Lobby createNewLobby() {
        Lobby lobby = controller.createNewLobby();
        lobby.setOwnerID(myID);
        return lobby;
    }

    @Override
    public void startGame() {
        controller.startGame();
    }

    @Override
    public void setOwnName(String playerName) {
        controller.setOwnName(playerName);
    }


    @Override
    public boolean postTwitter() {
        return controller.postTwitter();
    }


}
