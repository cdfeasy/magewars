package com.magewars.game.entity;

public class Mage {
    private String name;
    private double hp;
    private double energy;
    private double str;
    private double agility;
    private double intelligence;
    private double control;
    private double speed;
    private double endurance;
    private double melee;
    private double weapons;


    public Mage() {
    }

    public Mage(String name, int hp, int energy, int str, int agility, int control, int speed, int endurance, int melee, int weapons) {
        this.name = name;
        this.hp = hp;
        this.energy = energy;
        this.str = str;
        this.agility = agility;
        this.control = control;
        this.speed = speed;
        this.endurance = endurance;
        this.melee = melee;
        this.weapons = weapons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getStr() {
        return str;
    }

    public void setStr(double str) {
        this.str = str;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getControl() {
        return control;
    }

    public void setControl(double control) {
        this.control = control;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getEndurance() {
        return endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    public double getMelee() {
        return melee;
    }

    public void setMelee(double melee) {
        this.melee = melee;
    }

    public double getWeapons() {
        return weapons;
    }

    public void setWeapons(double weapons) {
        this.weapons = weapons;
    }

    public static void main(){

    }
}
