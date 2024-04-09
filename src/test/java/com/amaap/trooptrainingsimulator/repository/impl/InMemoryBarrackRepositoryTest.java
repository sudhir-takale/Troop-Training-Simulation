package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class InMemoryBarrackRepositoryTest {

    InMemoryBarrackRepository inMemoryBarrackRepository = new InMemoryBarrackRepository(new FakeInMemoryDatabase());
    @Test
    void shouldBeAbleToAddATroopIntoBarrack() throws InvalidTroopParamsException {
        //arrange
        Troop troop = new Archer(1, 6, 20);
        Troop troop1 = new Archer(1, 6, 20);
        Troop troop2 = new Archer(1, 6, 20);
        //act
        inMemoryBarrackRepository.add(troop);
        inMemoryBarrackRepository.add(troop1);
        inMemoryBarrackRepository.add(troop2);
        //assert
        assertEquals(3, inMemoryBarrackRepository.getBarracksQueue().size());

    }

}