package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.service.BarrackService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class BarrackControllerTest {

    BarrackController barrackController = new BarrackController(new BarrackService());

    @Test
    void shouldBeAbleAddTroopsToBarrack() {
        //arrange
        int count = 6;
        List<Troop> troops = TroopFactory.getTroopList();
        //act
        boolean result = barrackController.addTroops(troops, count);
        //assert
        assertTrue(result);


    }


}
