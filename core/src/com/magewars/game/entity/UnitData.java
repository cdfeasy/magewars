package com.magewars.game.entity;

import com.magewars.game.entity.ability.Ability;
import com.magewars.game.entity.stats.Skill;

import java.util.List;
import java.util.Map;

public class UnitData {
    private List<UnitWrapper> unitWrappers;
    private List<TeamWrapper> teamWrappers;

    public List<UnitWrapper> getUnitWrappers() {
        return unitWrappers;
    }

    public void setUnitWrappers(List<UnitWrapper> unitWrappers) {
        this.unitWrappers = unitWrappers;
    }

    public List<TeamWrapper> getTeamWrappers() {
        return teamWrappers;
    }

    public void setTeamWrappers(List<TeamWrapper> teamWrappers) {
        this.teamWrappers = teamWrappers;
    }

    public void preSave(){
        for(UnitWrapper wrappers:unitWrappers){
            wrappers.preSave();
        }
    }

    public void postLoad(Map<String, Ability> abilitiesMap, Map<String, Skill> skills){
        for(UnitWrapper wrappers:unitWrappers){
            wrappers.postLoad(abilitiesMap,skills);
        }
    }
}
