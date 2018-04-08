package com.magewars.game.entity.ability;

public class AbilityCost {
    private Double percent;
    private Double cost;
    private Double minimal;

    public AbilityCost() {
    }

    public AbilityCost(Double cost) {
        this.cost = cost;
    }

    public AbilityCost(Double percent, Double minimal) {
        this.percent = percent;
        this.minimal = minimal;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getMinimal() {
        return minimal;
    }

    public void setMinimal(Double minimal) {
        this.minimal = minimal;
    }
}
