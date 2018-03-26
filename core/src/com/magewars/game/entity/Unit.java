package com.magewars.game.entity;

import com.magewars.game.entity.ability.Ability;
import com.magewars.game.entity.stats.BattleSkill;
import com.magewars.game.entity.stats.CommonSkill;
import com.magewars.game.entity.stats.MagicSkill;
import com.magewars.game.entity.stats.stat.*;

import java.util.List;

public class Unit {
    private String name;

    private Agility agility;
    private HP hp;
    private Energy energy;
    private Strength strength;
    private Control control;
    private Speed speed;
    private Endurance endurance;
    private Intelligence intelligence;

    private List<MagicSkill> magicSkills;
    private List<BattleSkill> battleSkills;
    private List<CommonSkill> commonSkills;

    List<Ability> abilities;

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

    public List<MagicSkill> getMagicSkills() {
        return magicSkills;
    }

    public void setMagicSkills(List<MagicSkill> magicSkills) {
        this.magicSkills = magicSkills;
    }

    public List<BattleSkill> getBattleSkills() {
        return battleSkills;
    }

    public void setBattleSkills(List<BattleSkill> battleSkills) {
        this.battleSkills = battleSkills;
    }

    public List<CommonSkill> getCommonSkills() {
        return commonSkills;
    }

    public void setCommonSkills(List<CommonSkill> commonSkills) {
        this.commonSkills = commonSkills;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
