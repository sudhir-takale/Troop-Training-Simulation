package com.amaap.trooptrainingsimulator.domain.services;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.domain.models.TrainTroopRequest;
import com.amaap.trooptrainingsimulator.domain.models.Troop;
import com.amaap.trooptrainingsimulator.domain.models.Trooper;
import com.amaap.trooptrainingsimulator.models.Archers;
import com.amaap.trooptrainingsimulator.models.Barbarian;

public class BarrackService {

    private Barrack barrack;

    public BarrackService(Barrack barrack) {
        this.barrack = barrack;
    }

    public void addTroops(TrainTroopRequest request) {
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

        if (request.getTroop() == Trooper.ARCHER) {
            return new Archers();
        }
        return new Barbarian();
    }


}
