package com.magewars.game.entity;

public class Mage {
    private String name;
    private int hp;
    private int energy;
    private int str;
    private int agl;
    private int control;
    private int speed;
    private int end;
    private int melee;
    private int weapons;


    public Mage() {
    }

    public Mage(String name, int hp, int energy, int str, int agl, int control, int speed, int end, int melee, int weapons) {
        this.name = name;
        this.hp = hp;
        this.energy = energy;
        this.str = str;
        this.agl = agl;
        this.control = control;
        this.speed = speed;
        this.end = end;
        this.melee = melee;
        this.weapons = weapons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getAgl() {
        return agl;
    }

    public void setAgl(int agl) {
        this.agl = agl;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getMelee() {
        return melee;
    }

    public void setMelee(int melee) {
        this.melee = melee;
    }

    public int getWeapons() {
        return weapons;
    }

    public void setWeapons(int weapons) {
        this.weapons = weapons;
    }

    public static void main(){

    }
}
