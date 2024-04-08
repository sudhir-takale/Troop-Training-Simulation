package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TrainingControllerTest {

    @Test
    void shouldBeAbleToCreateArcherTrooper() {
        //arrange
        TroopType troopType = TroopType.ARCHER;
        int trainingTime = 3;
        int trainingCost = 10;
        int id = 1;
        TroopController controller = new TroopController();

        //act
        Troop expected = new Archer(1, 3, 10);
        Troop actual = controller.createTroop(troopType, trainingTime, trainingCost);

        //assert
        assertEquals(expected, actual);

    }

}
