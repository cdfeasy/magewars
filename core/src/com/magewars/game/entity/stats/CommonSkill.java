package com.magewars.game.entity.stats;

public class CommonSkill  extends Skill{
    public CommonSkill() {
        setId("commonSkill"+this.getClass().getSimpleName());
    }

    public CommonSkill(String id) {
        super(id);
    }

    public CommonSkill(String id, String name, String description) {
        super(id, name, description);
    }
}
