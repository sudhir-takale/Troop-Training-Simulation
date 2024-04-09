package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.controller.TroopFactory;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDatabaseImpl;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryBarrackRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class BarrackServiceTest {

    BarrackService barrackService = new BarrackService(new InMemoryBarrackRepository(new InMemoryDatabaseImpl()));

    @Test
    void shouldBeAbleToAddTroopsInBarrack() throws InvalidTroopParamsException {
        //arrange
        int count = 2;
        List<Troop> troops = TroopFactory.getTroopList();
        //act
        boolean result = barrackService.addTroops(troops, count);
        //assert
        assertTrue(result);
    }

    @Test
    void shouldNotAllowMoreThanTenTroopsToBarrack() throws InvalidTroopParamsException {

        int count = 12;
        List<Troop> troops = TroopFactory.getTroopList();
        //act
        barrackService.addTroops(troops, count);
        Queue<Troop> barrackQueue = barrackService.getAllTroops();
        //assert
        assertEquals(10, barrackQueue.size());
    }

    @Test
    void shouldBeAbleToTrainTheTroopers() throws InterruptedException, InvalidTroopParamsException {
        int count = 12;
        List<Troop> troops = TroopFactory.getTroopList();
        //act
        barrackService.addTroops(troops, count);
        Queue<Troop> barrackQueue = barrackService.getAllTroops();
        //assert
        assertEquals(10, barrackQueue.size());
        barrackService.trainTheTroop();
        assertEquals(0, barrackQueue.size());


    }

}