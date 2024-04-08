package com.amaap.trooptrainingsimulator.repository;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;

import java.util.List;

public interface TroopRepository {
    public Troop insert(Troop troop);

    Troop getTroop(int id) throws TroopNotFoundException;

    List<Troop> getAllTroops();
}
