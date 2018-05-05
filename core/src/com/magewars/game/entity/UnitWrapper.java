package com.magewars.game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magewars.game.BattleTile;
import com.magewars.game.entity.ability.Ability;
import com.magewars.game.entity.ability.UnitAbilityWrapper;
import com.magewars.game.entity.stats.BattleSkill;
import com.magewars.game.entity.stats.CommonSkill;
import com.magewars.game.entity.stats.MagicSkill;
import com.magewars.game.entity.stats.Skill;
import com.magewars.game.entity.stats.stat.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnitWrapper {
    private Unit unit;
    private String unitId;
    private HP hp;
    private Energy energy;

    @JsonIgnore
    private Agility agility;
    @JsonIgnore
    private Strength strength;
    @JsonIgnore
    private Control control;
    @JsonIgnore
    private Speed speed;
    @JsonIgnore
    private Endurance endurance;
    @JsonIgnore
    private Intelligence intelligence;

    @JsonIgnore
    private Map<MagicSkill, Double> magicSkills;
    @JsonIgnore
    private Map<BattleSkill, Double> battleSkills;
    @JsonIgnore
    private Map<CommonSkill, Double> commonSkills;

    @JsonIgnore
    private Map<String, Double> magicSkillsIds;
    @JsonIgnore
    private Map<String, Double> battleSkillsIds;
    @JsonIgnore
    private Map<String, Double> commonSkillsIds;
    @JsonIgnore
    private Map<Skill, Double> allStat;

    @JsonIgnore
    private BattleTile tile;
    @JsonIgnore
    private TeamWrapper teamWrapper;
    @JsonIgnore
    private List<UnitAbilityWrapper> processedAbilities;


    public UnitWrapper() {
    }

    public UnitWrapper(Unit unit) {
        this.unit = unit;
        refresh();
    }

    public void refresh() {
        if (this.getHp() == null)
            this.setHp(new HP(unit.getHp().getValue()));
        if (this.getEnergy() == null)
            this.setEnergy(new Energy(unit.getEnergy().getValue()));
        this.setControl(new Control(unit.getControl().getValue()));
        this.setAgility(new Agility(unit.getAgility().getValue()));
        this.setEndurance(new Endurance(unit.getEndurance().getValue()));
        this.setIntelligence(new Intelligence(unit.getIntelligence().getValue()));
        this.setSpeed(new Speed(unit.getSpeed().getValue()));
        this.setStrength(new Strength(unit.getStrength().getValue()));
        this.setUnitId(unit.getId());
        this.setAllStat(unit.getAllStat());
        this.setBattleSkills(unit.getBattleSkills());
        this.setMagicSkills(unit.getMagicSkills());
        this.setCommonSkills(unit.getCommonSkills());
        processedAbilities = new ArrayList<UnitAbilityWrapper>();
        for (Ability ability : unit.getAbilities()) {
            processedAbilities.add(new UnitAbilityWrapper(this, ability));
        }
    }

    public void postLoad(Map<String, Ability> abilitiesMap, Map<String, Skill> skills) {
        unit.setBattleSkills(new HashMap<BattleSkill, Double>());
        if (unit.getBattleSkillsIds() != null) {
            for (Map.Entry<String, Double> entry : unit.getBattleSkillsIds().entrySet()) {
                unit.getBattleSkills().put((BattleSkill) skills.get(entry.getKey()), entry.getValue());
            }
        }
        unit.setMagicSkills(new HashMap<MagicSkill, Double>());
        if (unit.getMagicSkillsIds() != null) {
            for (Map.Entry<String, Double> entry : unit.getMagicSkillsIds().entrySet()) {
                unit.getMagicSkills().put((MagicSkill) skills.get(entry.getKey()), entry.getValue());
            }
        }
        unit.setCommonSkills(new HashMap<CommonSkill, Double>());
        if (unit.getCommonSkillsIds() != null) {
            for (Map.Entry<String, Double> entry : unit.getCommonSkillsIds().entrySet()) {
                unit.getCommonSkills().put((CommonSkill) skills.get(entry.getKey()), entry.getValue());
            }
        }
        unit.setAbilities(new ArrayList<Ability>());
        if (unit.getAbilitiesIds() != null) {
            for (String id : unit.getAbilitiesIds()) {
                unit.getAbilities().add(abilitiesMap.get(id));
            }
        }
        unit.refreshAllStat();
        refresh();
    }

    public void preSave() {
        unit.setBattleSkillsIds(new HashMap<String, Double>());
        if (unit.getBattleSkills() != null) {
            for (Map.Entry<BattleSkill, Double> entry : unit.getBattleSkills().entrySet()) {
                unit.getBattleSkillsIds().put(entry.getKey().getId(), entry.getValue());
            }
        }
        unit.setMagicSkillsIds(new HashMap<String, Double>());
        if (unit.getMagicSkills() != null) {
            for (Map.Entry<MagicSkill, Double> entry : unit.getMagicSkills().entrySet()) {
                unit.getMagicSkillsIds().put(entry.getKey().getId(), entry.getValue());
            }
        }
        unit.setCommonSkillsIds(new HashMap<String, Double>());
        if (unit.getCommonSkills() != null) {
            for (Map.Entry<CommonSkill, Double> entry : unit.getCommonSkills().entrySet()) {
                unit.getCommonSkillsIds().put(entry.getKey().getId(), entry.getValue());
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

    public Map<Skill, Double> getAllStat() {
        return allStat;
    }

    public void setAllStat(Map<Skill, Double> allStat) {
        this.allStat = allStat;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }


}
