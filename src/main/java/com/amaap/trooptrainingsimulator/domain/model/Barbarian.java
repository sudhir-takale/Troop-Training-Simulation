package com.amaap.trooptrainingsimulator.domain.model;

import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;

public class Barbarian extends Troop {
    public Barbarian(int id, int trainingTime, int trainingCost) throws InvalidTroopParamsException {
        super(id, trainingTime, trainingCost);
    }

}
