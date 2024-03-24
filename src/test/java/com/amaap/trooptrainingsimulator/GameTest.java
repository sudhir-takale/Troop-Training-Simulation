package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void shouldBeAbeleToMakeAsRequestToTrainTheTrooper() throws InvalidCountException {
//        Arrange
        TrainingManager trainingManager = new TrainingManager();
        Gamer gamer = new Gamer(trainingManager);
//        Act
        boolean request = gamer.trainTheNewTroop("Archers", 3);
//         Assert
        Assertions.assertTrue(request);


    }


}
