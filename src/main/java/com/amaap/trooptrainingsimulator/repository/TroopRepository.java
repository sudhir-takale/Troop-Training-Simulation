package com.amaap.trooptrainingsimulator.repository;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;

public interface TroopRepository {

     boolean create(TroopType troopType, int count);

}
