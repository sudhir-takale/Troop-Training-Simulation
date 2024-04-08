package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryTroopRepository;
import com.amaap.trooptrainingsimulator.service.TroopService;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TrainingControllerTest {


    TroopController controller = new TroopController
            (new TroopService
                    (new InMemoryTroopRepository(new InMemoryDatabase())));

    @Test
    void shouldBeAbleToCreateArcherTrooper() {
        //arrange
        TroopType troopType = TroopType.ARCHER;
        int trainingTime = 3;
        int trainingCost = 10;
        int id = 1;

        //act
        Troop expected = new Archer(1, 3, 10);
        Troop actual = controller.createTroop(troopType, trainingTime, trainingCost);

        //assert
        assertEquals(expected, actual);

    }

}
