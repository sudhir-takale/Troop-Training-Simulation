package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.TroopRepository;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;

import java.util.List;


public class InMemoryTroopRepository implements TroopRepository {

    private InMemoryDatabase inMemoryDatabase;

    public InMemoryTroopRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Troop insert(Troop troop) {
        return inMemoryDatabase.add(troop);
    }

    @Override
    public Troop getTroop(int id) throws TroopNotFoundException {
        return inMemoryDatabase.get(id);
    }

    public List<Troop> getAllTroops() {

        return inMemoryDatabase.getAllTroops();
    }
}
