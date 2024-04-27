package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Barbarian;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryTroopRepository;
import com.amaap.trooptrainingsimulator.service.exception.InvalidTroopException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class TroopServiceTest {

    TroopService troopService = new TroopService(new InMemoryTroopRepository(new FakeInMemoryDatabase()));


    @Test
    void shouldBeAbleToCreateArcher() throws InvalidTroopParamsException, InvalidTroopException {
        //arrange
        TroopType troopType = TroopType.ARCHER;

        //act
        Troop expected = new Archer(1, 6, 20);
        Troop actual = troopService.create(troopType);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCreateBarbarian() throws InvalidTroopParamsException, InvalidTroopException {
        //arrange
        TroopType troopType = TroopType.BARBARIAN;

        //act
        Troop expected = new Barbarian(1, 3, 10);
        Troop actual = troopService.create(troopType);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenInvalidTrooperPassed() {
        //assert
        assertThrows(InvalidTroopException.class, () -> {
            troopService.create(TroopType.UNKNOWN);

        });
    }

    @Test
    void shouldBeAbleToGetTroops() throws InvalidTroopParamsException, InvalidTroopException {
        //arrange
        TroopType troopType = TroopType.BARBARIAN;
        troopService.create(troopType);
        troopService.create(TroopType.ARCHER);
        troopService.create(TroopType.ARCHER);
        troopService.create(TroopType.ARCHER);
        troopService.create(TroopType.ARCHER);
        troopService.create(TroopType.ARCHER);
        troopService.create(TroopType.BARBARIAN);
        troopService.create(TroopType.BARBARIAN);
        troopService.create(TroopType.BARBARIAN);
        troopService.create(TroopType.BARBARIAN);

        //act
        List<Troop> troops = troopService.getTroops(TroopType.BARBARIAN, 4);

        // assert
        assertEquals(4, troops.size());
    }


}