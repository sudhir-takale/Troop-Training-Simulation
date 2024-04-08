package com.amaap.trooptrainingsimulator.repository.db;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InMemoryDatabaseImpl implements InMemoryDB{

    private List<Troop> troopList = new ArrayList<>();
    private Queue<Troop> barracksQueue = new LinkedList<>();

    @Override
    public Troop add(Troop troop) {
        troopList.add(troop);
        return troop;
    }

    @Override
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

    @Override
    public List<Troop> getAllTroops() {
        return this.troopList;
    }
    @Override
    public void insert(Troop troop) {
        barracksQueue.add(troop);
    }
    @Override
    public Queue<Troop> getBarracks() {
        return this.barracksQueue;
    }
}
