package com.amaap.trooptrainingsimulator.models;

import com.amaap.trooptrainingsimulator.domain.models.Troop;

public class Archers extends Troop {

    public Archers(String weapon, int time, int cost) {
        this.setWeapon(weapon);
        this.setTime(time);
        this.setCost(cost);
    }
}
