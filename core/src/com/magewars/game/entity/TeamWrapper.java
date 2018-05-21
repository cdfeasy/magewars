package com.magewars.game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.magewars.game.BattleTile;
import com.magewars.game.Tactic;
import com.magewars.game.Team;
import com.magewars.game.entity.UnitWrapper;
import com.magewars.game.tactics.FrontalAssault;

public class TeamWrapper {
    private Team team;
    @JsonIgnore
    private Tactic tactic;
    private String tacticId;

    public TeamWrapper() {
    }

    public TeamWrapper(Team team, BattleTile tile) {
        this.team = team;
        for(UnitWrapper unit:team.getUnits()){
            unit.setTile(tile);
            tile.getUnits().add(unit);
        }
    }

    public void refresh(){

    }

    public void postLoad(){
        if ("FrontalAssault".equals(tacticId)){
            tactic=new FrontalAssault();
        }


    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Tactic getTactic() {
        return tactic;
    }

    public void setTactic(Tactic tactic) {
        this.tactic = tactic;
    }

    public String getTacticId() {
        return tacticId;
    }

    public void setTacticId(String tacticId) {
        this.tacticId = tacticId;
    }
}
