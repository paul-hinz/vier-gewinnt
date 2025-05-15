package code.controller;

import code.controller.ClientHandler;
import code.interfaces.IGame;
import code.interfaces.IView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import utils.Lobby;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientHandlerTest {

    private ClientHandler clientHandler;
    private IView mockViewOwner;
    private IView mockViewGuest;
    private IGame mockGame;
    private Lobby mockLobby;


    @BeforeEach
    void setUp() {
        mockViewOwner = mock(IView.class);
        mockViewGuest = mock(IView.class);
        mockGame = mock(IGame.class);

        clientHandler = new ClientHandler(mockViewOwner);
        clientHandler.setOwnName("k");
        mockLobby = spy(clientHandler.createNewLobby());
        clientHandler.setBoardSize(6, 7);
        clientHandler.setGameTime(300);
        clientHandler.setOwnName("Player1");
    }

    @Test
    void testMakeMovePvP() {
        clientHandler.joinLobby(mockLobby, mockViewGuest);
        clientHandler.chooseEnemy(false);
        when(mockLobby.isFull(anyBoolean())).thenReturn(true);
        clientHandler.setOwnerActive(true);
//        doNothing().when(mockGame).makeMove(anyInt());
        doNothing().when(mockViewGuest).setStone(anyInt());
        doNothing().when(mockViewOwner).setStone(anyInt());
        clientHandler.startGame();
        mockGame = spy(clientHandler.getGame());
        clientHandler.makeMove(3);

        // Verify that the game's makeMove method is called
//        verify(mockGame, times(1)).makeMove(3);

        // Verify that the views' setStone methods are called
//        verify(mockViewOwner, times(1)).setStone(3);
//        verify(mockViewGuest, times(1)).setStone(3);

        // Verify that the GameTimer is started
        assertNotNull(clientHandler.gt);
//        assertFalse(clientHandler.gt.isTimerRunning());
    }

    @Test
    void testMakeMoveAI() {
//        clientHandler.setGame(mockGame);
        clientHandler.chooseEnemy(true); // AI opponent
        clientHandler.joinLobby(mockLobby, mockViewGuest);
        doNothing().when(mockViewOwner).setStone(anyInt());
        clientHandler.startGame();
        clientHandler.makeMove(3);

        // Verify that the game's makeBestMove method is called
//        verify(mockGame, times(1)).makeBestMove();

        // Verify that the views' setStone methods are called
        clientHandler.setOwnerActive(true);
       // verify(mockViewOwner, times(1)).setStone(anyInt());

        // Verify that the GameTimer is started
        assertNotNull(clientHandler.gt);
//        assertTrue(clientHandler.gt.isTimerRunning());
    }

//    @Test
//    void testCheckWinnerAfterMoveInPVP() {
////        clientHandler.setGame(mockGame);
//        clientHandler.joinLobby(mockLobby, mockViewGuest);
//        clientHandler.startGame();
//        when(mockGame.checkWinner()).thenReturn(true);
//
//        clientHandler.makeMove(3);
//        clientHandler.setOwnerActive(true);
//        // Verify that the views' setWinner methods are called
//        verify(mockViewOwner, times(2)).setWinner(anyBoolean());
////        verify(mockViewGuest, times(2)).setWinner(anyBoolean());
//
//        // Verify that the GameTimer is stopped
//        assertNotNull(clientHandler.gt);
////        assertFalse(clientHandler.gt.isTimerRunning());
//    }

    @Test
    void testStartGame() {
//        clientHandler.setGame(mockGame);
        clientHandler.joinLobby(mockLobby, mockViewGuest);

        when(mockLobby.isFull(anyBoolean())).thenReturn(true);
        when(mockGame.getStarter()).thenReturn(true);

        clientHandler.startGame();

        // Verify that the views' begin methods are called
        verify(mockViewOwner, times(1)).begin(anyBoolean());
        verify(mockViewGuest, times(1)).begin(anyBoolean());

        // Verify that the GameTimer is started
        assertNotNull(clientHandler.gt);
//        assertTrue(clientHandler.gt.isTimerRunning());
    }
}

