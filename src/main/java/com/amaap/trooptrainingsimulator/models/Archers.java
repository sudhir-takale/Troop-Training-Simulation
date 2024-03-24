package com.amaap.trooptrainingsimulator.models;

import com.amaap.trooptrainingsimulator.domain.models.Troop;
import com.amaap.trooptrainingsimulator.domain.models.Trooper;

public class Archers extends Troop {

    public Archers() {
        this.setWeapon("Sword");
        this.setTime(3);
        this.setCost(10);
    }
    public Trooper getTrooperType() {
        return Trooper.ARCHER;
    }

}
