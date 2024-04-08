package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Barbarian;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryTroopRepository;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class TroopServiceTest {

    TroopService troopService = new TroopService(new InMemoryTroopRepository(new InMemoryDatabase()));


    @Test
    void shouldBeAbleToCreateArcher() {
        //arrange
        TroopType troopType = TroopType.ARCHER;
        int trainingTime = 3;
        int trainingCost = 10;
        int id = 1;

        //act
        Troop expected = new Archer(1, 3, 10);
        Troop actual = troopService.create(troopType, trainingTime, trainingCost);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCreateBarbarian() {
        //arrange
        TroopType troopType = TroopType.BARBARIAN;
        int trainingTime = 6;
        int trainingCost = 20;
        int id = 1;

        //act
        Troop expected = new Barbarian(1, 6, 20);
        Troop actual = troopService.create(troopType, trainingTime, trainingCost);

        //assert
        assertEquals(expected, actual);
    }


}