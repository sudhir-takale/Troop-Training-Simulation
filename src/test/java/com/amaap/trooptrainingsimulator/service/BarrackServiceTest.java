package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.controller.factory.TroopFactory;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryArmyCampRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryBarrackRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryTroopRepository;
import com.amaap.trooptrainingsimulator.service.exception.InvalidTroopException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class BarrackServiceTest {

    BarrackService barrackService = new BarrackService(new InMemoryBarrackRepository(new FakeInMemoryDatabase()),
            new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase())),
            new TroopService(new InMemoryTroopRepository(new FakeInMemoryDatabase())));

    @Test
    void shouldBeAbleToAddTroopsInBarrack() throws InvalidTroopParamsException, InvalidTroopException {
        //arrange
        int count = 2;
        List<Troop> troops = TroopFactory.getTroopList();
        //act
        boolean result = barrackService.addTroops(TroopType.ARCHER, count);
        //assert
        assertTrue(result);
    }

    @Test
    void shouldNotAllowMoreThanTenTroopsToBarrack() throws InvalidTroopParamsException, InvalidTroopException {

        int count = 12;
        //act
        barrackService.addTroops(TroopType.ARCHER, count);
        Queue<Troop> barrackQueue = barrackService.getAllTroops();
        //assert
        assertEquals(10, barrackQueue.size());
    }

    @Test
    void shouldBeAbleToTrainTheTroopers() throws InterruptedException, InvalidTroopParamsException, InvalidTroopException {
        int count = 12;
        List<Troop> troops = TroopFactory.getTroopList();
        //act
        barrackService.addTroops(TroopType.ARCHER, count);
        Queue<Troop> barrackQueue = barrackService.getAllTroops();
        //assert
        assertEquals(10, barrackQueue.size());
        barrackService.trainTheTroop();
        assertEquals(0, barrackQueue.size());
    }
    @Test
    void shouldBeAbleToMoveTrainedTroopersToArmyCamp() throws InterruptedException, InvalidTroopParamsException, InvalidTroopException {
        int count = 12;
        List<Troop> troops = TroopFactory.getTroopList();
        //act
        barrackService.addTroops(TroopType.BARBARIAN, count);
        Queue<Troop> barrackQueue = barrackService.getAllTroops();
        //assert
        assertEquals(10, barrackQueue.size());
        barrackService.trainTheTroop();
        assertEquals(0, barrackQueue.size());
    }


}