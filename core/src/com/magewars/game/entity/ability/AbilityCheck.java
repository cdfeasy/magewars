package com.magewars.game.entity.ability;

import com.magewars.game.entity.stats.Skill;

public class AbilityCheck {
    private Skill attack;
    private Skill defend;
    private Double modificator;

    public Skill getAttack() {
        return attack;
    }

    public void setAttack(Skill attack) {
        this.attack = attack;
    }

    public Skill getDefend() {
        return defend;
    }

    public void setDefend(Skill defend) {
        this.defend = defend;
    }

    public Double getModificator() {
        return modificator;
    }

    public void setModificator(Double modificator) {
        this.modificator = modificator;
    }
}
