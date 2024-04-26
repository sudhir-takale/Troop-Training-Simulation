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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BarrackControllerTest {
    BarrackController barrackController = new BarrackController(new BarrackService(new InMemoryBarrackRepository(new FakeInMemoryDatabase()), new ArmyCampService(new InMemoryArmyCampRepository(new FakeInMemoryDatabase())), new TroopService(new InMemoryTroopRepository(new FakeInMemoryDatabase()))));

    @Test
    void shouldBeAbleAddTroopsToBarrack() throws InvalidTroopParamsException, InvalidTroopException {
        // arrange
        int count = 2;
        List<Troop> troops = TroopFactory.getTroopList();

        // act
        boolean result = barrackController.addTroops(TroopType.ARCHER, count);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToTrainTheTrooper() throws InvalidTroopParamsException, InvalidTroopException {
        // arrange
        Response expected = new Response(HttpStatus.OK, "Troop trained successfully");

        // act
        List<Troop> troopers = TroopFactory.getTroopList();
        barrackController.addTroops(TroopType.ARCHER, 5);
        Response actual = barrackController.trainTheTrooper();

        // assert
        assertEquals(expected, actual);
    }

}
