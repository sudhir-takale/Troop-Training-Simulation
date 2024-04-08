package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.service.TroopService;

public class TroopController {

        TroopService troopService = new TroopService();
    public Troop createTroop(TroopType troopType, int trainingTime, int trainingCost) {
        return troopService.create(troopType, trainingTime, trainingCost);

    }
}
