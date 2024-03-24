package com.amaap.trooptrainingsimulator.domain.services;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.models.Archers;
import com.amaap.trooptrainingsimulator.models.Barbarian;
import com.amaap.trooptrainingsimulator.viewer.ArmyCamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainServiceTest {

    private TrainService trainService;
    private Barrack barrack;
    private ArmyCamp armyCamp;

    @BeforeEach
    void setUp() {
        trainService = new TrainService(armyCamp);
        barrack = new Barrack();
        barrack.getTroops().add(new Archers());
        barrack.getTroops().add(new Archers());
        barrack.getTroops().add(new Archers());
        barrack.getTroops().add(new Archers());
        barrack.getTroops().add(new Archers());

    }

    @Test
    void shouldBeAbleToTrainTheTroop() {
//        Act & Assert
        boolean result = trainService.trainTroops(barrack);
        Assertions.assertTrue(result);
    }

    @Test
    void shouldRemoveTroopFromTheListAfterTraining() {
//        Act
        trainService.trainTroops(barrack);
        Assertions.assertEquals(0, barrack.getTroops().size());
    }

    @Test
    void shouldAbleToTrainAllTroopsRegardlessOfType() {
//        Arrange
        barrack.getTroops().add(new Archers());
        barrack.getTroops().add(new Barbarian());
        // Act
        boolean result = trainService.trainTroops(barrack);
        // Assert
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, barrack.getTroops().size());
    }

}