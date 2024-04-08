package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class InMemoryTroopRepositoryTest {

    InMemoryTroopRepository inMemoryTroopRepository = new InMemoryTroopRepository();

    @Test
    void shouldBeAbleToStoreTheTroopInMemory() throws TroopNotFoundException {
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

}