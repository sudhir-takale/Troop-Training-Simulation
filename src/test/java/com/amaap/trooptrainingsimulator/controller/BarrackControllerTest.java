package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.controller.dto.HttpStatus;
import com.amaap.trooptrainingsimulator.controller.dto.Response;
import com.amaap.trooptrainingsimulator.controller.factory.TroopFactory;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryArmyCampRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryBarrackRepository;
import com.amaap.trooptrainingsimulator.service.ArmyCampService;
import com.amaap.trooptrainingsimulator.service.BarrackService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BarrackControllerTest {
    BarrackService barrackService = new BarrackService(new InMemoryBarrackRepository(new FakeInMemoryDatabase()),
            new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase())));
    BarrackController barrackController =
            new BarrackController(new BarrackService(new InMemoryBarrackRepository(new FakeInMemoryDatabase()),
                    new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase()))));

    @Test
    void shouldBeAbleAddTroopsToBarrack() throws InvalidTroopParamsException {
        //arrange
        int count = 2;
        List<Troop> troops = TroopFactory.getTroopList();
        //act
        boolean result = barrackController.addTroops(troops, count);
        //assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToTrainTheTrooper() throws InvalidTroopParamsException {
        // arrange
        Response expected = new Response(HttpStatus.OK,"Troop trained successfully");
        // act

        List<Troop> troopers = TroopFactory.getTroopList();
        barrackController.addTroops(troopers,5);
        Response actual = barrackController.trainTheTrooper();

        // assert
        assertEquals(expected,actual);
    }

}
