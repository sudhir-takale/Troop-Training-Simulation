package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryArmyCampRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryBarrackRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryTroopRepository;
import com.amaap.trooptrainingsimulator.service.exception.InvalidTroopException;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class ArmyCampServiceTest {

    ArmyCampService armyCampService = new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase()));
    BarrackService barrackService = new BarrackService(new InMemoryBarrackRepository(new FakeInMemoryDatabase()), new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase())), new TroopService(new InMemoryTroopRepository(new FakeInMemoryDatabase())));

    @Test
    void shouldBeAbleToMoveToArmyCamp() throws InvalidTroopParamsException, InterruptedException, InvalidTroopException {
        //arrange
        barrackService.addTroops(TroopType.ARCHER, 4);
        barrackService.trainTheTroop();

        //act
        boolean result = armyCampService.updateTroopCount(TroopType.ARCHER);

        //assert
        assertTrue(result);

    }

    @Test
    void shouldBeAbleToGetTrainedTroop() throws InterruptedException, InvalidTroopParamsException, InvalidTroopException {
        //arrange
        barrackService.addTroops(TroopType.ARCHER, 4);
        barrackService.trainTheTroop();
        armyCampService.updateTroopCount(TroopType.ARCHER);
        armyCampService.updateTroopCount(TroopType.ARCHER);
        armyCampService.updateTroopCount(TroopType.ARCHER);
        armyCampService.updateTroopCount(TroopType.BARBARIAN);

        //act
        Map<TroopType, Integer> troops = armyCampService.getTrainedTroops();
        int archerCount = troops.get(TroopType.ARCHER);
        int barbarianCount = troops.get(TroopType.BARBARIAN);

        //assert
        assertEquals(3, archerCount);
        assertEquals(1, barbarianCount);
    }

}