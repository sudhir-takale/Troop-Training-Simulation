package com.amaap.trooptrainingsimulator.domain.services;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.domain.models.TrainTroopRequest;
import com.amaap.trooptrainingsimulator.domain.models.Troop;
import com.amaap.trooptrainingsimulator.domain.models.Trooper;
import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import com.amaap.trooptrainingsimulator.models.Archers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class BarrackServiceTest {

    private BarrackService barrackService;
    private Barrack barrack;

    @BeforeEach
    void setup() {
        barrack = new Barrack();
        barrackService = new BarrackService(barrack);
    }

    @Test
    void shouldThrowInvalidCountExceptionIfCountIsZero() throws InvalidCountException {
        // Act
        // Assert
        Assertions.assertThrows(InvalidCountException.class, () -> {
            new TrainTroopRequest(Trooper.ARCHER, 0);

        });
    }

    @Test
    void shouldAddTroopsToBarrack() throws InvalidCountException {
        // Arrange
        TrainTroopRequest request = new TrainTroopRequest(Trooper.ARCHER, 3);
        // Act
        barrackService.addTroops(request);
        // Assert
        List<Troop> troops = barrack.getTroops();
        Assertions.assertEquals(3, troops.size());
    }

    @Test
    void shouldAddTroopsToWaitingListWhenBarrackIsFull() throws InvalidCountException {
        // Arrange
        for (int i = 0; i < barrack.getCapacity(); i++) {
            barrack.getTroops().add(new Archers());
        }
        TrainTroopRequest request = new TrainTroopRequest(Trooper.BARBARIAN, 5);
        // Act
        barrackService.addTroops(request);
        // Assert
        List<Troop> waitingList = barrack.getWaitingList();
        Assertions.assertEquals(5, waitingList.size());
    }


}