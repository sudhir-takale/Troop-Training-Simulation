package com.amaap.trooptrainingsimulator.models;

import com.amaap.trooptrainingsimulator.domain.models.Troop;

public class Barbarian extends Troop {

    public Barbarian(String weapon, int time, int cost) {
        this.setCost(cost);
        this.setTime(time);
        this.setWeapon(weapon);

    }
}
