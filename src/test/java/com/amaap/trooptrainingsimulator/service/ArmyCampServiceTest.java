package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.controller.factory.TroopFactory;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryArmyCampRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryBarrackRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

class ArmyCampServiceTest {

    ArmyCampService armyCampService = new ArmyCampService(new InMemoryArmyCampRepository());
    private BarrackService barrackService = new BarrackService(new InMemoryBarrackRepository(new FakeInMemoryDatabase()));

    @Test
    void shouldBeAbleToMoveToArmyCamp() throws InvalidTroopParamsException, InterruptedException {
        //arrange
        List<Troop> troopList = TroopFactory.getTroopList();
        barrackService.addTroops(troopList, 4);
        barrackService.trainTheTroop();

        //act
        boolean result = armyCampService.updateTroopCount(TroopType.ARCHER);

        //assert
        assertTrue(result);

    }


}