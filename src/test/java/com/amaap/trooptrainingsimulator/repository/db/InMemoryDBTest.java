package com.amaap.trooptrainingsimulator.repository.db;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class InMemoryDBTest {
    InMemoryDB inMemoryDB = new FakeInMemoryDatabase();

    @Test
    void shouldBeAbleToAddNewTrooperToDatabase() throws InvalidTroopParamsException {
        // arrange
        Troop added = new Troop(1, 3, 10);

        // act
        Troop actual = inMemoryDB.add(added);

        // assert
        assertEquals(added, actual);
    }

    @Test
    void shouldBeAbleToGetTrooperById() throws InvalidTroopParamsException, TroopNotFoundException {
        // arrange
        Troop created = inMemoryDB.add(new Troop(1, 3, 10));

        // act
        Troop troop = inMemoryDB.get(1);

        // act
        assertEquals(1, troop.getId());
    }

    @Test
    void shouldBeAbleToGetAllTroopers() throws InvalidTroopParamsException {
        // arrange
        inMemoryDB.add(new Troop(1, 3, 10));
        inMemoryDB.add(new Troop(2, 3, 10));
        inMemoryDB.add(new Troop(3, 3, 10));

        // act
        List<Troop> allTroops = inMemoryDB.getAllTroops();

        // assert
        assertEquals(3, allTroops.size());
    }


    @Test
    void shouldBeAbleToGetTrooperFromBarracks() throws InvalidTroopParamsException {
        // arrange
        inMemoryDB.insert(new Troop(1, 3, 10));
        inMemoryDB.insert(new Troop(1, 3, 10));
        inMemoryDB.insert(new Troop(1, 3, 10));

        // act
        Queue<Troop> barracks = inMemoryDB.getBarracks();

        // assert
        assertEquals(3, barracks.size());
    }

    @Test
    void shouldBeAbleToUpdateCountOfTrooper() throws InvalidTroopParamsException {
        // arrange
        Troop troop = new Troop(1, 3, 10);
        inMemoryDB.insert(troop);

        // act
        boolean b = inMemoryDB.updateTrainedTroop(TroopType.BARBARIAN);

        // assert
        assertTrue(b);

    }

    @Test
    void shouldBeAbleToGetTrainedTroop() {
        // arrange
        inMemoryDB.updateTrainedTroop(TroopType.BARBARIAN);
        inMemoryDB.updateTrainedTroop(TroopType.BARBARIAN);
        inMemoryDB.updateTrainedTroop(TroopType.BARBARIAN);

        // act
        Map<TroopType, Integer> trainedTroops = inMemoryDB.getTrainedTroops();

        // assert
        assertEquals(1, trainedTroops.size());


    }
}