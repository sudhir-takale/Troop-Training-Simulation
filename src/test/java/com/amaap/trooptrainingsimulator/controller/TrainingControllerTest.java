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

public class TrainingControllerTest {


    TroopController controller = new TroopController
            (new TroopService
                    (new InMemoryTroopRepository(new FakeInMemoryDatabase())));

    @Test
    void shouldBeAbleToCreateArcherTrooper() throws InvalidTroopParamsException, InvalidTroopException {
        //arrange
        TroopType troopType = TroopType.ARCHER;
        int trainingTime = 3;
        int trainingCost = 10;
        int id = 1;

        //act
        Response expected = new Response(HttpStatus.OK, "Trooper created successfully");
        Response actual = controller.createTroop(TroopType.ARCHER, trainingTime, trainingCost);

        //assert
        assertEquals(expected, actual);

    }

}
