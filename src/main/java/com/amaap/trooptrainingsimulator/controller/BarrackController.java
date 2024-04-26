package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.controller.dto.HttpStatus;
import com.amaap.trooptrainingsimulator.controller.dto.Response;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.service.BarrackService;
import com.amaap.trooptrainingsimulator.service.exception.InvalidTroopException;
import com.google.inject.Inject;

public class BarrackController {

    BarrackService barrackService;

    @Inject
    public BarrackController(BarrackService barrackService) {
        this.barrackService = barrackService;
    }

    public boolean addTroops(TroopType troopType, int count) throws InvalidTroopParamsException, InvalidTroopException {
        return barrackService.addTroops(troopType, count);
    }

    public Response trainTheTrooper() {
        try {
            barrackService.trainTheTroop();
            return new Response(HttpStatus.OK, "Troop trained successfully");
        } catch (InterruptedException exception) {
            return new Response(HttpStatus.BADREQUEST, "Interrupt occurred while training the troopers");
        }

    }


}
