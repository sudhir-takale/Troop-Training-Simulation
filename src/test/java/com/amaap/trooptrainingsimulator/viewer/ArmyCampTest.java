package com.amaap.trooptrainingsimulator.viewer;

import com.amaap.trooptrainingsimulator.domain.models.Trooper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

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

    @Test
    void shouldBeAbleToDisplayTrainedTroops() {
//        Arrange
        armyCamp.getTrainedTroops().put(Trooper.ARCHER, 23);
        armyCamp.getTrainedTroops().put(Trooper.BARBARIAN, 4);
//        Act
        Map<Trooper, Integer> trainedTroops = armyCamp.viewTrainedTroops();
//       Assert
        Assertions.assertEquals(2, trainedTroops.size());
    }

    @Test
    void shouldAddTroopsToTrainedTroopsMap() {
        // Arrange
        armyCamp.getTrainedTroops().put(Trooper.ARCHER, 10);
        // Act
        armyCamp.getTrainedTroops().put(Trooper.BARBARIAN, 15);
        // Assert
        Assertions.assertTrue(armyCamp.getTrainedTroops().containsKey(Trooper.ARCHER));
        Assertions.assertEquals(10, armyCamp.getTrainedTroops().get(Trooper.ARCHER));
    }

}