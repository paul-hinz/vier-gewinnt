package code.interfaces;

import utils.ConsoleView;
import utils.Lobby;

import java.util.List;

/**
 * Das IController Interface bietet die Schnittstellen für eine View um ein Spiel zu starten, ihm beizutreten und es durchzuführen
 */
public interface IController {

    /**
     * Ein Stein des Spielers wird in die übergebene Spalte gesetzt
     *
     * @param move Die gewählte Spalte
     */
    void makeMove(int move) ;

    /**
     * Der Owner übergibt dem Server Breite und Höhe des Spielfelds für das startende Spiel
     *
     * @param rows Reihenanzahl
     * @param columns Spaltenanzahl
     */
    void setBoardSize(int rows, int columns);

    /**
     * Der Owner übergibt dem Server die Bedenkzeit pro Zug für das startende Spiel
     * @param time Bedenkzeit pro Zug
     */
    void setGameTime(int time);

    /**
     * Der Client wählt aus, ob er gegen eine KI spielen möchte
     * @param enemy true = AI, false = Mensch
     */
    void chooseEnemy(boolean enemy);

    /**
     * Der Client erhält eine Liste an verfügbaren Lobbys
     * @return
     */
    List<Lobby> getLobbies();

    /**
     * Der Client wählt eine Lobby aus und tritt ihr als Gast bei
     *
     * @param lobby gewählte Lobby
     * @param consoleView beitretende View
     * @return Neue Lobby, null bei Misserfolg (schon voll, oder nicht existierend)
     */
    IController joinLobby(Lobby lobby, IView consoleView);

    /**
     * Der Client erstellt eine neue Lobby und tritt dieser bei. Sie wird der Liste an verfügbaren Spielen bzw. Lobbys hinzugefügt
     *
     * @return neue Lobby
     */
    Lobby createNewLobby();

    /**
     * Der Owner einer Lobby teilt dem Server mit, dass das Spiel gestartet werden soll
     */
    void startGame();

    /**
     * Der Client teilt dem Server den eigenen Namen mit
     *
     * @param playerName eigener Name
     */
    void setOwnName(String playerName);

    /**
     * Spielergebnis soll bei Twitter gepostet werden
     *
     * @return success = true
     */
    boolean postTwitter();

}
