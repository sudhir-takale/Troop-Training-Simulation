package com.amaap.trooptrainingsimulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void shouldBeAbeleToMakeAsRequestToTrainTheTrooper() {
        TrainingManager  trainingManager = new TrainingManager();
        Gamer gamer = new Gamer(trainingManager);

        boolean request = gamer.trainTheNewTroop();

        Assertions.assertTrue(request);


    }


}
