package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.domain.models.Trooper;
import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import com.amaap.trooptrainingsimulator.domain.services.BarrackService;
import com.amaap.trooptrainingsimulator.domain.services.TrainService;
import com.amaap.trooptrainingsimulator.viewer.ArmyCamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void shouldBeAbeleToMakeAsRequestToTrainTheTrooper() throws InvalidCountException {
//        Arrange
        TrainingManager trainingManager = new TrainingManager(new TrainService(new ArmyCamp()), new BarrackService(new Barrack()), new Barrack(), new ArmyCamp());
        Gamer gamer = new Gamer(trainingManager);
//        Act
        boolean request = gamer.trainTheNewTroop(Trooper.ARCHER, 3);
//         Assert
        Assertions.assertTrue(request);


    }


}
