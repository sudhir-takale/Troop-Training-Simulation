package com.amaap.trooptrainingsimulator.domain.models;

import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;

public class TrainTroopRequest {
    private Trooper troop;
    private int count;

    public TrainTroopRequest(Trooper troop, int count) throws InvalidCountException {
        if (!validate(count)) throw new InvalidCountException(count + " Count is Invalid !");
        this.troop = troop;
        this.count = count;
    }

    private static boolean validate(int count) {
        return count >= 1 && count <= 10;
    }

    public Trooper getTroop() {
        return this.troop;
    }

    public int getCount() {
        return this.count;
    }
}
