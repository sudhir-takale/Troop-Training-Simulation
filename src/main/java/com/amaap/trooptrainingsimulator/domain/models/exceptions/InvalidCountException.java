package com.amaap.trooptrainingsimulator.domain.models.exceptions;

public class InvalidCountException extends Exception {

    public InvalidCountException(String count) {
        super(count);
    }
}
