package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.ArmyCampRepository;

import java.util.Map;

public class ArmyCampService {
    private ArmyCampRepository armyCampRepository;

    public ArmyCampService(ArmyCampRepository armyCampRepository) {
        this.armyCampRepository = armyCampRepository;
    }

    public boolean updateTroopCount(TroopType troopType) {
        return armyCampRepository.update(troopType);
    }

    public Map<TroopType, Integer> getTrainedTroops() {
        return armyCampRepository.getTrainedTroops();
    }
}
