package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.BarrackRepository;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDatabase;

import java.util.Queue;

public class InMemoryBarrackRepository implements BarrackRepository {
    private InMemoryDatabase inMemoryDatabase;

    public InMemoryBarrackRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public void add(Troop troop) {
        inMemoryDatabase.insert(troop);
    }
    @Override
    public Queue<Troop> getBarracksQueue() {

      return inMemoryDatabase.getBarracks();
    }
}
