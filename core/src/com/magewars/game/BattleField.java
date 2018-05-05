package com.magewars.game;

import java.util.ArrayList;
import java.util.List;

public class BattleField {
    private List<BattleTile> tiles = new ArrayList<BattleTile>();

    public BattleField() {
    }

    public BattleField(List<BattleTile> tiles) {
        this.tiles = tiles;
    }

    public BattleField(int cnt) {
        this.tiles = new ArrayList<BattleTile>();
        for (int i = 0; i < cnt; i++) {
            tiles.add(new BattleTile(i));
        }
    }

    public List<BattleTile> getTiles() {
        return tiles;
    }

    public void setTiles(List<BattleTile> tiles) {
        this.tiles = tiles;
    }
}
