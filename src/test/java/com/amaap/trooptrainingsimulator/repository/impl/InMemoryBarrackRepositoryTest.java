package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class InMemoryBarrackRepositoryTest {

    InMemoryBarrackRepository inMemoryBarrackRepository = new InMemoryBarrackRepository(new InMemoryDatabase());
    @Test
    void shouldBeAbleToAddATroopIntoBarrack() {
        //arrange
        Troop troop = new Archer(1, 6, 20);
        //act
        inMemoryBarrackRepository.add(troop);
        //assert
        assertEquals(1, inMemoryBarrackRepository.getBarracksQueue().size());

    }

}