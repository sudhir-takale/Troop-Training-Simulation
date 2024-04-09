package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.ArmyCampRepository;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDB;

public class InMemoryArmyCampRepository implements ArmyCampRepository {

    private InMemoryDB inMemoryDB;

    public InMemoryArmyCampRepository(InMemoryDB inMemoryDB) {
        this.inMemoryDB = inMemoryDB;
    }

    @Override
    public boolean update(TroopType troopType) {
        return inMemoryDB.updateTrainedTroop(troopType);
    }
}
