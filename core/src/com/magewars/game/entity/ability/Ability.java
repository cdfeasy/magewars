package com.magewars.game.entity.ability;

import com.magewars.game.entity.stats.Skill;

import java.util.List;
import java.util.Map;

public class Ability {
    protected String id;
    protected AbilityCost cost;
    protected String name;
    protected String description;
    protected Map<Skill,Double> requirement;
    protected List<AbilityCheck> checks;

    public Ability() {

    }

    public Ability(String id) {
        this.id = id;
    }

    public Ability(String id, AbilityCost cost) {
        this.id = id;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AbilityCost getCost() {
        return cost;
    }

    public void setCost(AbilityCost cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Skill, Double> getRequirement() {
        return requirement;
    }

    public void setRequirement(Map<Skill, Double> requirement) {
        this.requirement = requirement;
    }
}
