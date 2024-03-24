package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.domain.models.TrainTroopRequest;
import com.amaap.trooptrainingsimulator.domain.models.Trooper;
import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import com.amaap.trooptrainingsimulator.domain.services.BarrackService;
import com.amaap.trooptrainingsimulator.domain.services.TrainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TrainingManagerTest {
    private TrainingManager trainingManager;
    private TrainService trainingService;
    private BarrackService barrackService;
    private Barrack barrack;

    @BeforeEach
    void setup() {
        trainingService = new TrainService();
        barrack = new Barrack();
        barrackService = new BarrackService(barrack);
        trainingManager = new TrainingManager(trainingService, barrackService, barrack);
    }

    @Test
    void shouldBeAbleToCreateTrainingManager() {
        // Arrange & Act
        TrainingManager trainingManager = new TrainingManager(trainingService, barrackService, barrack);
        // Assert
        Assertions.assertNotNull(trainingManager);
    }


    @Test
    void shouldBeAbleToRequestToTrainTheTroopers() throws InvalidCountException {
        // Act
        boolean result = trainingManager.trainTheNewTroop(Trooper.ARCHER, 3);
        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeAbleToAddNewTroopsToPendingRequests() throws InvalidCountException {
        // Act
        trainingManager.trainTheNewTroop(Trooper.ARCHER, 3);
        // Assert
        List<TrainTroopRequest> pendingRequests = trainingManager.getPendingRequests();
        Assertions.assertEquals(1, pendingRequests.size());
        TrainTroopRequest request = pendingRequests.get(0);
        Assertions.assertEquals(Trooper.ARCHER, request.getTroop());
        Assertions.assertEquals(3, request.getCount());
    }

    @Test
    void shouldBeAbleToProcessPendingRequests() throws InvalidCountException {
        // Arrange
        trainingManager.trainTheNewTroop(Trooper.ARCHER, 2);
        trainingManager.trainTheNewTroop(Trooper.BARBARIAN, 2);
        // Act
        trainingManager.processPendingRequests();
        // Assert
        Assertions.assertEquals(4, barrack.getTroops().size());
    }

    @Test
    void shouldAbleToAddNewTroopsToWaitingListWhenBarrackCapacityGetFilled() throws InvalidCountException {
        // Arrange
        trainingManager.trainTheNewTroop(Trooper.ARCHER, 5);
        trainingManager.trainTheNewTroop(Trooper.BARBARIAN, 8);
        // Act
        trainingManager.processPendingRequests();
        // Assert
        Assertions.assertEquals(10, barrack.getTroops().size());
        Assertions.assertEquals(3, barrack.getWaitingList().size());
    }

    @Test
    void shouldBeAbleToTrainTheNewTroops() throws InvalidCountException {
        // Arrange
        trainingManager.trainTheNewTroop(Trooper.ARCHER, 5);
        trainingManager.trainTheNewTroop(Trooper.BARBARIAN, 8);
        // Act
        boolean trainedTroop = trainingManager.processPendingRequests();
        Assertions.assertTrue(trainedTroop);

    }

    @Test
    void shouldBeAbleToShowAllTrainedTroopAvailableInArmyCamp() throws InvalidCountException {
        // Arrange
        trainingManager.trainTheNewTroop(Trooper.ARCHER, 5);
        trainingManager.trainTheNewTroop(Trooper.BARBARIAN, 8);
        // Act
        trainingManager.processPendingRequests();
        boolean result = trainingManager.startTraining();
        //Assert
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, barrack.getTroops().size());

    }



}
