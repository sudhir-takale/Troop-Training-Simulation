package com.amaap.trooptrainingsimulator.domain.model.exception;

public class InvalidTroopParamsException extends Throwable {
    public InvalidTroopParamsException(String invalidParametersPassed) {
        super(invalidParametersPassed);
    }
}
