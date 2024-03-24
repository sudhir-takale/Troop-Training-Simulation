package com.amaap.trooptrainingsimulator.domain.services;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.domain.models.Troop;

import java.util.Iterator;

public class TrainService {


    public boolean trainTroops(Barrack barrack) {

        Iterator<Troop> iterator = barrack.getTroops().iterator();
        while (iterator.hasNext()) {
            Troop troop = iterator.next();
            startTraining(troop);
            iterator.remove();
        }
        return true;

    }

    private void startTraining(Troop troop) {
        System.out.println("Training...");
        System.out.println("Training complete. troops are available in the troop camp.");

    }
}
