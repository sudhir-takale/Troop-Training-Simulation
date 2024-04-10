package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.amaap.trooptrainingsimulator.utility.Builder.getArcher;

class InMemoryBarrackRepositoryTest {

    InMemoryBarrackRepository inMemoryBarrackRepository = new InMemoryBarrackRepository(new FakeInMemoryDatabase());
    @Test
    void shouldBeAbleToAddATroopIntoBarrack() throws InvalidTroopParamsException {
        //arrange
        Troop troop = getArcher();
        Troop troop1 = getArcher();
        Troop troop2 = getArcher();
        //act
        inMemoryBarrackRepository.add(troop);
        inMemoryBarrackRepository.add(troop1);
        inMemoryBarrackRepository.add(troop2);
        //assert
        Assertions.assertEquals(3, inMemoryBarrackRepository.getBarracksQueue().size());

    }

}