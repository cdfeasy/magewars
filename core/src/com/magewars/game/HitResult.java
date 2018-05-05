package com.magewars.game;

public class HitResult {
    private double dmg;
    private double attackerCost;
    private double defenderCost;

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
}
