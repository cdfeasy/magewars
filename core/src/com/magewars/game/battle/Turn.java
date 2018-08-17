package com.magewars.game.battle;

import java.util.List;

public class Turn {
    private int turnNum;
    private List<TurnResult> results;

    public Turn(List<TurnResult> results) {
        this.turnNum = turnNum;
        this.results = results;
    }

    public Turn() {
    }

    public int getTurnNum() {
        return turnNum;
    }

    public void setTurnNum(int turnNum) {
        this.turnNum = turnNum;
    }

    public List<TurnResult> getResults() {
        return results;
    }

    public void setResults(List<TurnResult> results) {
        this.results = results;
    }
}
