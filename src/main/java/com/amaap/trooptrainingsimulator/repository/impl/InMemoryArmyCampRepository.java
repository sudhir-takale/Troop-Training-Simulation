package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.ArmyCampRepository;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDB;

import java.util.Map;

public class InMemoryArmyCampRepository implements ArmyCampRepository {

    private InMemoryDB inMemoryDB;

    public InMemoryArmyCampRepository(InMemoryDB inMemoryDB) {
        this.inMemoryDB = inMemoryDB;
    }

    @Override
    public boolean update(TroopType troopType) {
        return inMemoryDB.updateTrainedTroop(troopType);
    }

    @Override
    public Map<TroopType, Integer> getTrainedTroops() {
        return inMemoryDB.getTrainedTroops();
    }
}
