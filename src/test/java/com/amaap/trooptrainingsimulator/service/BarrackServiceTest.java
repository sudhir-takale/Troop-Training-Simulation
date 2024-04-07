package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.repository.dao.Archer;
import com.amaap.trooptrainingsimulator.repository.dao.Barbarian;
import com.amaap.trooptrainingsimulator.repository.dao.Troop;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class BarrackServiceTest {

    BarrackService barrackService = new BarrackService();

    @Test
    void shouldBeAbleToAddArcherInTheBarrack() {
//        act
        Troop troop = new Archer();
        barrackService.add(troop);
//        assert
        assertEquals(1, barrackService.getTroopList().size());

    }

    @Test
    void shouldBeAbleToAddBarbarianInTheBarrack() {
//       act
        Troop troop = new Barbarian();
        barrackService.add(troop);
//        assert
        assertEquals(1, barrackService.getTroopList().size());

    }

    @Test
    void shouldBeAbleToMultipleTroopsInTheBarrack() {
//        arrange
        Troop troop = new Barbarian();
        Troop troop1 = new Archer();
        Troop troop2 = new Barbarian();
//        act
        barrackService.add(troop);
        barrackService.add(troop1);
        barrackService.add(troop2);
//        assert
        assertEquals(3, barrackService.getTroopList().size());

    }

    @Test
    void shouldBeAbleToTrainTheTroops() throws InterruptedException {
//        arrange
        Troop troop = new Barbarian();
        Troop troop1 = new Barbarian();
        barrackService.add(troop);
        barrackService.add(troop1);
//        act
        barrackService.trainTheTroop();
//        assert
        assertEquals(0, barrackService.getTroopList().size());
    }

}