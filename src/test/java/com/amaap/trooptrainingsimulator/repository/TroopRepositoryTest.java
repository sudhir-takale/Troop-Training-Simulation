package com.amaap.trooptrainingsimulator.repository;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.impl.TroopRepositoryImpl;
import com.amaap.trooptrainingsimulator.service.BarrackService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TroopRepositoryTest {
    TroopRepository repository = new TroopRepositoryImpl(new BarrackService());

    @Test
    void shouldBeAbleToCreateTroopForGivenTroopType() {
//        arrange
        int count = 5;
        TroopType troopType = TroopType.ARCHER;
//         act
        boolean result = repository.create(troopType, count);
//        assert
        assertTrue(result);
    }


}