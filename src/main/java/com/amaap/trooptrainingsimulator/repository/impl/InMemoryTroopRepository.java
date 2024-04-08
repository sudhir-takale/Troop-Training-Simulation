package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.TroopRepository;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDatabaseImpl;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;

import java.util.List;


public class InMemoryTroopRepository implements TroopRepository {

    private InMemoryDatabaseImpl inMemoryDatabaseImpl;

    public InMemoryTroopRepository(InMemoryDatabaseImpl inMemoryDatabaseImpl) {
        this.inMemoryDatabaseImpl = inMemoryDatabaseImpl;
    }

    @Override
    public Troop insert(Troop troop) {
        return inMemoryDatabaseImpl.add(troop);
    }

    @Override
    public Troop getTroop(int id) throws TroopNotFoundException {
        return inMemoryDatabaseImpl.get(id);
    }

    public List<Troop> getAllTroops() {

        return inMemoryDatabaseImpl.getAllTroops();
    }
}
