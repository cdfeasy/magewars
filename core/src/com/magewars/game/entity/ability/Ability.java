package com.magewars.game.entity.ability;

import com.magewars.game.entity.stats.Skill;
import com.magewars.game.entity.stats.stat.Strength;

import java.util.List;
import java.util.Map;

public class Ability {
    protected String id;
    protected AbilityCost cost;
    protected String name;
    protected String img;
    protected String effect;
    protected String description;
    protected Map<Skill,Double> requirement;
    protected List<AbilityCheck> checks;
    protected List<AbilityDamage> damages;

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

    public List<AbilityCheck> getChecks() {
        return checks;
    }

    public void setChecks(List<AbilityCheck> checks) {
        this.checks = checks;
    }

    public List<AbilityDamage> getDamages() {
        return damages;
    }

    public void setDamages(List<AbilityDamage> damages) {
        this.damages = damages;
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
}
