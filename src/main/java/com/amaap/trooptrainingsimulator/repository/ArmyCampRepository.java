package com.amaap.trooptrainingsimulator.repository;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;

import java.util.Map;

public interface ArmyCampRepository {

     boolean update(TroopType troopType) ;


     Map<TroopType, Integer> getTrainedTroops();
}

