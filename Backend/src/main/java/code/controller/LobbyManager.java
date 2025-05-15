package code.controller;

import code.interfaces.IView;
import utils.Lobby;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Der LobbyManager verwaltet die Liste an offenen Spiellobbys.
 */
public class LobbyManager {

    private static int nextID = 0;

    private static final Map<Integer, Lobby> lobbys = new ConcurrentHashMap<>();


    public static List<Lobby> getLobbys(){
        return lobbys.values().stream().toList();
    }

    public static Lobby getLobby(int id){
        return lobbys.get(id);
    }

    public static void joinLobby(Lobby l, String name, IView view){
        l.addPlayer(name, view);

    }

    /**
     * Erstellt eine neue Lobby und weist dieser eine freie ID zu.
     *
     * @param name Name des Besitzers (Ersteller)
     * @param ch ClientHandler-Objekt, dass das Spielgeschehen in dieser Lobby organisiert
     * @return neue Lobby
     */
    public synchronized static Lobby newLobby (String name, ClientHandler ch){ //name of lobby creator
        nextID ++;
        Lobby l = new Lobby(name, ch, nextID);
        lobbys.put(nextID, l);
        return l;
    }

}
