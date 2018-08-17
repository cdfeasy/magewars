package com.magewars.game.battle;

import com.magewars.game.BattleField;
import com.magewars.game.Tactic;
import com.magewars.game.entity.TeamWrapper;
import com.magewars.game.entity.UnitWrapper;

public class Battle {
    private BattleField battleField;
    private TeamWrapper attackers;
    private TeamWrapper defenders;
    private BattleLog log;

    public Battle() {
    }

    public Battle(BattleField battleField, TeamWrapper attackers, TeamWrapper defenders) {
        this.battleField = battleField;
        this.attackers = attackers;
        this.defenders = defenders;
        this.log=new BattleLog(this);
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void setBattleField(BattleField battleField) {
        this.battleField = battleField;
    }

    public TeamWrapper getAttackers() {
        return attackers;
    }

    public void setAttackers(TeamWrapper attackers) {
        this.attackers = attackers;
    }

    public TeamWrapper getDefenders() {
        return defenders;
    }

    public void setDefenders(TeamWrapper defenders) {
        this.defenders = defenders;
    }

    public BattleLog getLog() {
        return log;
    }

    public void setLog(BattleLog log) {
        this.log = log;
    }

    public void processBattle() {
        while (true) {
            boolean end = processTurn();
            if (end) {
                break;
            }
        }
    }

    public boolean processTurn() {
        Tactic aTactic = attackers.getTactic();
        log.addTurn(new Turn(aTactic.process(this, attackers)));
        Tactic dTactic = defenders.getTactic();
        log.addTurn(new Turn(dTactic.process(this, defenders)));
        boolean alive = false;
        for (UnitWrapper unit : attackers.getTeam().getUnits()) {
            if (unit.getHp() > 0) {
                alive = true;
                break;
            }
        }
        if (!alive) {
            return true;
        }
        alive = false;
        for (UnitWrapper unit : defenders.getTeam().getUnits()) {
            if (unit.getHp() > 0) {
                alive = true;
                break;
            }
        }
        if (!alive) {
            return true;
        }
        return false;
    }
}
