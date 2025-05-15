package code.interfaces;

/**
 * Das IView Interface bietet die Schnittstellen für eine Controller an um ein Spiel zu starten, über den Gegner zu informieren und updates zum Spielstand zu senden
 */
public interface IView {

    /**
     * Ein Stein des Gegenspielers wird in die übergebene Spalte gesetzt und dargestellt.
     * @param stone Spalte
     */
    void setStone(int stone);

    /**
     * Der Server teilt dem Client die ihm noch verbleibende Zeit mit, der Client passt diese dann bei Bedarf entsprechend an
     *
     * @param time verbleibende Zeit in Sekunden
     */
    void updateTimer(int time);

    /**
     * Der Server übergibt dem (zweiten) Spieler Breite und Höhe (je mindestens 4) des Spielfelds für das startende Spiel
     * @param rows Anzahl Reihen
     * @param columns Anzahl Spalten
     */
    void setBoardParams(int rows, int columns);


    /**
     * Der Server übergibt dem (zweiten) Spieler die Bedenkzeit pro Zug für das startende Spiel
     * @param time Zeit in Sekunden
     */
    void setTime(int time);

    /**
     * Der Server teilt dem Client mit, dass das Spiel jetzt startet und teilt mit, wer beginnt
     *
     * @param start true = angesprochenen View beginnt
     */
    void begin(boolean start);

    /**
     * Der Server teilt dem Client mit, dass das Spiel beendet wurde und teilt mit, wer gewonnen hat
     * @param winner true = angesprochenen View hat gewonnen
     */
    void setWinner(boolean winner);

    /**
     * Server teilt der View den Namen des Gegners mit
     * @param name Name des Gegners
     */
    void setEnemyName(String name);

    IController getController();

}