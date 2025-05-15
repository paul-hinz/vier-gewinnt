package code.controller;


import code.interfaces.IView;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;

class GameTimerTest {

    @Mock
    private IView view;

    private final ClientHandler clientHandler = spy(new ClientHandler(view));

    @Test
    void testStartTimer() throws InterruptedException {

        doNothing().when(clientHandler).updateTimer(anyInt());
        doNothing().when(clientHandler).gameOver();
        int total_seconds = 20;
        GameTimer gameTimer = new GameTimer(total_seconds, clientHandler);
        gameTimer.startTimer();

        TimeUnit.SECONDS.sleep(total_seconds + 2);

        verify(clientHandler, atLeast(2)).updateTimer(anyInt());

    }

    @Test
    void testSendUpdates() {

        doNothing().when(clientHandler).updateTimer(anyInt());
        doNothing().when(clientHandler).gameOver();
        GameTimer gameTimer = new GameTimer(10, clientHandler);
        gameTimer.sendUpdates();

        // Ensure that the updateTimer method was called once
        verify(clientHandler, times(1)).updateTimer(anyInt());
    }

    @Test
    void testSendGameOver() {
        doNothing().when(clientHandler).updateTimer(anyInt());
        doNothing().when(clientHandler).gameOver();
        GameTimer gameTimer = new GameTimer(10, clientHandler);

        gameTimer.sendGameOver();

        // Ensure that the gameOver method was called once
        verify(clientHandler, times(1)).gameOver();
    }


}