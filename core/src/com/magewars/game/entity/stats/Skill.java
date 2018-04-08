package com.magewars.game.entity.stats;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = BattleSkill.class, name = "battle"),
//        @JsonSubTypes.Type(value = MagicSkill.class, name = "magic"),
//        @JsonSubTypes.Type(value = CommonSkill.class, name = "common")
//})
public class Skill {
    protected String id;
    protected String name;
    protected String description;

    public Skill() {

    }

    public Skill(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Skill(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
