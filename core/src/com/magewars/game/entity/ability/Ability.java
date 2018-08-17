package com.magewars.game.entity.ability;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.magewars.game.entity.SpecRule;
import com.magewars.game.entity.stats.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ability {
    protected String id;
    protected AbilityCost cost;
    protected String name;
    protected String img;
    protected String effect;
    protected String description;

    protected Integer minLength;
    protected Integer maxLength;
    protected List<SpecRule> specRules;

    @JsonIgnore
    protected Map<Skill, Double> requirement;
    protected Map<String, Double> requirementIds;
    protected List<AbilityCheck> checks;
    protected List<AbilityDamage> damages;

    public Ability() {

    }

    public Ability(String id, AbilityCost cost, String name, Map<Skill, Double> requirement, List<AbilityCheck> checks, List<AbilityDamage> damages) {
        this.id = id;
        this.cost = cost;
        this.name = name;
        this.requirement = requirement;
        this.checks = checks;
        this.damages = damages;
        this.requirementIds = new HashMap<String, Double>();
        for (Map.Entry<Skill, Double> mod : requirement.entrySet()) {
            this.requirementIds.put(mod.getKey().getId(), mod.getValue());
        }
    }

    public Ability(String id, AbilityCost cost, String name, Skill skill, Double requirement, AbilityCheck check, AbilityDamage damage) {
        this.id = id;
        this.cost = cost;
        this.name = name;
        addRequirement(skill, requirement);
        addChecks(check);
        addDamage(damage);
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

    public void addRequirement(Skill skill, Double value) {
        if (this.requirement == null) {
            this.requirement = new HashMap<Skill, Double>();
            this.requirementIds = new HashMap<String, Double>();
        }
        this.requirement.put(skill, value);
        this.requirementIds.put(skill.getId(), value);
    }


    public List<AbilityCheck> getChecks() {
        return checks;
    }

    public void setChecks(List<AbilityCheck> checks) {
        this.checks = checks;
    }

    public void addChecks(AbilityCheck check) {
        if (this.checks == null) {
            this.checks = new ArrayList<AbilityCheck>();
        }
        this.checks.add(check);
    }


    public List<AbilityDamage> getDamages() {
        return damages;
    }


    public void setDamages(List<AbilityDamage> damages) {
        this.damages = damages;
    }

    public void addDamage(AbilityDamage damage) {
        if (this.damages == null) {
            this.damages = new ArrayList<AbilityDamage>();
        }
        this.damages.add(damage);
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Map<String, Double> getRequirementIds() {
        return requirementIds;
    }

    public void setRequirementIds(Map<String, Double> requirementIds) {
        this.requirementIds = requirementIds;
    }

    public List<SpecRule> getSpecRules() {
        return specRules;
    }

    public void setSpecRules(List<SpecRule> specRules) {
        this.specRules = specRules;
    }

}
