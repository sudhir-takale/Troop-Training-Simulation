package com.amaap.trooptrainingsimulator.domain.models;

import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrainTroopRequestTest {


    @Test
    void shouldThrowInvalidCountExceptionWhenCountIsLessThanZeroOrCountIsGreaterThanTen() {
//        Arrange & Act& Assert
        Assertions.assertThrows(InvalidCountException.class, () -> new TrainTroopRequest(Trooper.ARCHER, -1));
        Assertions.assertThrows(InvalidCountException.class, () -> new TrainTroopRequest(Trooper.BARBARIAN, -2));
        Assertions.assertThrows(InvalidCountException.class, () -> new TrainTroopRequest(Trooper.BARBARIAN, 0));
        Assertions.assertThrows(InvalidCountException.class, () -> new TrainTroopRequest(Trooper.ARCHER, 23));
    }

    @Test
    void shouldNotThrowExceptionIfValidInputPassed() {
//        Arrange & Act& Assert
        Assertions.assertDoesNotThrow(() -> new TrainTroopRequest(Trooper.ARCHER, 10));
        Assertions.assertDoesNotThrow(() -> new TrainTroopRequest(Trooper.ARCHER, 5));
    }



}