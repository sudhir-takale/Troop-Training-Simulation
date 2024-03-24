package com.amaap.trooptrainingsimulator.domain.services;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.domain.models.Troop;
import com.amaap.trooptrainingsimulator.domain.models.Trooper;
import com.amaap.trooptrainingsimulator.models.Archers;
import com.amaap.trooptrainingsimulator.models.Barbarian;
import com.amaap.trooptrainingsimulator.viewer.ArmyCamp;

import java.util.Iterator;
import java.util.Map;

public class TrainService {

    private final ArmyCamp armyCamp;

    public TrainService(ArmyCamp armyCamp) {
        this.armyCamp = armyCamp;
    }

    public boolean trainTroops(Barrack barrack) {
        Iterator<Troop> iterator = barrack.getTroops().iterator();
        while (iterator.hasNext()) {
            Troop troop = iterator.next();
            startTraining(troop);
            updateTrainedTroopsInArmyCamp(troop);
            iterator.remove();
        }
        return true;

    }

    private void updateTrainedTroopsInArmyCamp(Troop troop) {
        Map<Trooper, Integer> trainedTroops = armyCamp.getTrainedTroops();

        Trooper trooperType = null;
        if (troop instanceof Archers) {
            trooperType = Trooper.ARCHER;
        } else if (troop instanceof Barbarian) {
            trooperType = Trooper.BARBARIAN;
        }

        if (trooperType != null) {
            if (trainedTroops.containsKey(trooperType)) {
                trainedTroops.put(trooperType, trainedTroops.get(trooperType) + 1);
            } else {
                trainedTroops.put(trooperType, 1);
            }
        }

    }

    private void startTraining(Troop troop) {
        System.out.println("Training...");
        System.out.println("Training complete. troops are available in the troop camp.");
    }
}
