package com.amaap.trooptrainingsimulator.viewer;

import com.amaap.trooptrainingsimulator.domain.models.Trooper;

import java.util.HashMap;
import java.util.Map;

public class ArmyCamp {
    private Map<Trooper, Integer> trainedTroops = new HashMap<>();

    public Map<Trooper, Integer> viewTrainedTroops() {
        System.out.println("Trained Troops:");
        for (Map.Entry<Trooper, Integer> entry : trainedTroops.entrySet()) {
            Trooper trooper = entry.getKey();
            int count = entry.getValue();
            System.out.println(trooper + ": " + count);

        }
        return trainedTroops;
    }

    public Map<Trooper, Integer> getTrainedTroops() {
        return trainedTroops;
    }
}
