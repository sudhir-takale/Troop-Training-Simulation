package com.amaap.trooptrainingsimulator.repository.db;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;

import java.util.List;
import java.util.Queue;

public interface InMemoryDB {

     Troop add(Troop troop);

    public Troop get(int id) throws TroopNotFoundException;

     List<Troop> getAllTroops();
     void insert(Troop troop);
     Queue<Troop> getBarracks();
}
