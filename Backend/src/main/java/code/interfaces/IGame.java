package code.interfaces;

/**
 * Das Interface IGame definiert die Schnittstelle zum Modell der Spiellogik
 */
public interface IGame {

        /**
         * Führt einen Zug auf dem Spielfeld aus
         *
         * @param move gespielter Zug
         */
        void makeMove(int move);

        /**
         * Erhält anhand des aktuellen Spielstands den von der AI errechneten besten Zug zurück
         *
         * @return bester Zug
         */
        int makeBestMove();

        /**
         * Prüft den akteullen Spielstand auf einen Gewinn
         *
         * @return true, wenn der Spieler der gerade gezogen hat vier in einer Reihe hat
         */
        boolean checkWinner();

        /**
         * gibt zurück ob der owner das Spiel beginnt (Standardmäßig zu 50% ja)
         *
         * @return true, wenn der owner beginnen soll
         */
        boolean getStarter();

}
