package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.repository.dao.Archer;
import com.amaap.trooptrainingsimulator.repository.dao.Troop;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class BarrackServiceTest {


    @Test
    void shouldBeAbleToAddNewTroopInTheQueue() {

        BarrackService barrackService = new BarrackService();
        Troop troop = new Archer();
        barrackService.add(troop);
//        assert
        assertEquals(1, barrackService.getTroopList().size());

    }

}