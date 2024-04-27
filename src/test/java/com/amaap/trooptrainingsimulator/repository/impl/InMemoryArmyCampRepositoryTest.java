package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.service.ArmyCampService;
import com.amaap.trooptrainingsimulator.service.BarrackService;
import com.amaap.trooptrainingsimulator.service.TroopService;
import com.amaap.trooptrainingsimulator.service.exception.InvalidTroopException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class InMemoryArmyCampRepositoryTest {
    BarrackService barrackService = new BarrackService(new InMemoryBarrackRepository(new FakeInMemoryDatabase()), new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase())), new TroopService(new InMemoryTroopRepository(new FakeInMemoryDatabase())));
    InMemoryArmyCampRepository inMemoryArmyCampRepository = new InMemoryArmyCampRepository(new FakeInMemoryDatabase());

    @Test
    void shouldBeAbleToMoveToArmyCamp() throws InvalidTroopParamsException, InterruptedException, InvalidTroopException {
        //arrange
//        barrackService.addTroops(TroopType.ARCHER, 4);
//        barrackService.trainTheTroop();

        //act
        boolean result = inMemoryArmyCampRepository.update(TroopType.ARCHER);

        //assert
        Assertions.assertTrue(result);

    }

    @Test
    void shouldBeAbleToGetTrainedTroop() throws InterruptedException, InvalidTroopParamsException, InvalidTroopException {
        //arrange
//        barrackService.addTroops(TroopType.ARCHER, 4);
//        barrackService.trainTheTroop();
        inMemoryArmyCampRepository.update(TroopType.ARCHER);
        inMemoryArmyCampRepository.update(TroopType.ARCHER);
        inMemoryArmyCampRepository.update(TroopType.ARCHER);
        inMemoryArmyCampRepository.update(TroopType.BARBARIAN);

        //act
        Map<TroopType, Integer> troops = inMemoryArmyCampRepository.getTrainedTroops();
        int archerCount = troops.get(TroopType.ARCHER);
        int barbarianCount = troops.get(TroopType.BARBARIAN);

        //assert
        Assertions.assertEquals(3, archerCount);
        Assertions.assertEquals(1, barbarianCount);
    }
}