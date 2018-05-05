package com.magewars.game.entity.stats;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stat extends Skill {
    private Double value;
    public Stat() {
        setId("stat"+this.getClass().getSimpleName());
    }
    public Stat(String id) {
        super(id);
    }

    public Stat(Double value) {
        this();
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    @JsonIgnore
    public String getId() {
        return id;
    }
    @JsonProperty
    public void setId(String id) {
        this.id = id;
    }
}
