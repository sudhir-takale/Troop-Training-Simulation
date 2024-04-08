package com.amaap.trooptrainingsimulator.domain.model.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TroopValidatorTest {

    @Test
    public void shouldReturnTrueIfValidParameterPassed() {
        //assert
        assertTrue(TroopValidator.validate(3, 10));
        assertTrue(TroopValidator.validate(6, 10));
        assertTrue(TroopValidator.validate(3, 20));
        assertTrue(TroopValidator.validate(6, 20));
    }

    @Test
    public void shouldReturnFalseIfInvalidParameter(){
        //assert
        assertFalse(TroopValidator.validate(3, 15));
        assertFalse(TroopValidator.validate(7, 20));
        assertFalse(TroopValidator.validate(6, 25));
        assertFalse(TroopValidator.validate(5, 15));
    }

}