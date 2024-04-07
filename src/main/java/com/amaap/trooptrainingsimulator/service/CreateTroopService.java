package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.TroopRepository;

public class CreateTroopService {

    TroopRepository troopRepository = new TroopRepository(new BarrackService());
    public boolean createTroop(TroopType troopType, int count) {

        return troopRepository.create(troopType, count);
    }
}
