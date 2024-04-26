package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.controller.dto.HttpStatus;
import com.amaap.trooptrainingsimulator.controller.dto.Response;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryTroopRepository;
import com.amaap.trooptrainingsimulator.service.TroopService;
import com.amaap.trooptrainingsimulator.service.exception.InvalidTroopException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TroopControllerTest {


    TroopController controller = new TroopController(new TroopService(new InMemoryTroopRepository(new FakeInMemoryDatabase())));

    @Test
    void shouldBeAbleToCreateArcherTrooper() throws InvalidTroopParamsException, InvalidTroopException {
        //arrange
        TroopType troopType = TroopType.ARCHER;
        int trainingTime = 3;
        int trainingCost = 10;
        int id = 1;

        //act
        Response expected = new Response(HttpStatus.OK, "Trooper created successfully");
        Response actual = controller.createTroop(troopType, trainingTime, trainingCost);

        //assert
        assertEquals(expected, actual);

    }

    @Test
    void shouldThrowExceptionWhenInvalidTrooperPasse() throws InvalidTroopParamsException, InvalidTroopException {
        //arrange
        Response expected = new Response(HttpStatus.BADREQUEST, "Invalid troop type ");
        //act
        Response actual = controller.createTroop(TroopType.UNKNOWN, 6, 20);
        //assert
        assertEquals(expected, actual);

    }


}
