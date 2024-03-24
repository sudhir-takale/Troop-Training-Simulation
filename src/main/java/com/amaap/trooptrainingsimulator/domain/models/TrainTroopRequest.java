package com.amaap.trooptrainingsimulator.domain.models;

import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;

public class TrainTroopRequest {

    private String troop;
    private int count;

    public TrainTroopRequest(Trooper troop, int count) throws InvalidCountException {
        if (count < 0) throw new InvalidCountException(count + "");
        this.troop = troop;
        this.count = count;
    }

}
