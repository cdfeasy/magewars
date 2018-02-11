package com.magewars.game.entity;

public class WeaponSkills {
    private double melee;
    private double weapon;
    private double throwing;

    public WeaponSkills() {
    }

    public WeaponSkills(double melee, double weapon, double throwing) {
        this.melee = melee;
        this.weapon = weapon;
        this.throwing = throwing;
    }

    public double getMelee() {
        return melee;
    }

    public void setMelee(double melee) {
        this.melee = melee;
    }

    public double getWeapon() {
        return weapon;
    }

    public void setWeapon(double weapon) {
        this.weapon = weapon;
    }

    public double getThrowing() {
        return throwing;
    }

    public void setThrowing(double throwing) {
        this.throwing = throwing;
    }
}
