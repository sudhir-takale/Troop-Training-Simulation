package com.amaap.trooptrainingsimulator.domain.model;

import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class TroopTest {


    @Test
    void shouldReturnTrueWhenObjectsAreEqual() throws InvalidTroopParamsException {
        // arrange
        Troop troop1 = new Archer(1, 3, 20);
        Troop troop2 = new Archer(1, 3, 20);
        Troop troop3 = new Barbarian(1, 6, 20);
        Troop troop4 = new Barbarian(1, 6, 20);

        // act & assert
        assertTrue(troop1.equals(troop2));
        assertEquals(troop1.hashCode(), troop2.hashCode());
        assertTrue(troop3.equals(troop4));
        assertEquals(troop3.hashCode(), troop4.hashCode());
    }

    @Test
    public void shouldReturnFalseWhenDifferentIds() throws InvalidTroopParamsException {
        // arrange
        Troop troop1 = new Archer(1, 3, 20);
        Troop troop2 = new Archer(3, 3, 20);
        Troop troop3 = new Barbarian(1, 6, 20);
        Troop troop4 = new Barbarian(4, 6, 20);

        // act & assert
        assertFalse(troop1.equals(troop2));
        assertNotEquals(troop1.hashCode(), troop2.hashCode());
        assertFalse(troop3.equals(troop4));
        assertNotEquals(troop4.hashCode(), troop3.hashCode());
    }

    @Test
    void shouldReturnIdOfObject() throws InvalidTroopParamsException {
        // arrange
        Troop troop1 = new Archer(1, 3, 20);

        // act & assert
        assertEquals(1, troop1.getId());
    }

    @Test
    void shouldThrowExceptionWhenInvalidParameterPassed() {
        //act & assert
        Assertions.assertThrows(InvalidTroopParamsException.class, () -> new Troop(1, -23, 23));
    }

    @Test
    void shouldNotThrowExceptionWhenValidParameterPassed() {
        //act & assert
        Assertions.assertDoesNotThrow(() -> new Troop(1, 3, 20));
    }


}