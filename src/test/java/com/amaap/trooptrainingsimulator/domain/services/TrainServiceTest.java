package com.amaap.trooptrainingsimulator.domain.services;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.models.Archers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainServiceTest {

    private TrainService trainService;
    private Barrack barrack;

    @BeforeEach
    void setUp() throws Exception {
        trainService = new TrainService();
        barrack = new Barrack();
        barrack.getTroops().add(new Archers());
        barrack.getTroops().add(new Archers());
        barrack.getTroops().add(new Archers());
        barrack.getTroops().add(new Archers());
        barrack.getTroops().add(new Archers());

    }

    @Test
    void shouldBeAbleToTrainTheTroop() {
//        Act
        boolean result = trainService.trainTroops(barrack);
//        Assert
        Assertions.assertTrue(result);

    }

}