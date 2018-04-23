package com.magewars.game;

import com.magewars.game.entity.Unit;

import java.util.List;

public class Team {
    private String name;
    private List<Unit> units;

    public Team() {
    }

    public Team(List<Unit> units) {
        this.units = units;
    }

    public Team(String name, List<Unit> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
}
