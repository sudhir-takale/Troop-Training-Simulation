package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Barbarian;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TroopFactory {
    public static Queue<Troop> getTroops() throws InvalidTroopParamsException {
        Queue<Troop> trooperQueue = new LinkedList<>();
        trooperQueue.add(new Archer(1, 6, 20));
        trooperQueue.add(new Archer(2, 6, 20));
        trooperQueue.add(new Archer(3, 6, 20));
        trooperQueue.add(new Archer(4, 6, 20));
        trooperQueue.add(new Archer(5, 6, 20));
        trooperQueue.add(new Barbarian(6, 3, 10));
        trooperQueue.add(new Barbarian(7, 3, 10));
        trooperQueue.add(new Barbarian(8, 3, 10));
        trooperQueue.add(new Barbarian(9, 3, 10));
        return trooperQueue;
    }

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
