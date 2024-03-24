package com.amaap.trooptrainingsimulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrainingManagerTest {
    @Test
    void shouldBeAbleToCreateTrainingManager() {
//        Arrange & Act
        TrainingManager trainingManager = new TrainingManager();
//        Assert
        Assertions.assertNotNull(trainingManager);

    }

    @Test
    void shouldBeAbleToCreateTroopers() {
//        Arrange
        TrainingManager trainingManager = new TrainingManager();
//        Act
        int result = trainingManager.createNewTroopers();
//        Assert
        Assertions.assertEquals(1, result);
    }


}