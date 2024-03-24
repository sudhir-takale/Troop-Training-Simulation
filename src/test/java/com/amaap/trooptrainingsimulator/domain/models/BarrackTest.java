package com.amaap.trooptrainingsimulator.domain.models;

import com.amaap.trooptrainingsimulator.models.Archers;
import com.amaap.trooptrainingsimulator.models.Barbarian;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class BarrackTest {
    private Barrack barrack;

    @BeforeEach
    void setUp() {
        barrack = new Barrack();
    }

    @Test
    void shouldReturnCapacityOfBarrack() {
        // Arrange & Act
        int capacity = barrack.getCapacity();
        // Assert
        Assertions.assertEquals(10, capacity);
    }

    @Test
    void shouldReturnEmptyListOfTroopsInitially() {
        // Arrange & Act
        List<Troop> troops = barrack.getTroops();
        // Assert
        Assertions.assertTrue(troops.isEmpty());
    }

    @Test
    void getWaitingList_ReturnsEmptyListInitially() {
        // Arrange & Act
        List<Troop> waitingList = barrack.getWaitingList();
        // Assert
        Assertions.assertTrue(waitingList.isEmpty());
    }

    @Test
    void shouldAbleToAddTroopsToList() {
        // Arrange
        Troop troop = new Archers();
        Troop troop2 = new Barbarian();
        barrack.getTroops().add(troop);
        barrack.getTroops().add(troop2);
        // Act
        List<Troop> troops = barrack.getTroops();
        // Assert
        Assertions.assertEquals(2, troops.size());
        Assertions.assertTrue(troops.contains(troop));
        Assertions.assertTrue(troops.contains(troop2));
    }

    @Test
    void shouldAbleToAddTroopsToWaitingList() {
        // Arrange
        Troop troop1 = new Troop();
        Troop troop2 = new Troop();
        barrack.getWaitingList().add(troop1);
        barrack.getWaitingList().add(troop2);
        // Act
        List<Troop> waitingList = barrack.getWaitingList();
        // Assert
        Assertions.assertEquals(2, waitingList.size());
        Assertions.assertTrue(waitingList.contains(troop1));
        Assertions.assertTrue(waitingList.contains(troop2));
    }
}
