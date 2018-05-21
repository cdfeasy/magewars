package com.magewars.game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magewars.game.BattleTile;
import com.magewars.game.entity.ability.Ability;
import com.magewars.game.entity.ability.UnitAbilityWrapper;
import com.magewars.game.entity.stats.Skill;
import com.magewars.gdx.UnitGraphics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnitWrapper {
    private Unit unit;
    private String unitId;
    private Double hp;
    private Double energy;
    @JsonIgnore
    private Map<Skill, Double> skills;
    @JsonIgnore
    private Map<String, Double> skillsIds;
    @JsonIgnore
    private BattleTile tile;
    @JsonIgnore
    private TeamWrapper teamWrapper;
    @JsonIgnore
    private List<UnitAbilityWrapper> processedAbilities;
    @JsonIgnore
    private UnitGraphics unitGraphics;



    public UnitWrapper() {
    }

    public UnitWrapper(Unit unit) {
        this.unit = unit;
        refresh();
    }

    public void refresh() {
        if (this.getHp() == null)
            this.setHp(unit.getHp());
        if (this.getEnergy() == null)
            this.setEnergy(unit.getEnergy());
        this.setUnitId(unit.getId());
        this.setSkills(unit.getSkills());
        processedAbilities = new ArrayList<UnitAbilityWrapper>();
        for (Ability ability : unit.getAbilities()) {
            processedAbilities.add(new UnitAbilityWrapper(this, ability));
        }
    }

    public void postLoad(Map<String, Ability> abilitiesMap, Map<String, Skill> skills) {
        unit.setSkills(new HashMap<Skill, Double>());
        if (unit.getSkillsIds() != null) {
            for (Map.Entry<String, Double> entry : unit.getSkillsIds().entrySet()) {
                unit.getSkills().put(skills.get(entry.getKey()), entry.getValue());
            }
        }
        unit.setAbilities(new ArrayList<Ability>());
        if (unit.getAbilitiesIds() != null) {
            for (String id : unit.getAbilitiesIds()) {
                unit.getAbilities().add(abilitiesMap.get(id));
            }
        }
        refresh();
    }

    public void preSave() {
        unit.setSkillsIds(new HashMap<String, Double>());
        if (unit.getSkills() != null) {
            for (Map.Entry<Skill, Double> entry : unit.getSkills().entrySet()) {
                unit.getSkillsIds().put(entry.getKey().getId(), entry.getValue());
            }
        }
        unit.setAbilitiesIds(new ArrayList<String>());
        if (unit.getAbilities() != null) {
            for (Ability ability : unit.getAbilities()) {
                unit.getAbilitiesIds().add(ability.getId());
            }
        }
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public BattleTile getTile() {
        return tile;
    }

    public void setTile(BattleTile tile) {
        this.tile = tile;
    }

    public List<UnitAbilityWrapper> getProcessedAbilities() {
        return processedAbilities;
    }

    public void setProcessedAbilities(List<UnitAbilityWrapper> processedAbilities) {
        this.processedAbilities = processedAbilities;
    }

    public TeamWrapper getTeamWrapper() {
        return teamWrapper;
    }

    public void setTeamWrapper(TeamWrapper teamWrapper) {
        this.teamWrapper = teamWrapper;
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

    public Map<Skill, Double> getSkills() {
        if (skills == null) {
            skills = new HashMap<Skill, Double>();
        }
        return skills;
    }

    public void setSkills(Map<Skill, Double> skills) {
        this.skills = skills;
    }

    public Map<String, Double> getSkillsIds() {
        return skillsIds;
    }

    public void setSkillsIds(Map<String, Double> skillsIds) {
        this.skillsIds = skillsIds;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public UnitGraphics getUnitGraphics() {
        return unitGraphics;
    }

    public void setUnitGraphics(UnitGraphics unitGraphics) {
        this.unitGraphics = unitGraphics;
    }
}
