package com.amaap.trooptrainingsimulator.domain.model.validator;

import com.amaap.trooptrainingsimulator.domain.model.TroopType;

public class TroopValidator {
    public static boolean validate(int trainingTime, int trainingCost) {
        return (trainingCost == 10 || trainingCost == 20) && (trainingTime == 3 || trainingTime == 6);
    }

    public static boolean validatesType(TroopType troopType) {
        for (TroopType type : TroopType.values()) {
            if (type == troopType) {
                return true;
            }
        }
        return false;
    }
}
