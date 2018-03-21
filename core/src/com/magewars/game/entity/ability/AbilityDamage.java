package com.magewars.game.entity.ability;

import com.magewars.game.entity.Damage;
import com.magewars.game.entity.stats.Skill;

import java.util.Map;

public class AbilityDamage {
    private Map<Skill,Double> modificators;
    private Damage damageType;
    private Double damage;

    public Map<Skill, Double> getModificators() {
        return modificators;
    }

    public void setModificators(Map<Skill, Double> modificators) {
        this.modificators = modificators;
    }

    public Damage getDamageType() {
        return damageType;
    }

    public void setDamageType(Damage damageType) {
        this.damageType = damageType;
    }

    public Double getDamage() {
        return damage;
    }

    public void setDamage(Double damage) {
        this.damage = damage;
    }
}
