package code.model;

import code.controller.ClientHandler;
import code.interfaces.IGame;
import code.interfaces.IView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

public class ModelManagerTest {
    private IGame game;

    @BeforeEach
    void setUp() {
        game = new ModelManager(7, 6, false);
    }

    @Test
    public void testCheckWinner() {


        assertFalse(game.checkWinner());

        game.makeMove(0);
        game.makeMove(0); //enemy
        game.makeMove(1);
        game.makeMove(6); //enemy
        game.makeMove(2);
        game.makeMove(5); //enemy
        game.makeMove(3);
        game.makeMove(0); //enemy
        game.makeMove(4);

        assertTrue(game.checkWinner());
    }

    @Test
    public void testGetStarter() {

        assertNotNull(game.getStarter());
    }
}

