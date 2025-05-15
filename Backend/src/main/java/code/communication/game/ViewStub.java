package code.communication.game;


import code.controller.communication.game.*;
import code.interfaces.IController;
import code.interfaces.IView;

public class ViewStub implements IView {

    public int rows = 6;
    public int cols = 7;
    public int time = 60;

    public String name = "kitty";

    private final int myID;

    public ViewStub(int id) {
        myID = id;
    }


    @Override
    public void setStone(int stone) {
        SetStone set = SetStone.newBuilder().setCol(stone).build();
        ResponseStream response = ResponseStream.newBuilder().setSetStone(set).build();
        ClientsManager.sendMessageToClient(myID, response);

        // info().addSetStone(SetStone.newBuilder().setCol(stone).build());
    }

    @Override
    public void updateTimer(int time) {
        UpdateTimer timer = UpdateTimer.newBuilder().setTimeLeft(time).build();
        ResponseStream response = ResponseStream.newBuilder().setUpdateTimer(timer).build();
        ClientsManager.sendMessageToClient(myID, response);

        //info().addUpdateTimer(UpdateTimer.newBuilder().setTimeLeft(time).build());
    }

    @Override
    public void setBoardParams(int rows, int columns) {
        this.rows = rows;
        this.cols = columns;
    }

    @Override
    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void begin(boolean start) {


        //build begin() call
        Begin begin = Begin.newBuilder().setBegin(start).build();
        ResponseStream response = ResponseStream.newBuilder().setBegin(begin).build();
        ClientsManager.sendMessageToClient(myID, response);

        //info().addBegin(Begin.newBuilder().setBegin(start).build());
    }

    @Override
    public void setWinner(boolean winner) {
        SetWinner set = SetWinner.newBuilder().setWinner(winner).build();
        ResponseStream response = ResponseStream.newBuilder().setSetWinner(set).build();
        ClientsManager.sendMessageToClient(myID, response);
        ClientsManager.unregisterClient(myID);
        //info().addSetWinner(SetWinner.newBuilder().setWinner(winner).build());
//        info().addSetWinner(SetWinner.newBuilder().setBegin(winner).build());
    }

    @Override
    public void setEnemyName(String name) {
        this.name = name;

        //ensure to get other ID
        //int enemyID = LobbyManager.getLobby(myID).getOwnerID();
        //if (enemyID == myID) enemyID = LobbyManager.getLobby(myID).getOtherID();

        //build setEnemyData() call
        EnemyData data = EnemyData.newBuilder().setEnemyName(name).setEnemyID(10).build();
        ResponseStream response = ResponseStream.newBuilder().setSetEnemy(data).build();
        ClientsManager.sendMessageToClient(myID, response);
    }

    @Override
    public IController getController() {
        return null;
    }

    private SharedInfo info(){
        return ClientsManager.getSharedInfo(myID);
    }
}
