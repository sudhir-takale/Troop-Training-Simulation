package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.controller.Troop;
import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;

public class TroopService {
    public Troop create(TroopType troopType, int trainingTime, int trainingCost) {


        return new Archer(1, trainingTime, trainingCost);

    }
}
