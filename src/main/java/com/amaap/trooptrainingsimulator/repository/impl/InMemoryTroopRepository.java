package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.TroopRepository;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;


public class InMemoryTroopRepository implements TroopRepository {

    InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();

    @Override
    public Troop insert(Troop troop) {
        return inMemoryDatabase.add(troop);
    }

    @Override
    public Troop getTroop(int id) throws TroopNotFoundException {
        return inMemoryDatabase.get(id);
    }

}
