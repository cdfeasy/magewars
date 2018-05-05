package com.magewars.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.magewars.game.entity.UnitWrapper;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private String id;
    @JsonIgnore
    private List<UnitWrapper> units;

    private List<String> unitsIds;

    public Team(String name) {
        this.name = name;
        this.id = name;
    }

    public Team() {
    }

    public Team(List<UnitWrapper> units) {
        this.units = units;
        this.unitsIds=new ArrayList<String>();
        for(UnitWrapper wrapper:units){
            unitsIds.add(wrapper.getUnitId());
        }
    }

    public Team(String name, List<UnitWrapper> units) {
        this(units);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.magewars.game.entity.UnitWrapper> getUnits() {
        if (units == null) {
            units = new ArrayList<com.magewars.game.entity.UnitWrapper>();
        }
        return units;
    }

    public void addUnit(com.magewars.game.entity.UnitWrapper wrapper) {
        getUnits().add(wrapper);
        wrapper.getUnit().setTeam(this);
    }


    public void setUnits(List<UnitWrapper> units) {
        this.units = units;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getUnitsIds() {
        return unitsIds;
    }

    public void setUnitsIds(List<String> unitsIds) {
        this.unitsIds = unitsIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        return id != null ? id.equals(team.id) : team.id == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
