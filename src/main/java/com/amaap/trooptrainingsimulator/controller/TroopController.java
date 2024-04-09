package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.controller.dto.HttpStatus;
import com.amaap.trooptrainingsimulator.controller.dto.Response;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.service.TroopService;
import com.amaap.trooptrainingsimulator.service.exception.InvalidTroopException;

public class TroopController {

    private TroopService troopService;


    public TroopController(TroopService troopService) {
        this.troopService = troopService;
    }

    public Response createTroop(TroopType troopType, int trainingTime, int trainingCost) throws InvalidTroopParamsException, InvalidTroopException {
        try {
            troopService.create(troopType, trainingTime, trainingCost);
            return new Response(HttpStatus.OK, "Trooper created successfully");
        } catch (InvalidTroopException e) {
            return new Response(HttpStatus.BADREQUEST, "Invalid troop type ");
        }
    }
}
