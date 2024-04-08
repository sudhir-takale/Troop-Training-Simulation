package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.BarrackRepository;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDatabaseImpl;

import java.util.Queue;

public class InMemoryBarrackRepository implements BarrackRepository {
    private InMemoryDatabaseImpl inMemoryDatabaseImpl;

    public InMemoryBarrackRepository(InMemoryDatabaseImpl inMemoryDatabaseImpl) {
        this.inMemoryDatabaseImpl = inMemoryDatabaseImpl;
    }

    @Override
    public void add(Troop troop) {
        inMemoryDatabaseImpl.insert(troop);
    }
    @Override
    public Queue<Troop> getBarracksQueue() {

      return inMemoryDatabaseImpl.getBarracks();
    }
}
