package com.amaap.trooptrainingsimulator.domain.services;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.domain.models.TrainTroopRequest;
import com.amaap.trooptrainingsimulator.domain.models.Troop;
import com.amaap.trooptrainingsimulator.domain.models.Trooper;
import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import com.amaap.trooptrainingsimulator.models.Archers;
import com.amaap.trooptrainingsimulator.models.Barbarian;

public class BarrackService {

    private Barrack barrack;

    public BarrackService(Barrack barrack) {
        this.barrack = barrack;
    }

    public void addTroops(TrainTroopRequest request) throws InvalidCountException {

        if (request.getCount() < 1 || request.getCount() > 10) throw new InvalidCountException("Invalid count please");
        int numberOfTroopsToAdd = request.getCount();
        for (int i = 0; i < numberOfTroopsToAdd; i++) {
            Troop troop = createTroop(request);
            if (barrack.getTroops().size() < barrack.getCapacity()) {
                barrack.getTroops().add(troop);
            } else {
                barrack.getWaitingList().add(troop);
            }
        }
    }

    private Troop createTroop(TrainTroopRequest request) {
        return (request.getTroop() == Trooper.ARCHER) ? new Archers() : new Barbarian();
    }

    public void processWaitingList() {
        int freeSpace = barrack.getCapacity() - barrack.getTroops().size();
        if (freeSpace > 0) {
            int troopsToMove = Math.min(freeSpace, barrack.getWaitingList().size());
            for (int i = 0; i < troopsToMove; i++) {
                Troop troop = barrack.getWaitingList().remove(0);
                barrack.getTroops().add(troop);
            }
        }
    }
}
