package com.magewars.game.battle;

import com.magewars.game.entity.ability.Ability;

public class HitResult {
    private Ability ability;
    private double hitRoll;
    private double hitModificator;
    private double dmg;
    private double attackerCost;
    private double defenderCost;

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public double getHitModificator() {
        return hitModificator;
    }

    public void setHitModificator(double hitModificator) {
        this.hitModificator = hitModificator;
    }

    public double getHitRoll() {
        return hitRoll;
    }

    public void setHitRoll(double hitRoll) {
        this.hitRoll = hitRoll;
    }

    public double getDmg() {
        return dmg;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }

    public double getAttackerCost() {
        return attackerCost;
    }

    public void setAttackerCost(double attackerCost) {
        this.attackerCost = attackerCost;
    }

    public double getDefenderCost() {
        return defenderCost;
    }

    public void setDefenderCost(double defenderCost) {
        this.defenderCost = defenderCost;
    }

    public void addAttackerCost(double attackerCost) {
        this.attackerCost += attackerCost;
    }

    public void addDefenderCost(double defenderCost) {
        this.defenderCost += defenderCost;
    }

    public void addDmg(double dmg) {
        this.dmg += dmg;
    }

    @Override
    public String toString() {
        return "HitResult{" +
                "ability=" + ability.getName()+
                ", dmg=" + dmg +
                ", hitRoll=" + hitRoll +
                ", mod=" + hitModificator +
                ", attackerCost=" + attackerCost +
                ", defenderCost=" + defenderCost +
                '}';
    }
}
