package code.controller;


import java.util.Timer;
import java.util.TimerTask;

/**
 * Ein Timer, der einen neuen Thread startet und in einem regelmäßigen Intervall Updates sendet.
 * Die Updates geben die noch verbleibende Zeit an. Die Initialzeit wird im Konstruktor übergeben
 *
 */
public class GameTimer {

    private final int UPDATE_INTERVALL = 10;
    private final Timer timer;
    private int secondsLeft;

    public boolean isTimerRunning() {
        return timerRunning;
    }

    private boolean timerRunning;

    private final ClientHandler handler;

    /**
     *
     * @param initialSeconds Ab welchem Wert heruntergezählt wird
     * @param handler Handler, an den die Updates gesendet werden sollen
     */
    public GameTimer(int initialSeconds, ClientHandler handler) {
        this.secondsLeft = initialSeconds;
        this.timer = new Timer();
        this.timerRunning = false;
        this.handler = handler;
    }

    /**
     * Der Timer wird neu gestartet
     */
    public void startTimer() {
        timerRunning = true;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!timerRunning) {
                    cancel();
                    return;
                }
                secondsLeft--;

                // Sende Updates im Intervall
                if (secondsLeft % UPDATE_INTERVALL == 0) {
                    sendUpdates();
                }

                // Überprüfe, ob die Zeit abgelaufen ist
                if (secondsLeft <= 0) {
                    stopTimer(); // Stoppe den Timer
                    sendGameOver();
                }
            }
        }, 0, 1000); // Starten und jede Sekunde wiederholen
    }

    /**
     * Timer wird gestoppt
     */
    public void stopTimer() {
        timerRunning = false;
        timer.cancel();
    }

    /**
     * Timer sendet dem Handler ein neues Update, in Form eines Integers, der die verbleibenden Sekunden angibt
     */
    public void sendUpdates() {
        handler.updateTimer(secondsLeft);
    }

    public void sendGameOver() {
        handler.gameOver();
    }
}

