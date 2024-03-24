package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.domain.models.Trooper;
import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;

public class Gamer {
    private TrainingManager trainingManager;

    public Gamer(TrainingManager trainingManager) {
        this.trainingManager = trainingManager;
    }

    public boolean trainTheNewTroop(Trooper troop, int count) throws InvalidCountException {
        return trainingManager.trainTheNewTroop(troop, count);
    }



}
