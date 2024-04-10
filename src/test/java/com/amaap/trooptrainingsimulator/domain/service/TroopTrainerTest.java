package com.amaap.trooptrainingsimulator.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TroopTrainerTest {

    @Test
    void shouldBeAbleToCreateTheInstanceOfTroopTrainerClass() {
        //arrange
        TroopTrainer troopTrainer = new TroopTrainer();
        //assert
        Assertions.assertNotNull(troopTrainer);
        Assertions.assertTrue(true);
    }

}