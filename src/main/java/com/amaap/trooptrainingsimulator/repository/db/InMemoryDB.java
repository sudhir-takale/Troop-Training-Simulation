package com.amaap.trooptrainingsimulator.repository.db;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public interface InMemoryDB {

    Troop add(Troop troop);

    Troop get(int id) throws TroopNotFoundException;

    List<Troop> getAllTroops();

    void insert(Troop troop);

    Queue<Troop> getBarracks();

    boolean updateTrainedTroop(TroopType troopType);

    Map<TroopType, Integer> getTrainedTroops();


}
