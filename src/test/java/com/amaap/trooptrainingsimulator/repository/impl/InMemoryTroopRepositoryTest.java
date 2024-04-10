package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.amaap.trooptrainingsimulator.utility.Builder.getArcher;
import static com.amaap.trooptrainingsimulator.utility.Builder.getBarbarian;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class InMemoryTroopRepositoryTest {

    InMemoryTroopRepository inMemoryTroopRepository = new InMemoryTroopRepository(new FakeInMemoryDatabase());

    @Test
    void shouldBeAbleToStoreTheTroopInMemory() throws TroopNotFoundException, InvalidTroopParamsException {
        //arrange
        int id = 1;

        //act
        Troop actual = inMemoryTroopRepository.insert(getArcher());
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
        Troop actual = inMemoryTroopRepository.insert(getArcher());
        Troop actual1 = inMemoryTroopRepository.insert(getBarbarian());
        Troop actual2 = inMemoryTroopRepository.insert(getArcher());
        //act
        List<Troop> allTroops = inMemoryTroopRepository.getAllTroops();
        // assert
        assertEquals(3, allTroops.size());

    }

}