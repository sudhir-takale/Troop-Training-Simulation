package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.controller.factory.TroopFactory;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryArmyCampRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryBarrackRepository;
import com.amaap.trooptrainingsimulator.service.ArmyCampService;
import com.amaap.trooptrainingsimulator.service.BarrackService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArmyCampControllerTest {


    ArmyCampController armyCampController =
            new ArmyCampController(new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase())));
    private final BarrackService barrackService =
            new BarrackService(new InMemoryBarrackRepository(new FakeInMemoryDatabase()),
                    new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase())));

    @Test
    void shouldBeAbleToMoveToArmyCamp() throws InvalidTroopParamsException, InterruptedException {
        //arrange
        List<Troop> troopList = TroopFactory.getTroopList();
        barrackService.addTroops(troopList, 4);
        barrackService.trainTheTroop();

        //act
        boolean result = armyCampController.addTroops(TroopType.ARCHER);

        //assert
        assertTrue(result);

    }

    @Test
    void shouldBeAbleToGetTrainedTroop() throws InterruptedException, InvalidTroopParamsException {
        //arrange
        List<Troop> troopList = TroopFactory.getTroopList();
        barrackService.addTroops(troopList, 4);
        barrackService.trainTheTroop();
        armyCampController.addTroops(TroopType.ARCHER);
        armyCampController.addTroops(TroopType.ARCHER);
        armyCampController.addTroops(TroopType.ARCHER);
        armyCampController.addTroops(TroopType.BARBARIAN);

        //act
        Map<TroopType, Integer> troops = armyCampController.getTrainedTroops();
        int archerCount = troops.get(TroopType.ARCHER);
        int barbarianCount = troops.get(TroopType.BARBARIAN);

        //assert
        assertEquals(3, archerCount);
        assertEquals(1, barbarianCount);
    }

}
