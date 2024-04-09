package com.amaap.trooptrainingsimulator.domain.model;

import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class BarbarianTest {

    @Test
    void shouldReturnTrueWhenObjectsAreEqual() throws InvalidTroopParamsException {
        // arrange
        Troop troop1 = new Barbarian(1, 3, 20);
        Troop troop2 = new Barbarian(1, 3, 20);

        // act & assert
        assertTrue(troop1.equals(troop2));
        assertEquals(troop1.hashCode(), troop2.hashCode());
    }

    @Test
    public void shouldReturnFalseWhenDifferentIds() throws InvalidTroopParamsException {
        // arrange
        Troop troop1 = new Barbarian(1, 3, 20);
        Troop troop2 = new Barbarian(2, 3, 20);

        // act & assert
        assertFalse(troop1.equals(troop2));
        assertNotEquals(troop1.hashCode(), troop2.hashCode());
    }

    @Test
    void shouldReturnIdOfObject() throws InvalidTroopParamsException {
        // arrange
        Troop troop1 = new Barbarian(1, 3, 20);

        // act & assert
        assertEquals(1, troop1.getId());
    }


}