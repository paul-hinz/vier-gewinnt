package code.model;

public interface GameAI {


    /**
     * Gibt den besten Wert zurück
     * @param board Spielstand mit 2 = zu ziehender Spieler
     * @return Spalte, die die KI als besten Zug identifiziert hat
     */
    int findBestMove(int[][] board);

}
