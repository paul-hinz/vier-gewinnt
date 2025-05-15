package utils;

import code.controller.ControllerFactory;
import code.interfaces.IController;
import code.interfaces.IView;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Eine Implementierung des View Interfaces, dass ein Spiel (gegen einen KI-Gegner) in der Konsole bietet.
 * Bei Ablauf der Zeit ist noch eine Eingabe möglich, dieser Fall stellt einen Fehler dar, wird hier aber ignoriert.
 */
public class ConsoleView implements IView, Runnable {

    private IController controller;
    private boolean endGame = false ;
    private Scanner scanner ;
    private boolean playerMode ;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    private final int threadNumber;

    private String symbol = "";
    private boolean myTurn = false;



    private Lobby lobby ;

    public String playerName ;
    private String enemyName = null;
    private boolean isStarter;

    public int[][] board = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };

    public ConsoleView(int threadNumber) {
        this.threadNumber = threadNumber;
        controller = ControllerFactory.getInstance(this);
    }

    public static void main(String[] args){
        ConsoleView cv = new ConsoleView(1);
        ConsoleView gcv = new ConsoleView(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        cv.go(executorService,cv, gcv );
//        cv.updateBoard();
    }

    public void go(ExecutorService executorService, ConsoleView player1, ConsoleView player2 ){
        System.out.println("Willkommen bei VierGewinnt auf der Konsole! \n");
        scanner = new Scanner(System.in);
        setPlayerMode();
        if(playerMode){
            aiHandler();
        }
        else{
            pvpHandler(executorService,player1,player2);
        }
        scanner.close();
    }
    private void pvpHandler(ExecutorService executorService, ConsoleView player1, ConsoleView player2){
        setPlayerName();
        String enemy = setEnemyName();
        player2.playerName = enemy;
        player2.getController().setOwnName(enemy);
        controller.createNewLobby();
        lobby = controller.getLobbies().get(0);
        controller.joinLobby(lobby, this);
        //   guestView.getController().setOwnName("Enemy");
        player2.joinLobby(lobby);
        //player2.controller.joinLobby(lobby,player2);
        player2.setLobby(lobby);
        controller.chooseEnemy(this.playerMode);
        setTime();
        controller.setBoardSize(6,7);
        controller.startGame();

        if (!isStarter){
            swap(board);
            //Board.printBoard(board);
        }
        executorService.execute(player1);
        executorService.execute(player2);
        while (!endGame){
            executorService.shutdown();
        }
    }

    private void joinLobby(Lobby lobby) {
        controller = controller.joinLobby(lobby, this);
        this.lobby = lobby;
    }

    private void aiHandler(){
        setPlayerName();
        controller.createNewLobby();
        controller.chooseEnemy(this.playerMode);
        setTime();
        controller.setBoardSize(6,7);
        controller.startGame();

        if (!isStarter){
            swap(board);
            Board.printBoard(board);
        }

        while (!endGame){
            int move = chooseColumn();
            controller.makeMove(move);
            swap(board);
            Board.printBoard(board);
        }
    }

    private int chooseColumn(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(this.playerName + symbol + ", wähle die Spalte für den nächsten Zug: ");
        int intValue = scanner.nextInt();
        boolean suc = updateBoard(board, intValue);
        while(!suc){
            System.out.println("Zug war ungültig, wähle neu (Erste Spalte ist 0): ");
            intValue = scanner.nextInt();
            suc = updateBoard(board, intValue);
        }

        if (threadNumber == 2){
            Board.printBoard(board);
            swap(board);
        }
        else{
            swap(board);
            Board.printBoard(board);
        }
        return intValue;
    }

    private void setPlayerMode() {
        String userInput = "";
        while(!(userInput.equalsIgnoreCase("AI") || userInput.equalsIgnoreCase("PVP"))) {
            System.out.print("AI oder PvP: ");
            userInput = scanner.nextLine();
        }
        playerMode  = userInput.equalsIgnoreCase("AI");
        controller.chooseEnemy(playerMode);
    }

    private void setPlayerName() {
        System.out.print("Gib deinen Namen ein:");
        String userInput = scanner.nextLine();
        this.playerName = userInput;
        controller.setOwnName(userInput);
    }

    private String setEnemyName() {
        System.out.print("Gib den Namen deines Gegners ein:");
        String userInput = scanner.nextLine();
        this.enemyName = userInput;
        return userInput;
    }

    private void setTime() {
        System.out.print(this.playerName + ", wähle die Bedenkzeit pro Zug in Sekunden: ");
        controller.setGameTime(scanner.nextInt());
    }

    private boolean updateBoard(int[][] board, int col) {
        if (col >= board[0].length){
            System.out.println("Zug außerhalb des Boards");
            return false;
        }
        // Finde das oberste freie Feld in der Spalte
        int row = board.length - 1; // Die oberste Reihe ist 5, die unterste ist 0
        while (row >= 0 && board[row][col] != 0) {
            row--;
        }

        // Überprüfe, ob die Spalte voll ist
        if (row < 0) {
            System.out.println("Spalte ist voll. Kein Zug möglich.");
            return false;
        }

        // Füge den Stein in das oberste freie Feld der Spalte ein
        board[row][col] = 1;
        this.board = board;
        return true;
    }

    public void swap(int[][] board){
        // Tausche alle 1en und 2en im Spielfeld
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 2;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
        this.board = board;
    }



    @Override
    public void setStone(int stone) {
        updateBoard(board, stone);
        swap(board);
        myTurn = true;
    }

    @Override
    public IController getController() {
        return controller;
    }

    @Override
    public void updateTimer(int time) {
        System.out.println("\n Du hast " + time + " Sekunden übrig");
    }

    @Override
    public void setBoardParams(int rows, int columns) {

    }

    @Override
    public void setTime(int time) {

    }

    @Override
    public void begin(boolean start) {
        isStarter = start;
        myTurn = start;
        if (threadNumber == 2){
            symbol = " (X)";
        }
        else{
            symbol = " (0)";
        }
        if(enemyName == null) {
            this.enemyName = "kitty";
        }
        if(playerName == null) {
            this.playerName = "kitty";
        }
    }

    @Override
    public void setWinner(boolean winner) {
        endGame = true;

        if (winner){
            System.out.println(playerName + ", du hast gewonnen!");
        }
        else {
            System.out.println(playerName + ", du hast verloren!");
        }

    }

    @Override
    public void setEnemyName(String name) {
        //TODO?
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void run() {
        while (!endGame){
            lock.lock();
            try {
                while (!myTurn) {
                    // Wait for the correct turn
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                    if(!endGame) {
                        //ensure game isnt over
                        int move = chooseColumn();

                        // Change the turn
                        myTurn = false;
                        controller.makeMove(move);
                    }

                // Notify all waiting threads

                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}
