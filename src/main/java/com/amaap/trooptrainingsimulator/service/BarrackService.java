package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.BarrackRepository;

import java.util.List;

public class BarrackService {

    BarrackRepository barrackRepository;

    public BarrackService(BarrackRepository barrackRepository) {
        this.barrackRepository = barrackRepository;
    }

    public boolean addTroops(List<Troop> troops, int count) {

        for (int i = 0; i < count; i++) {
            barrackRepository.add(troops.get(i));
        }
        return true;
    }
}
