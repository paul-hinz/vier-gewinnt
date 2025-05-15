package code.model;
import code.interfaces.*;

import java.util.Arrays;
import java.util.Random;

/**
 * Der ModelManager verwaltet die Spielstände sowie Logik bzw. Regeln.
 * Er wird verwendet, um Züge durchzuführen, auf Gewinnstände zu prüfen, die KI einen Zug berechnen zulassen
 * und, um sich für einen Startspieler zu entscheiden
 *
 */
public class ModelManager implements IGame {

    private int[][] board;

    public boolean starter;

    public ModelManager(int columns, int rows, boolean aiNeeded) {
        //Board erstellen und mit 0en befüllen
        this.board = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(this.board[i], 0);
        }

        //Startspieler generieren
        Random r = new Random();
        starter = r.nextBoolean();

        //GameAI zuweisen, TODO: Factory-Pattern
        //if (aiNeeded)
            //gameAi = new GameAiImpl();
            gameAi = new RandomAI();
    }

    private final GameAI gameAi;

    @Override
    public void makeMove(int move) {
        board = GameRules.makeMove(board, move);
        board = GameRules.swap(board);
    }

    @Override
    public int makeBestMove() {
        int bestMove = gameAi.findBestMove(board);
        makeMove(bestMove);
        return bestMove;
    }

    @Override
    public boolean checkWinner() {
        board = GameRules.swap(board);
        boolean res =  GameRules.checkWinner(board);
        board = GameRules.swap(board);
        return res;
    }

    @Override
    public boolean getStarter() {
        return starter;
    }


}
