package com.magewars.game.entity.ability;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.magewars.game.entity.stats.Skill;
import com.magewars.game.serializers.MapSkillSerializer;

import java.io.StringWriter;

public class AbilityCheck {
    @JsonIgnore
    private Skill attack;
    @JsonIgnore
    private Skill defend;
    private String attackId;
    private String defendId;
    private Double modificator;

    public AbilityCheck() {
    }

    public AbilityCheck(Skill attack, Skill defend, Double modificator) {
        this.attack = attack;
        this.defend = defend;
        this.modificator = modificator;
        this.attackId=attack.getId();
        this.defendId=defend.getId();
    }

    public AbilityCheck(Skill attack, Skill defend) {
        this.attack = attack;
        this.defend = defend;
        this.modificator=100d;
        this.attackId=attack.getId();
        this.defendId=defend.getId();
    }

    public Skill getAttack() {
        return attack;
    }

    public void setAttack(Skill attack) {
        this.attack = attack;
    }

    public Skill getDefend() {
        return defend;
    }

    public void setDefend(Skill defend) {
        this.defend = defend;
    }

    public Double getModificator() {
        return modificator;
    }

    public void setModificator(Double modificator) {
        this.modificator = modificator;
    }

    public String getAttackId() {
        return attackId;
    }

    public void setAttackId(String attackId) {
        this.attackId = attackId;
    }

    public String getDefendId() {
        return defendId;
    }

    public void setDefendId(String defendId) {
        this.defendId = defendId;
    }

}
