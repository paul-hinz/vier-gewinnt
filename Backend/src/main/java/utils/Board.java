package utils;

public class Board {

    private static String translate(int val){
        if (val == 0) return " ";
        if (val == 1) return "X";
        if (val == 2) return "O";
        return "";
    }
    
    public static void printBoard(int[][] board){
        String row = "--";
        for (int i = 0; i < board[0].length; i++) {
            row = row + "----";
        }
        System.out.println(row);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("| " + translate(board[i][j]) + " ");
            }
            System.out.println("|");
            System.out.println(row);
        }
    }
}   