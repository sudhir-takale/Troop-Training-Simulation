package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.Barbarian;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;

import javax.swing.*;

public class TroopController {
    public Troop createTroop(TroopType troopType, int trainingTime, int trainingCost) {

        return new Archer(1, trainingTime, trainingCost);

    }
}
