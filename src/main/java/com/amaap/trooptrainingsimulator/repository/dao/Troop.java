package com.amaap.trooptrainingsimulator.repository.dao;

public class Troop {

    private int trainingTime;
    private int trainingCost;

    public Troop(int trainingTime, int trainingCost) {
        this.trainingTime = trainingTime;
        this.trainingCost = trainingCost;
    }

    public int getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(int trainingTime) {
        this.trainingTime = trainingTime;
    }

    public int getTrainingCost() {
        return trainingCost;
    }

    public void setTrainingCost(int trainingCost) {
        this.trainingCost = trainingCost;
    }
}
