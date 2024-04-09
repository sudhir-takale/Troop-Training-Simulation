package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.controller.factory.TroopFactory;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.service.ArmyCampService;
import com.amaap.trooptrainingsimulator.service.BarrackService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class InMemoryArmyCampRepositoryTest {
    private final BarrackService barrackService =
            new BarrackService(new InMemoryBarrackRepository(new FakeInMemoryDatabase()),
                    new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase())));
    private InMemoryArmyCampRepository inMemoryArmyCampRepository = new InMemoryArmyCampRepository(new FakeInMemoryDatabase());

    @Test
    void shouldBeAbleToMoveToArmyCamp() throws InvalidTroopParamsException, InterruptedException {
        //arrange
        List<Troop> troopList = TroopFactory.getTroopList();
        barrackService.addTroops(troopList, 4);
        barrackService.trainTheTroop();

        //act
        boolean result = inMemoryArmyCampRepository.update(TroopType.ARCHER);

        //assert
        assertTrue(result);

    }

    @Test
    void shouldBeAbleToGetTrainedTroop() throws InterruptedException, InvalidTroopParamsException {
        //arrange
        List<Troop> troopList = TroopFactory.getTroopList();
        barrackService.addTroops(troopList, 4);
        barrackService.trainTheTroop();
        inMemoryArmyCampRepository.update(TroopType.ARCHER);
        inMemoryArmyCampRepository.update(TroopType.ARCHER);
        inMemoryArmyCampRepository.update(TroopType.ARCHER);
        inMemoryArmyCampRepository.update(TroopType.BARBARIAN);
        //act
        Map<TroopType, Integer> troops = inMemoryArmyCampRepository.getTrainedTroops();
       int archerCount = troops.get(TroopType.ARCHER);
       int barbarianCount = troops.get(TroopType.BARBARIAN);

       //assert
        assertEquals(3, archerCount);
        assertEquals(1, barbarianCount);
    }
}