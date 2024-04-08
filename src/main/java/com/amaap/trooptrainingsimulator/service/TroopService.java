package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Barbarian;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.TroopRepository;

public class TroopService {
    private TroopRepository troopRepository;

    public TroopService(TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    public Troop create(TroopType troopType, int trainingTime, int trainingCost) {
        // validations
        Troop troop;

        if (TroopType.ARCHER == troopType) {
            troop = new Archer(1, trainingTime, trainingCost);
        } else {
            troop = new Barbarian(1, trainingTime, trainingCost);
        }

        return troopRepository.insert(troop);

    }
}
