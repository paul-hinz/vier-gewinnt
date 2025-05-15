package code.model;

/**
 * Abstrakte klasse, die Methoden zur Spiellogik bereitstellt.
 */
public abstract class GameRules {

    /**
     * Prüft, ob Spieler 1 gewonnen hat
     * @param board aktueller Spielstand mit 1 = zuletztgezogener Spieler
     * @return true = gewonnen
     */
    public static boolean checkWinner(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Überprüfe horizontal
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols - 3; col++) {
                if (board[row][col] == 1 &&
                        board[row][col + 1] == 1 &&
                        board[row][col + 2] == 1 &&
                        board[row][col + 3] == 1) {
                    return true;
                }
            }
        }

        // Überprüfe vertikal
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows - 3; row++) {
                if (board[row][col] == 1 &&
                        board[row + 1][col] == 1 &&
                        board[row + 2][col] == 1 &&
                        board[row + 3][col] == 1) {
                    return true;
                }
            }
        }

        // Überprüfe diagonale von links oben nach rechts unten
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < cols - 3; col++) {
                if (board[row][col] == 1 &&
                        board[row + 1][col + 1] == 1 &&
                        board[row + 2][col + 2] == 1 &&
                        board[row + 3][col + 3] == 1) {
                    return true;
                }
            }
        }

        // Überprüfe diagonale von rechts oben nach links unten
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 3; col < cols; col++) {
                if (board[row][col] == 1 &&
                        board[row + 1][col - 1] == 1 &&
                        board[row + 2][col - 2] == 1 &&
                        board[row + 3][col - 3] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Führt einen Zug auf dem übergebenen Board aus
     *
     * @param board aktueller Spielstand
     * @param col Spalte, in die der nächste Stein gesetzt wird
     * @return neuer Spielstand
     */
    public static int[][] makeMove(int[][] board, int col) {
        // Finde das unterste freie Feld in der Spalte
        int row = board.length - 1; // Die unterste Reihe ist 5, die unterste ist 0
        while (row >= 0 && board[row][col] != 0) {
            row--;
        }

        // Überprüfe, ob die Spalte voll ist
        if (row < 0) {
            //TODO: echtes Fehlerhandling
            System.out.println("Spalte ist voll. Kein Zug möglich.");
            return board; // Spalte voll, kein Zug möglich
        }

        // Füge den Stein in das oberste freie Feld der Spalte ein
        board[row][col] = 1;
        return board;
    }

    /**
     * Tauscht alle 1en und 2en auf dem Board, um die richtige Zugreihenfolge zu repräsentieren
     * @param board aktueller Spielstand
     * @return neuer Spielstand
     */
    public static int[][] swap(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Tausche alle 1en und 2en im Spielfeld
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 2;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
        return board;
    }
}
