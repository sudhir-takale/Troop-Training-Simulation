package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.service.TroopService;

public class TroopController {

    private TroopService troopService;


    public TroopController(TroopService troopService) {
        this.troopService = troopService;
    }

    public Troop createTroop(TroopType troopType, int trainingTime, int trainingCost) {
        return troopService.create(troopType, trainingTime, trainingCost);

    }
}
