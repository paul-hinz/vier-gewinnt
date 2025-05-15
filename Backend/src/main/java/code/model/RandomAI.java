package code.model;

import java.util.ArrayList;
import java.util.Random;

/**
Standard Implementation des AI Interfaces. Ist keine "echte" AI,
 sondern wählt lediglich per 'util.Random' einen erlaubten Zug aus.
*/
public class RandomAI implements GameAI {

    private final Random r = new Random();
    @Override
    public int findBestMove(int[][] board) {
        //gültige Züge in Liste speichern
        ArrayList<Integer> moves = new ArrayList<Integer>();
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 0) moves.add(i);
        }
        //zufälligen Zug auswählen
        return moves.get(r.nextInt(0, moves.size()));
    }
}
