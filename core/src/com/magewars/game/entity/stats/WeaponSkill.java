package com.magewars.game.entity.stats;

public class WeaponSkill  extends Skill{
    public WeaponSkill() {
        setId("weaponSkill"+this.getClass().getSimpleName());
    }

    public WeaponSkill(String id) {
        super(id);
    }

    public WeaponSkill(String id, double value) {
        super(id,value);
    }
}