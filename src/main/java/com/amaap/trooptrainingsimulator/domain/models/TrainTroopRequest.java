package com.amaap.trooptrainingsimulator.domain.models;

import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;

public class TrainTroopRequest {
    private Trooper troop;
    private int count;

    public TrainTroopRequest(Trooper troop, int count) throws InvalidCountException {
        if (count < 1 || count > 10) throw new InvalidCountException(count + "");
        this.troop = troop;
        this.count = count;
    }

}
