package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.controller.dto.HttpStatus;
import com.amaap.trooptrainingsimulator.controller.dto.Response;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.service.ArmyCampService;

import java.util.Map;

public class ArmyCampController {

    private final ArmyCampService armyCampService;

    public ArmyCampController(ArmyCampService armyCampService) {
        this.armyCampService = armyCampService;
    }

    public Response addTroops(TroopType troopType) {

         armyCampService.updateTroopCount(troopType);
         return  new Response(HttpStatus.OK,"Trooper added to camp");

    }

    public Map<TroopType, Integer> getTrainedTroops() {

        return armyCampService.getTrainedTroops();
    }
}
