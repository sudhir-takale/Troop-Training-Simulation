package com.amaap.trooptrainingsimulator.viewer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArmyCampTest {
    private ArmyCamp armyCamp;

    @BeforeEach
    public void setUp() {
        armyCamp = new ArmyCamp();
    }

    @Test
    void shouldReturnEmptyTrainedTroopsMap() {

//        Act & Assert
        Assertions.assertEquals(0, armyCamp.getTrainedTroops().size());
    }

}