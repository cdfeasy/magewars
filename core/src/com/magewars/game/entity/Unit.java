package com.magewars.game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.magewars.game.Team;
import com.magewars.game.entity.ability.Ability;
import com.magewars.game.entity.stats.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Unit {
    private String name;
    private String id;
    private Double hp;
    private Double energy;
    private Team team;

    @JsonIgnore
    private Map<Skill, Double> skills;
    private Map<String, Double> skillsIds;

    private List<String> abilitiesIds;
    @JsonIgnore
    private List<Ability> abilities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Ability> getAbilities() {
        if (abilities == null) {
            abilities = new ArrayList<Ability>();
        }
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    public void setSkills(Map<Skill, Double> skills) {
        this.skills = skills;
    }

    public Map<Skill, Double> getSkills() {
        if (skills == null) {
            skills = new HashMap<Skill, Double>();
        }
        return skills;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Double> getSkillsIds() {
        return skillsIds;
    }

    public void setSkillsIds(Map<String, Double> skillsIds) {
        this.skillsIds = skillsIds;
    }

    public List<String> getAbilitiesIds() {
        return abilitiesIds;
    }

    public void setAbilitiesIds(List<String> abilitiesIds) {
        this.abilitiesIds = abilitiesIds;
    }

    public Double getHp() {
        return hp;
    }

    public void setHp(Double hp) {
        this.hp = hp;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Unit clone(){
        Unit unit=new Unit();
        unit.setAbilities(new ArrayList<>(abilities));
        unit.setAbilitiesIds(new ArrayList<>(abilitiesIds));
        unit.setEnergy(energy);
        unit.setHp(hp);
        unit.setId(id);
        unit.setName(name);
        unit.setSkills(new HashMap<>(skills));
        unit.setSkillsIds(new HashMap<>(skillsIds));
        unit.setTeam(team);
        return unit;
    }
}
