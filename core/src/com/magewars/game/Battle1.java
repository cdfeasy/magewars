package com.magewars.game;

public class Battle {
    private BattleField battleField;
    private Team attackers;
    private Team defenders;

    public Battle() {
    }

    public Battle(BattleField battleField, Team attackers, Team defenders) {
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

    public Team getAttackers() {
        return attackers;
    }

    public void setAttackers(Team attackers) {
        this.attackers = attackers;
    }

    public Team getDefenders() {
        return defenders;
    }

    public void setDefenders(Team defenders) {
        this.defenders = defenders;
    }
}
