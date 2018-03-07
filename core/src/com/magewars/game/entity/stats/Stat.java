package com.magewars.game.entity.stats;

public class Stat extends Skill {
    public Stat() {
        setId("stat"+this.getClass().getSimpleName());
    }

    public Stat(String id) {
        super(id);
    }

    public Stat(String id, double value) {
        super(id,value);
    }
}
