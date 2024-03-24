package com.amaap.trooptrainingsimulator.domain.models;

public class Archers {

    private String weapon;
    private int time;
    private int cost;

    public Archers(String weapon, int time, int cost) {
        this.cost = cost;
        this.weapon = weapon;
        this.time = time;
    }
}
