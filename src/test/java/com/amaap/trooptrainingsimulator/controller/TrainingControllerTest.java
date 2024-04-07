package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrainingControllerTest {

    @Test
    void shouldBeAbleToCreateTroop() {
        int count = 4;
        TroopType troopType = TroopType.ARCHER;
        TrainingController trainingController = new TrainingController();

        boolean result = trainingController.createTroop(troopType, count);
//       assert
        Assertions.assertTrue(result);

    }

}
