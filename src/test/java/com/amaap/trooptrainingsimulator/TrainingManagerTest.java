package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainingManagerTest {
    private TrainingManager trainingManager;

    @BeforeEach
    void setup() throws Exception {
        trainingManager = new TrainingManager();

    }

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

    @Test
    void shouldBeAbleToRequestToTrainTheTroopers() throws InvalidCountException {
//        Act
        boolean result = trainingManager.trainTheNewTroop("Archers", 3);
//        Assert
        Assertions.assertTrue(result);
    }


}