package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.ArmyCampRepository;
import com.google.inject.Inject;

import java.util.Map;

public class ArmyCampService {
    private final ArmyCampRepository armyCampRepository;

    @Inject
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
