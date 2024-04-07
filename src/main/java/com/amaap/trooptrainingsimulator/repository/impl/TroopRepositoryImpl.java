package com.amaap.trooptrainingsimulator.repository.impl;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.TroopRepository;
import com.amaap.trooptrainingsimulator.repository.dao.Archer;
import com.amaap.trooptrainingsimulator.repository.dao.Barbarian;
import com.amaap.trooptrainingsimulator.repository.dao.Troop;
import com.amaap.trooptrainingsimulator.service.BarrackService;

public class TroopRepositoryImpl implements TroopRepository {
    private BarrackService barrackService;

    public TroopRepositoryImpl(BarrackService barrackService) {
        this.barrackService = barrackService;
    }

    @Override
    public boolean create(TroopType troopType, int count) {

        for (int i = 0; i < count; i++) {
            Troop troop;
            if (TroopType.ARCHER == troopType) {
                troop = new Archer();
            } else {
                troop = new Barbarian();
            }
            barrackService.add(troop);
        }
        return true;
    }


}
