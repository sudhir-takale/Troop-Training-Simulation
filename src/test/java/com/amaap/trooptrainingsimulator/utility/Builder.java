package com.amaap.trooptrainingsimulator.utility;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;

public class Builder {

    public static Troop getArcher() throws InvalidTroopParamsException {
        return new Archer(1, 6, 20);
    }

     public static Troop getBarbarian() throws InvalidTroopParamsException {
        return new Archer(1, 3, 10);
    }

}
