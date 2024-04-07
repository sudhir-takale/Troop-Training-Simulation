package com.amaap.trooptrainingsimulator.repository;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.dao.Archer;
import com.amaap.trooptrainingsimulator.repository.dao.Barbarian;
import com.amaap.trooptrainingsimulator.repository.dao.Troop;
import com.amaap.trooptrainingsimulator.service.BarrackService;

public class TroopRepository {

    private final BarrackService barrackService;

    public TroopRepository(BarrackService barrackService) {
        this.barrackService = barrackService;
    }

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
