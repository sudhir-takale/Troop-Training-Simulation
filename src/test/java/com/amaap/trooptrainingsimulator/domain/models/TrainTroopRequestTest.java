package com.amaap.trooptrainingsimulator.domain.models;

import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrainTroopRequestTest {

    @Test
    void shouldThrowInvalidCountExceptionWhenCountIsLessThanZero() {
//        Arrange & Act& Assert
        Assertions.assertThrows(InvalidCountException.class, () -> new TrainTroopRequest(Trooper.ARCHER, -1));
        Assertions.assertThrows(InvalidCountException.class, () -> new TrainTroopRequest(Trooper.BARBARIAN, -2));
    }




}