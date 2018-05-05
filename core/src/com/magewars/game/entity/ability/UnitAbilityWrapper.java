package com.magewars.game.entity.ability;

import com.magewars.game.entity.UnitWrapper;
import com.magewars.game.entity.stats.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnitAbilityWrapper {
    private UnitWrapper unit;
    private Ability ability;
    private List<AbilityDamage> finalDamage;
    private Double cost;

    public UnitAbilityWrapper(UnitWrapper unit, Ability ability) {
        this.unit = unit;
        this.ability = ability;
        refresh();
    }

    public void refresh() {
        finalDamage = new ArrayList<AbilityDamage>();
        for (AbilityDamage dmg : ability.getDamages()) {
            Double dmgValue = dmg.getDamage();
            for (Map.Entry<Skill, Double> entry : dmg.getModificators().entrySet()) {
                if (unit.getAllStat().get(entry.getKey()) != null) {
                    dmgValue += dmg.getDamage() * (entry.getValue() * unit.getAllStat().get(entry.getKey()));
                }
            }
            AbilityDamage fDamage = new AbilityDamage(null, dmg.getDamageType(), dmgValue);
            finalDamage.add(fDamage);
        }
        if (ability.getCost().getPercent() != null) {
            cost = unit.getEnergy().getValue() * ability.getCost().getPercent() / 100;
        } else {
            cost = ability.getCost().getCost();
        }
        if (ability.getCost().getMinimal() != null && ability.getCost().getMinimal() > cost) {
            cost = ability.getCost().getMinimal();
        }
    }

    public UnitWrapper getUnit() {
        return unit;
    }

    public void setUnit(UnitWrapper unit) {
        this.unit = unit;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public List<AbilityDamage> getFinalDamage() {
        return finalDamage;
    }

    public void setFinalDamage(List<AbilityDamage> finalDamage) {
        this.finalDamage = finalDamage;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
