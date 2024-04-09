package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.ArmyCampRepository;

public class InMemoryArmyCampRepository implements ArmyCampRepository {
    @Override
    public boolean update(TroopType troopType) {
        return true;
    }
}
