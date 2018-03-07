package com.magewars.game.entity.stats;

public class MagicSkill extends Skill{
    public MagicSkill() {
        setId("magicSchool"+this.getClass().getSimpleName());
    }

    public MagicSkill(String id) {
       super(id);
    }

    public MagicSkill(String id, double value) {
      super(id,value);
    }
}
