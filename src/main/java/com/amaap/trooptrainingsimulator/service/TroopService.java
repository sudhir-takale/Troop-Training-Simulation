package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Barbarian;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.TroopRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryTroopRepository;

public class TroopService {
    public Troop create(TroopType troopType, int trainingTime, int trainingCost) {
        Troop troop;

        if (TroopType.ARCHER == troopType) {
            troop = new Archer(1, trainingTime, trainingCost);
        } else {
            troop = new Barbarian(1, trainingTime, trainingCost);
        }

        TroopRepository troopRepository = new InMemoryTroopRepository();
        return troopRepository.insert(troop);

    }
}
