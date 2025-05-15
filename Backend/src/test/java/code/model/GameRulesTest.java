package code.model;

import static org.junit.jupiter.api.Assertions.*;
import code.model.GameRules;
import org.junit.jupiter.api.Test;

public class GameRulesTest {

    @Test
    public void testCheckWinnerHorizontal() {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        board[2][0] = 1;
        board[2][1] = 1;
        board[2][2] = 1;
        board[2][3] = 1;

        assertTrue(GameRules.checkWinner(board));
    }

    @Test
    public void testCheckWinnerVertical() {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };


        board[0][3] = 1;
        board[1][3] = 1;
        board[2][3] = 1;
        board[3][3] = 1;

        assertTrue(GameRules.checkWinner(board));
    }

    @Test
    public void testCheckWinnerDiagonal1() {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        // Setze 4 Steine diagonal von links oben nach rechts unten für Spieler 1
        board[0][0] = 1;
        board[1][1] = 1;
        board[2][2] = 1;
        board[3][3] = 1;

        assertTrue(GameRules.checkWinner(board));
    }

    @Test
    public void testCheckWinnerDiagonal2() {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        // Setze 4 Steine diagonal von links oben nach rechts unten für Spieler 1
        board[3][0] = 1;
        board[2][1] = 1;
        board[1][2] = 1;
        board[0][3] = 1;

        assertTrue(GameRules.checkWinner(board));
    }

    @Test
    public void testMakeMove() {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        // Setze 3 Steine in die Spalte 2 für Spieler 1
        board[5][2] = 1;
        board[4][2] = 1;
        board[3][2] = 1;

        // Führe makeMove für Spalte 2 aus
        int[][] neuesBoard = GameRules.makeMove(board, 2);

        // Überprüfe, ob ein Stein in die oberste freie Position von Spalte 2 eingefügt wurde
        assertEquals(1, neuesBoard[2][2]);
    }

    @Test
    public void testSwap() {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        // Setze 3 Steine in die Spalte 2
        board[5][2] = 1;
        board[4][2] = 2;
        board[3][2] = 1;

        int[][] neuesBoard = GameRules.swap(board);

        // Überprüfe, ob alle 1en und 2en getauscht wurden
        assertEquals(2, neuesBoard[5][2]);
        assertEquals(1, neuesBoard[4][2]);
        assertEquals(2, neuesBoard[3][2]);
        }

    @Test
    public void testMakeMoveSpalteVoll() {
        int[][] board = {
                {0, 0, 2, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0}
        };// Spalte 2 ist voll

        // Führe makeMove für Spalte 3 aus
        int[][] neuesBoard = GameRules.makeMove(board, 2);

        // Überprüfe, ob sich das Spielfeld nicht geändert hat
        assertArrayEquals(board, neuesBoard);
    }
}
