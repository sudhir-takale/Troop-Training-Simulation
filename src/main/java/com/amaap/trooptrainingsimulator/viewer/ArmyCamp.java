package com.amaap.trooptrainingsimulator.viewer;

import com.amaap.trooptrainingsimulator.domain.models.Trooper;

import java.util.HashMap;
import java.util.Map;

public class ArmyCamp {
    private Map<Trooper, Integer> trainedTroops = new HashMap<>();

    public Map<Trooper, Integer> getTrainedTroops() {
        return trainedTroops;
    }
}
