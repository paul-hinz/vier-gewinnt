package code.communication.game;

import code.controller.communication.game.ResponseStream;
import io.grpc.stub.StreamObserver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Der ClientManager verwaltet die ClientIds. Er wird verwendet, um neue Clients anzumelden
 * und, um anhand ihrer ID die zugehörigen Stubs oder Streams zu erhalten.
 *
 */
public class ClientsManager {

    private static final Map<Integer, StreamObserver<ResponseStream>> clientStreams = new ConcurrentHashMap<>();
    private static final Map<Integer, ControllerStub> controllerStubs = new ConcurrentHashMap<>();
    private static final Map<Integer, ViewStub> viewStubs = new ConcurrentHashMap<>();
    private static final Map<Integer, SharedInfo> infos = new ConcurrentHashMap<>();
    private static int lastID = 0;

    public static void registerClient(Integer clientId, StreamObserver<ResponseStream> responseObserver) {
        System.out.println(clientId + ": Stream registriert");
        clientStreams.put(clientId, responseObserver);
    }

    public static void unregisterClient(Integer clientId) {
        clientStreams.get(clientId).onCompleted();
        clientStreams.remove(clientId);
    }

    /**
     * Schickt das übergebene ResponseStream Objekt an den Client.
     * Vorrausgesetzt wird, dass der Stream noch offen ist
     *
     * @param clientId ID des Clients
     * @param response zu sendende Nachricht
     */
    public static void sendMessageToClient(Integer clientId, ResponseStream response) {
        StreamObserver<ResponseStream> clientStream = clientStreams.get(clientId);

        if (clientStream != null) {
            System.out.println("Response wird gesendet");
            clientStream.onNext(response);
        }
        else{
            System.err.println("Kein Response stream für" + clientId + "gefunden");
        }
    }

    /**
     * Erstellt für diesen Client einen neuen ViewStub, sowie einen neuen ControllerStub und ordnet sie zu
     * @param clientID
     */
    public static void newClient(Integer clientID){
        ViewStub vStub = new ViewStub(clientID);
        ControllerStub cStub = new ControllerStub(clientID, vStub);
        SharedInfo info = new SharedInfo();
        controllerStubs.put(clientID, cStub);
        viewStubs.put(clientID, vStub);
        infos.put(clientID, info);
        //setStub(clientID, stub);
    }

    public static void setStub (Integer clientID, ControllerStub stub){
        controllerStubs.put(clientID, stub);
    }

    public static ControllerStub getControllerStub(Integer clientID) {
        return controllerStubs.get(clientID);
    }

    public static SharedInfo getSharedInfo(int clientID){
        return infos.get(clientID);
    }

    public static ViewStub getViewStub(Integer clientID) {
        return viewStubs.get(clientID);
    }

    public static void deleteStub( Integer clientID){
        controllerStubs.remove(clientID);
    }

    /**
     * Gibt die nächste freie ID aus
     * @return generierte ID
     */
    public static synchronized int getNewID(){
        lastID ++;
        return lastID;
    }

}
