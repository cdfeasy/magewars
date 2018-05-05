package com.magewars.game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.magewars.game.Team;
import com.magewars.game.entity.ability.Ability;
import com.magewars.game.entity.stats.BattleSkill;
import com.magewars.game.entity.stats.CommonSkill;
import com.magewars.game.entity.stats.MagicSkill;
import com.magewars.game.entity.stats.Skill;
import com.magewars.game.entity.stats.stat.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Unit {
    private String name;
    private String id;

    private Agility agility;
    private HP hp;
    private Energy energy;
    private Strength strength;
    private Control control;
    private Speed speed;
    private Endurance endurance;
    private Intelligence intelligence;
    private Team team;

    @JsonIgnore
    private Map<MagicSkill, Double> magicSkills;
    @JsonIgnore
    private Map<BattleSkill, Double> battleSkills;
    @JsonIgnore
    private Map<CommonSkill, Double> commonSkills;

    private Map<String, Double> magicSkillsIds;
    private Map<String, Double> battleSkillsIds;
    private Map<String, Double> commonSkillsIds;

    private List<String> abilitiesIds;
    @JsonIgnore
    private List<Ability> abilities;
    @JsonIgnore
    private Map<Skill, Double> allStat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Agility getAgility() {
        return agility;
    }

    public void setAgility(Agility agility) {
        this.agility = agility;
    }

    public HP getHp() {
        return hp;
    }

    public void setHp(HP hp) {
        this.hp = hp;
    }

    public Energy getEnergy() {
        return energy;
    }

    public void setEnergy(Energy energy) {
        this.energy = energy;
    }

    public Strength getStrength() {
        return strength;
    }

    public void setStrength(Strength strength) {
        this.strength = strength;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Endurance getEndurance() {
        return endurance;
    }

    public void setEndurance(Endurance endurance) {
        this.endurance = endurance;
    }

    public Intelligence getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Intelligence intelligence) {
        this.intelligence = intelligence;
    }

    public void setMagicSkills(Map<MagicSkill, Double> magicSkills) {
        this.magicSkills = magicSkills;
    }

    public void setBattleSkills(Map<BattleSkill, Double> battleSkills) {
        this.battleSkills = battleSkills;
    }

    public void setCommonSkills(Map<CommonSkill, Double> commonSkills) {
        this.commonSkills = commonSkills;
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

    public Map<MagicSkill, Double> getMagicSkills() {
        if (magicSkills == null) {
            magicSkills = new HashMap<MagicSkill, Double>();
        }
        return magicSkills;
    }

    public Map<BattleSkill, Double> getBattleSkills() {
        if (battleSkills == null) {
            battleSkills = new HashMap<BattleSkill, Double>();
        }
        return battleSkills;
    }

    public Map<CommonSkill, Double> getCommonSkills() {
        if (commonSkills == null) {
            commonSkills = new HashMap<CommonSkill, Double>();
        }
        return commonSkills;
    }

    public Map<Skill, Double> getAllStat() {
        return allStat;
    }

    public void setAllStat(Map<Skill, Double> allStat) {
        this.allStat = allStat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Double> getMagicSkillsIds() {
        return magicSkillsIds;
    }

    public void setMagicSkillsIds(Map<String, Double> magicSkillsIds) {
        this.magicSkillsIds = magicSkillsIds;
    }

    public Map<String, Double> getBattleSkillsIds() {
        return battleSkillsIds;
    }

    public void setBattleSkillsIds(Map<String, Double> battleSkillsIds) {
        this.battleSkillsIds = battleSkillsIds;
    }

    public Map<String, Double> getCommonSkillsIds() {
        return commonSkillsIds;
    }

    public void setCommonSkillsIds(Map<String, Double> commonSkillsIds) {
        this.commonSkillsIds = commonSkillsIds;
    }

    public List<String> getAbilitiesIds() {
        return abilitiesIds;
    }

    public void setAbilitiesIds(List<String> abilitiesIds) {
        this.abilitiesIds = abilitiesIds;
    }

    public void refreshAllStat() {
        allStat = new HashMap<Skill, Double>();
        allStat.put(agility, agility.getValue());
        allStat.put(hp, hp.getValue());
        allStat.put(energy, energy.getValue());
        allStat.put(strength, strength.getValue());
        allStat.put(control, control.getValue());
        allStat.put(speed, speed.getValue());
        allStat.put(endurance, endurance.getValue());
        allStat.put(intelligence, intelligence.getValue());
        if (battleSkills != null)
            allStat.putAll(battleSkills);
        if (magicSkills != null)
            allStat.putAll(magicSkills);
        if (commonSkills != null)
            allStat.putAll(commonSkills);
    }


}
