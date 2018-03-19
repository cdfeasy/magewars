package com.magewars.game.entity.stats;

public class BattleSkill extends Skill{
    public BattleSkill() {
        setId("weaponSkill"+this.getClass().getSimpleName());
    }

    public BattleSkill(String id) {
        super(id);
    }

    public BattleSkill(String id, double value) {
        super(id,value);
    }
}