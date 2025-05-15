package code.communication.game;

import code.controller.communication.game.Begin;
import code.controller.communication.game.SetStone;
import code.controller.communication.game.SetWinner;
import code.controller.communication.game.UpdateTimer;

import java.util.ArrayList;
import java.util.List;

public class SharedInfo {
    private final List<SetStone> setStoneList = new ArrayList<>();
    private final List<SetWinner> setWinnerList = new ArrayList<>();
    private final List<UpdateTimer> updateTimerList = new ArrayList<>();
    private final List<Begin> beginList = new ArrayList<>();

    public synchronized List<SetStone> getSetStoneList() {
        return new ArrayList<>(setStoneList);
    }

    public synchronized void addSetStone(SetStone setStone) {
        setStoneList.add(setStone);
    }

    public synchronized List<SetWinner> getSetWinnerList() {
        return new ArrayList<>(setWinnerList);
    }

    public synchronized void addSetWinner(SetWinner setWinner) {
        setWinnerList.add(setWinner);
    }

    public synchronized List<UpdateTimer> getUpdateTimerList() {
        return new ArrayList<>(updateTimerList);
    }

    public synchronized void addUpdateTimer(UpdateTimer updateTimer) {
        updateTimerList.add(updateTimer);
    }

    public synchronized List<Begin> getBeginList() {
        return new ArrayList<>(beginList);
    }

    public synchronized void addBegin(Begin begin) {
        beginList.add(begin);
    }
}