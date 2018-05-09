package com.magewars.game;

import com.magewars.game.entity.TeamWrapper;
import com.magewars.game.entity.UnitWrapper;

public class Battle {
    private BattleField battleField;
    private com.magewars.game.entity.TeamWrapper attackers;
    private com.magewars.game.entity.TeamWrapper defenders;

    public Battle() {
    }

    public Battle(BattleField battleField, TeamWrapper attackers, TeamWrapper defenders) {
        this.battleField = battleField;
        this.attackers = attackers;
        this.defenders = defenders;
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void setBattleField(BattleField battleField) {
        this.battleField = battleField;
    }

    public com.magewars.game.entity.TeamWrapper getAttackers() {
        return attackers;
    }

    public void setAttackers(com.magewars.game.entity.TeamWrapper attackers) {
        this.attackers = attackers;
    }

    public com.magewars.game.entity.TeamWrapper getDefenders() {
        return defenders;
    }

    public void setDefenders(TeamWrapper defenders) {
        this.defenders = defenders;
    }

    public void processBattle() {
        while (true) {
            Tactic aTactic = attackers.getTactic();
            aTactic.process(this, attackers);
            Tactic dTactic = defenders.getTactic();
            dTactic.process(this, defenders);
            boolean alive = false;
            for (com.magewars.game.entity.UnitWrapper unit : attackers.getTeam().getUnits()) {
                if (unit.getHp()> 0) {
                    alive = true;
                    break;
                }
            }
            if(!alive){
                break;
            }
            alive = false;
            for (UnitWrapper unit : defenders.getTeam().getUnits()) {
                if (unit.getHp()> 0) {
                    alive = true;
                    break;
                }
            }
            if(!alive){
                break;
            }
        }
    }
}
