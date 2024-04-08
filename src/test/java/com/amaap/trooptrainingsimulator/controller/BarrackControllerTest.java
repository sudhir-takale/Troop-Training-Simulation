package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDatabaseImpl;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryBarrackRepository;
import com.amaap.trooptrainingsimulator.service.BarrackService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class BarrackControllerTest {

    BarrackController barrackController =
            new BarrackController(new BarrackService(new InMemoryBarrackRepository(new InMemoryDatabaseImpl())));

    @Test
    void shouldBeAbleAddTroopsToBarrack() throws InvalidTroopParamsException {
        //arrange
        int count = 2;
        List<Troop> troops = TroopFactory.getTroopList();
        //act
        boolean result = barrackController.addTroops(troops, count);
        //assert
        assertTrue(result);
    }



}
