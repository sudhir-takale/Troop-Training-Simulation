package com.amaap.trooptrainingsimulator.repository;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TroopRepositoryTest {

    @Test
    void shouldBeAbleToCreateTroopForGivenTroopType() {
//        arrange
        int count = 5;
        TroopType troopType = TroopType.ARCHER;
        TroopRepository repository = new TroopRepository();
//        act
        boolean result = repository.create(troopType, count);
//        assert
        assertTrue(result);
    }

}