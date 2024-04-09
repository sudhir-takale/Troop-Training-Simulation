package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.BarrackRepository;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;

import java.util.Queue;

public class InMemoryBarrackRepository implements BarrackRepository {
    private FakeInMemoryDatabase fakeInMemoryDatabase;

    public InMemoryBarrackRepository(FakeInMemoryDatabase fakeInMemoryDatabase) {
        this.fakeInMemoryDatabase = fakeInMemoryDatabase;
    }

    @Override
    public void add(Troop troop) {
        fakeInMemoryDatabase.insert(troop);
    }
    @Override
    public Queue<Troop> getBarracksQueue() {

      return fakeInMemoryDatabase.getBarracks();
    }
}
