package utils;

import code.controller.ClientHandler;
import code.controller.ControllerFactory;
import code.interfaces.IController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

public class ConsoleViewTest {

    private ConsoleView consoleView;
    @Mock
    private IController clientHandler;

    @BeforeEach
    void setUp() {
        consoleView = new ConsoleView(1);
        clientHandler = spy(consoleView.getController()) ;
    }

//    @Test
//    void testUpdateBoard() {
//        int[][] board = {
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0}
//        };
//
//        consoleView.updateBoard(board, 2);
//        assertArrayEquals(board, consoleView.board);
//    }
//    @Test
//    void testAiHandler(){
//        consoleView.a
//    }

    @Test
    void testSwap() {
        int[][] board = {
                {1, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        int[][] expectedBoard = {
                {2, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        consoleView.swap(board);
        assertArrayEquals(expectedBoard, consoleView.board);
    }

    @Test
    void testSetStone() {
        consoleView.setStone(3);
        int[][] expectedBoard = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 0}
        };

        assertArrayEquals(expectedBoard, consoleView.board);
    }

    // Add more test cases as needed
}

