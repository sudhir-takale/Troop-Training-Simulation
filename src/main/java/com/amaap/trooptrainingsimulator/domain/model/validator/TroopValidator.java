package com.amaap.trooptrainingsimulator.domain.model.validator;

public class TroopValidator {
    public static boolean validate(int trainingTime, int trainingCost) {
        return (trainingCost == 10 || trainingCost == 20) && (trainingTime == 3 || trainingTime == 6);
    }
}
