package com.magewars.game.entity.ability;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.magewars.game.entity.Damage;
import com.magewars.game.entity.stats.Skill;
import com.magewars.game.serializers.BattleSkillSerializer;
import com.magewars.game.serializers.MapSkillSerializer;

import java.util.HashMap;
import java.util.Map;

public class AbilityDamage {
    @JsonIgnore
    private Map<Skill, Double> modificators;
    private Map<String, Double> modificatorsIds;
    private Damage damageType;
    private Double damage;

    public AbilityDamage() {
    }

    public AbilityDamage(Map<Skill, Double> modificators, Damage damageType, Double damage) {
        this.modificators = modificators;
        this.damageType = damageType;
        this.damage = damage;
        this.modificatorsIds = new HashMap<String, Double>();
        for (Map.Entry<Skill, Double> mod : modificators.entrySet()) {
            this.modificatorsIds.put(mod.getKey().getId(), mod.getValue());
        }
    }

    public AbilityDamage(final Skill skill, final Double mod, Damage damageType, Double damage) {
        this(new HashMap<Skill, Double>() {{
            put(skill, mod);
        }}, damageType, damage);
    }


    public Map<Skill, Double> getModificators() {
        return modificators;
    }

    public void setModificators(Map<Skill, Double> modificators) {
        this.modificators = modificators;
    }

    public Damage getDamageType() {
        return damageType;
    }

    public void setDamageType(Damage damageType) {
        this.damageType = damageType;
    }

    public Double getDamage() {
        return damage;
    }

    public void setDamage(Double damage) {
        this.damage = damage;
    }
}
