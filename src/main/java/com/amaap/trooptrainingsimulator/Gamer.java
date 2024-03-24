package com.amaap.trooptrainingsimulator;

public class Gamer {
    private TrainingManager trainingManager;

    public Gamer(TrainingManager trainingManager) {
        this.trainingManager = trainingManager;
    }

    public boolean trainTheNewTroop() {

        return trainingManager.trainTheNewTroop();
    }
}
