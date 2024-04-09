package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.controller.dto.HttpStatus;
import com.amaap.trooptrainingsimulator.controller.dto.Response;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.service.BarrackService;

import java.util.List;

public class BarrackController {

    BarrackService barrackService;

    public BarrackController(BarrackService barrackService) {
        this.barrackService = barrackService;
    }

    public boolean addTroops(List<Troop> troops, int count) {
        return barrackService.addTroops(troops, count);
    }

    public Response trainTheTrooper() {
        try {
            barrackService.trainTheTroop();
            return new Response(HttpStatus.OK,"Troop trained successfully");
        }
        catch (InterruptedException exception)
        {
            return new Response(HttpStatus.BADREQUEST,"Interrupt occurred while training the troopers");
        }

    }


}
