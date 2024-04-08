package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.controller.TroopFactory;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.BarrackRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class BarrackServiceTest {

    BarrackService barrackService = new BarrackService(new BarrackRepository());
    @Test
    void shouldBeAbleToAddTroopsInBarrack() {
        //arrange
        int count = 2;
        List<Troop> troops = TroopFactory.getTroopList();
        //act
        boolean result = barrackService.addTroops(troops, count);
        //assert
        assertTrue(result);


    }
}