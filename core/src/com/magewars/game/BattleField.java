package com.magewars.game;

import java.util.ArrayList;
import java.util.List;

public class BattleField {
    private List<BattleTile> tiles=new ArrayList<BattleTile>();

    public List<BattleTile> getTiles() {
        return tiles;
    }

    public void setTiles(List<BattleTile> tiles) {
        this.tiles = tiles;
    }
}
