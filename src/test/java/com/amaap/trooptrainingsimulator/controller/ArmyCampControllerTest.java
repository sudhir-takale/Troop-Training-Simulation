package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.controller.dto.HttpStatus;
import com.amaap.trooptrainingsimulator.controller.dto.Response;
import com.amaap.trooptrainingsimulator.controller.factory.TroopFactory;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryArmyCampRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryBarrackRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryTroopRepository;
import com.amaap.trooptrainingsimulator.service.ArmyCampService;
import com.amaap.trooptrainingsimulator.service.BarrackService;
import com.amaap.trooptrainingsimulator.service.TroopService;
import com.amaap.trooptrainingsimulator.service.exception.InvalidTroopException;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ArmyCampControllerTest {


    private final BarrackService barrackService = new BarrackService(new InMemoryBarrackRepository(new FakeInMemoryDatabase()), new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase())), new TroopService(new InMemoryTroopRepository(new FakeInMemoryDatabase())));
    ArmyCampController armyCampController = new ArmyCampController(new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase())));

    @Test
    void shouldBeAbleToMoveToArmyCamp() throws InvalidTroopParamsException, InterruptedException, InvalidTroopException {
        //arrange
        barrackService.addTroops(TroopType.ARCHER, 4);
        barrackService.trainTheTroop();

        //act
        Response actual = armyCampController.addTroops(TroopType.ARCHER);
        Response expected = new Response(HttpStatus.OK, "Trooper added to camp");
        //assert
        assertEquals(expected, actual);

    }

    @Test
    void shouldBeAbleToGetTrainedTroop() throws InterruptedException, InvalidTroopParamsException, InvalidTroopException {
        //arrange
        barrackService.addTroops(TroopType.ARCHER, 4);
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
