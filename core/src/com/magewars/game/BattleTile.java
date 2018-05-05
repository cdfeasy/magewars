package com.magewars.game;

import com.magewars.game.entity.UnitWrapper;

import java.util.ArrayList;
import java.util.List;

public class BattleTile {
    private int id;
    private ArrayList<com.magewars.game.entity.UnitWrapper> units=new ArrayList<com.magewars.game.entity.UnitWrapper>();

    public List<com.magewars.game.entity.UnitWrapper> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<com.magewars.game.entity.UnitWrapper> units) {
        this.units = units;
    }

    public BattleTile() {
    }

    public BattleTile(int id) {
        this.id = id;
    }

    public BattleTile(int id, ArrayList<UnitWrapper> units) {
        this.id = id;
        this.units = units;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
