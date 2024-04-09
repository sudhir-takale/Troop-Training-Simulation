package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.ArmyCampRepository;

public class ArmyCampService {
    private ArmyCampRepository armyCampRepository;

    public ArmyCampService(ArmyCampRepository armyCampRepository) {
        this.armyCampRepository = armyCampRepository;
    }

    public boolean updateTroopCount(TroopType troopType) {
        return armyCampRepository.update(troopType);
    }
}
