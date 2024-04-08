package com.amaap.trooptrainingsimulator.controller;

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
}
