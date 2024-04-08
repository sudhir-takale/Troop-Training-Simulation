package com.amaap.trooptrainingsimulator.repository.db;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase {

    private List<Troop> troopList = new ArrayList<>();

    public Troop add(Troop troop) {
        troopList.add(troop);
        return troop;
    }

    public Troop get(int id) throws TroopNotFoundException {
        Troop result = null;
        for (Troop troop : troopList) {
            if (troop.getId() == id) {
                result = troop;
                break;
            }
        }
        if (result == null) {
            throw new TroopNotFoundException("Troop not found " + id);
        }
        return result;
    }

    public List<Troop> getAllTroops() {
        return this.troopList;
    }
}
