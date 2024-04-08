package com.amaap.trooptrainingsimulator.domain.model;

import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;

public class Archer extends Troop {
    public Archer(int id, int trainingTime, int trainingCost) throws InvalidTroopParamsException {
        super(id, trainingTime, trainingCost);
    }
}
