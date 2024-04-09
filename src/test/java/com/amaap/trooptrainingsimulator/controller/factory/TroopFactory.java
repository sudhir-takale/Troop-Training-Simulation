package com.amaap.trooptrainingsimulator.controller.factory;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Barbarian;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;

import java.util.List;

public class TroopFactory {


    public static List<Troop> getTroopList() throws InvalidTroopParamsException {
        Troop trooper1 = new Archer(1, 6, 20);
        Troop trooper2 = new Barbarian(2, 3, 10);
        Troop trooper3 = new Barbarian(2, 3, 10);
        Troop trooper4 = new Barbarian(2, 3, 10);
        Troop trooper5 = new Barbarian(2, 3, 10);
        Troop trooper6 = new Archer(1, 6, 20);
        Troop trooper7 = new Archer(1, 6, 20);
        Troop trooper8 = new Archer(1, 6, 20);
        Troop trooper9 = new Archer(1, 6, 20);
        Troop trooper10 = new Archer(1, 6, 20);
        Troop trooper11 = new Archer(1, 6, 20);
        Troop trooper12 = new Archer(1, 6, 20);
        return List.of(trooper1, trooper2, trooper3, trooper4, trooper5, trooper6, trooper7, trooper8, trooper9, trooper10,
                trooper11, trooper12);
    }
}
