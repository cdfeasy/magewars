package com.magewars.game;

import com.magewars.game.entity.Unit;

import java.util.ArrayList;
import java.util.List;

public class BattleTile {
    private List<Unit> units=new ArrayList<Unit>();

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
}
