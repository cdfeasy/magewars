package com.magewars.game.entity.stats;

public class MagicSkill extends Skill{
    public MagicSkill() {
        setId("magicSchool"+this.getClass().getSimpleName());
    }

    public MagicSkill(String id) {
       super(id);
    }

    public MagicSkill(String id, String name, String description) {
        super(id, name, description);
    }
}
