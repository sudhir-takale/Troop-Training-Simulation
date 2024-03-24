package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;

public class Gamer {
    private TrainingManager trainingManager;

    public Gamer(TrainingManager trainingManager) {
        this.trainingManager = trainingManager;
    }

    public boolean trainTheNewTroop(String archers, int count) throws InvalidCountException {

        return trainingManager.trainTheNewTroop(archers, count);
    }
}
