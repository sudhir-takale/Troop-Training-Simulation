package com.amaap.trooptrainingsimulator.repository.db;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.repository.db.exception.TroopNotFoundException;

import java.util.*;

public class FakeInMemoryDatabase implements InMemoryDB {

    private List<Troop> troopList = new ArrayList<>();
    private Queue<Troop> barracksQueue = new LinkedList<>();
    private Map<TroopType, Integer> trainedTroops = new HashMap<>();

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

    @Override
    public boolean updateTrainedTroop(TroopType troopType) {
            if (!trainedTroops.containsKey(troopType)) {
                trainedTroops.put(troopType, 1);
            }else {
                trainedTroops.put(troopType, trainedTroops.get(troopType) + 1);
            }
        return true;
    }

    @Override
    public Map<TroopType, Integer> getTrainedTroops() {
        return this.trainedTroops;
    }


}
