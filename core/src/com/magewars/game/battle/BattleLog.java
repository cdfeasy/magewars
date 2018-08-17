package com.magewars.game.battle;

import com.magewars.game.entity.TeamWrapper;
import com.magewars.game.entity.UnitWrapper;

import java.util.ArrayList;
import java.util.List;

public class BattleLog {
    private Battle battle;

    private List<Turn> turns=new ArrayList<>();
    private String winnerId;
    private int turnNum=0;

    public BattleLog() {
    }

    public BattleLog(Battle battle) {
        this.battle = battle;
    }

    public TeamWrapper getAttacker() {
        return battle.getAttackers();
    }

    public TeamWrapper getDefender() {
        return battle.getDefenders();
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }

    public void addTurn(Turn turn){
        turn.setTurnNum(turnNum);
        turnNum++;
        this.turns.add(turn);
    }
}
