package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.service.ArmyCampService;

public class ArmyCampController {
    private ArmyCampService armyCampService;

    public ArmyCampController(ArmyCampService armyCampService) {
        this.armyCampService = armyCampService;
    }

    public boolean addTroops(TroopType troopType) {

        return  armyCampService.updateTroopCount(troopType);

    }
}
