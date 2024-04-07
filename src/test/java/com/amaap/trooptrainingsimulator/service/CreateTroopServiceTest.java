package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class CreateTroopServiceTest {


    @Test
    void shouldBeAbleToCreateTroop() {
//        arrange
        int count = 5;
        TroopType troopType = TroopType.ARCHER;
        CreateTroopService createTroopService = new CreateTroopService();

//        act
        boolean result = createTroopService.createTroop(troopType, count);

//        assert
        assertTrue(result);
    }

}