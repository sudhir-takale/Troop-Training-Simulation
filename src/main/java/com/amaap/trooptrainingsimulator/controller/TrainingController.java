package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.service.CreateTroopService;

public class TrainingController {

    CreateTroopService createService = new CreateTroopService();
    public boolean createTroop(TroopType troopType, int count) {

       return createService.createTroop(troopType, count);

    }
}
