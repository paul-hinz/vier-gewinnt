package utils;

import code.controller.ClientHandler;
import code.interfaces.IGame;
import code.interfaces.IView;
import code.model.ModelManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LobbyTest {

    private Lobby lobby;
    private ClientHandler clientHandler;
    private IView view;
    private IGame game;

    @BeforeEach
    void setUp() {
        view = new ConsoleView(1);
        clientHandler = new ClientHandler(view);
        lobby = new Lobby("Owner", clientHandler, 1);
        game = new ModelManager(7,6,true);
    }

    @Test
    void testAddPlayer() {
        lobby.addPlayer("OtherPlayer", view);
        assertEquals("OtherPlayer", lobby.getOtherName());
        assertEquals(view, lobby.otherView);
    }

    @Test
    void testIsFull() {
        assertFalse(lobby.isFull(false));
        lobby.addPlayer("OtherPlayer", view);
        assertTrue(lobby.isFull(false));
    }

    @Test
    void testSetAndGetGame() {
        assertNull(lobby.getGame());
        lobby.setGame(game);
        assertEquals(game, lobby.getGame());
    }

    @Test
    void testIsGameRunning() {
        assertFalse(lobby.isGameRunning());
        lobby.setGame(game);
        assertTrue(lobby.isGameRunning());
    }

    @Test
    void testGetOwnerName() {
        assertEquals("Owner", lobby.getOwnerName());
    }

    @Test
    void testGetOtherName() {
        assertEquals("", lobby.getOtherName());
        lobby.addPlayer("OtherPlayer", view);
        assertEquals("OtherPlayer", lobby.getOtherName());
    }

    @Test
    void testSetAndGetGameTime() {
        lobby.setGameTime("Owner", 10);
        assertEquals(10, lobby.getGameTime());

        // Ensure that gameTime is not set for other players
        lobby.setGameTime("OtherPlayer", 20);
        assertEquals(10, lobby.getGameTime());
    }

    @Test
    void testGetOwnerID() {
        assertEquals(0, lobby.getOwnerID());
        lobby.setOwnerID(5);
        assertEquals(5, lobby.getOwnerID());
    }

    @Test
    void testGetOtherID() {
        assertEquals(0, lobby.getOtherID());
        lobby.setOtherID(10);
        assertEquals(10, lobby.getOtherID());
    }
}

