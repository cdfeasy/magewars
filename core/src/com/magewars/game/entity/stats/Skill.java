package com.magewars.game.entity.stats;

public class Skill {
    protected String id;
    protected double value;

    public Skill() {
    }

    public Skill(String id) {
        this.id = id;
    }

    public Skill(String id, double value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void change(double delta){
        this.value=value+delta;
    }
}
