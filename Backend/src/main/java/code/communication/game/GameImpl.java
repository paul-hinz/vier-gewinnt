package code.communication.game;


import code.controller.LobbyManager;
import code.controller.communication.game.*;
import code.controller.communication.game.Void;
import code.interfaces.IController;
import io.grpc.stub.StreamObserver;
import utils.Lobby;

public class GameImpl extends GameGrpc.GameImplBase {


    @Override
    public void createLobby(CreateLobbyRequest request, StreamObserver<CreateLobbyResponse> responseObserver) {

        System.out.println(request.getBoardColCount());
        System.out.println(request.getBoardRowCount());
        System.out.println(request.getEnemy());
        System.out.println(request.getGameTime());
        System.out.println(request.getOwnName());

        int clientID = ClientsManager.getNewID();
        ClientsManager.newClient(clientID);
        ControllerStub handler = ClientsManager.getControllerStub(clientID);

        handler.setOwnName(request.getOwnName());
        Lobby lobby = handler.createNewLobby();
        int lobbyID = lobby.lobbyID;
        handler.setBoardSize(request.getBoardRowCount(), request.getBoardColCount());
        handler.setGameTime(request.getGameTime());
        handler.chooseEnemy(request.getEnemy().equals(Enemy.AI));

        boolean suc = lobby != null;

        responseObserver.onNext(CreateLobbyResponse.newBuilder().setSuccess(suc).setLobbyID(lobbyID).setClientID(clientID).build());

        responseObserver.onCompleted();
    }

    @Override
    public void getLobbies(code.controller.communication.game.Void request, StreamObserver<GetLobbiesResponse> responseObserver) {
        super.getLobbies(request, responseObserver);
    }

    @Override
    public void joinLobby(JoinLobbyRequest request, StreamObserver<JoinLobbyResponse> responseObserver) {
        int clientID = ClientsManager.getNewID();
        ClientsManager.newClient(clientID);

        ControllerStub handler = ClientsManager.getControllerStub(clientID);
        ViewStub viewStub = ClientsManager.getViewStub(clientID);
        boolean suc = false;

        handler.setOwnName(request.getOwnName());

        utils.Lobby lobby = LobbyManager.getLobby(request.getLobbyID());

        if (lobby != null) { //falls Lobby nicht existiert hat
            suc = handler.joinLobby(lobby, viewStub) != null;  //falls Lobby bereits voll war
        }
        int time = viewStub.time;
        int rows = viewStub.rows;
        int cols = viewStub.cols;
        String name = viewStub.name;


        responseObserver.onNext(JoinLobbyResponse.newBuilder().setSuccess(suc).setEnemyName(name).setGameTime(time).setBoardRowCount(rows).setBoardColCount(cols).setClientID(clientID).build());

        responseObserver.onCompleted();
    }

    @Override
    public void pollGameData(PollRequest request, StreamObserver<ResponseStream> responseObserver) {


        ClientsManager.registerClient(request.getClientID(), responseObserver);

        /*

        //Gespeicherte Funkktionsaufrufe für diesen Client holen

        SharedInfo sharedInfo = ClientsManager.getSharedInfo(request.getClientID());
        List<Begin> begins = sharedInfo.getBeginList();

        SharedInfo sharedInfoWinner = ClientsManager.getSharedInfo(request.getClientID());
        List<SetWinner> winners = sharedInfoWinner.getSetWinnerList();

        SharedInfo sharedInfoStone = ClientsManager.getSharedInfo(request.getClientID());
        List<SetStone> stones = sharedInfoStone.getSetStoneList();

        SharedInfo sharedInfoTimer = ClientsManager.getSharedInfo(request.getClientID());
        List<UpdateTimer> timers = sharedInfoTimer.getUpdateTimerList();

        //In der Zwischenzeit angefallene Funktionsaufrufe abarbeiten

        for (UpdateTimer timer : timers) {
            responseObserver.onNext(ResponseStream.newBuilder().setUpdateTimer(timer).build());
        }

        for (SetStone stone : stones) {
            responseObserver.onNext(ResponseStream.newBuilder().setSetStone(stone).build());
        }

        for (SetWinner winner : winners) {
            responseObserver.onNext(ResponseStream.newBuilder().setSetWinner(winner).build());
        }


        for (Begin begin : begins) {
            responseObserver.onNext(ResponseStream.newBuilder().setBegin(begin).build());
        }


        responseObserver.onCompleted();

         */
    }

    @Override
    public void startGame(StartRequest request, StreamObserver<code.controller.communication.game.Void> responseObserver) {
        IController con = ClientsManager.getControllerStub(request.getClientID());
        con.startGame();
        responseObserver.onNext(code.controller.communication.game.Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void makeMove(MoveRequest request, StreamObserver<code.controller.communication.game.Void> responseObserver) {
        IController con = ClientsManager.getControllerStub(request.getClientID());
        con.makeMove(request.getCol());
        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void postTwitter(TwitterRequest request, StreamObserver<TwitterSuccess> responseObserver) {
        IController con = ClientsManager.getControllerStub(request.getClientID());
        boolean res = con.postTwitter();
        responseObserver.onNext(TwitterSuccess.newBuilder().setSuccess(res).build());
        responseObserver.onCompleted();
    }
}
