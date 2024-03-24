package com.amaap.trooptrainingsimulator.models;

import com.amaap.trooptrainingsimulator.domain.models.Troop;

public class Archers extends Troop {

    public Archers() {
        this.setWeapon("Sword");
        this.setTime(3);
        this.setCost(10);
    }


}
