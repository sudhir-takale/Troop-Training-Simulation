package com.amaap.trooptrainingsimulator.models;

import com.amaap.trooptrainingsimulator.domain.models.Troop;

public class Barbarian extends Troop {

    public Barbarian() {
        this.setCost(20);
        this.setTime(6);
        this.setWeapon("Bow And Arrow");

    }
}
