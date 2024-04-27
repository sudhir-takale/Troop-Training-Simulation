package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.TroopRepository;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;
import com.google.inject.Inject;

import java.util.List;


public class InMemoryTroopRepository implements TroopRepository {

    private final FakeInMemoryDatabase fakeInMemoryDatabase;

    @Inject
    public InMemoryTroopRepository(FakeInMemoryDatabase fakeInMemoryDatabase) {
        this.fakeInMemoryDatabase = fakeInMemoryDatabase;
    }

    @Override
    public Troop insert(Troop troop) {
        return fakeInMemoryDatabase.add(troop);
    }

    @Override
    public Troop getTroop(int id) throws TroopNotFoundException {
        return fakeInMemoryDatabase.get(id);
    }

    public List<Troop> getAllTroops() {

        return fakeInMemoryDatabase.getAllTroops();
    }


}
