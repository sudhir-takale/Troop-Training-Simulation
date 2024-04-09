package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Barbarian;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class InMemoryTroopRepositoryTest {

    InMemoryTroopRepository inMemoryTroopRepository = new InMemoryTroopRepository(new FakeInMemoryDatabase());

    @Test
    void shouldBeAbleToStoreTheTroopInMemory() throws TroopNotFoundException, InvalidTroopParamsException {
        //arrange
        int id = 1;

        //act
        Troop actual = inMemoryTroopRepository.insert(new Archer(1, 3, 10));
        Troop expected = inMemoryTroopRepository.getTroop(id);

        // assert
        assertEquals(expected, actual);

    }


    @Test
    void shouldReturnExceptionWhenThereIsNoTroopWithPassedId() {
        //act & assert
        assertThrows(TroopNotFoundException.class, () -> inMemoryTroopRepository.getTroop(3));

    }

    @Test
    void shouldReturnAllAvailableTroopsInDatabase() throws InvalidTroopParamsException {
        //arrange
        Troop actual = inMemoryTroopRepository.insert(new Archer(1, 3, 10));
        Troop actual1 = inMemoryTroopRepository.insert(new Barbarian(2, 6, 20));
        Troop actual2 = inMemoryTroopRepository.insert(new Archer(3, 3, 10));
        //act
        List<Troop> allTroops = inMemoryTroopRepository.getAllTroops();
        // assert
        assertEquals(3, allTroops.size());

    }

}