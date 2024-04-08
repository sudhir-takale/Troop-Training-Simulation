package com.amaap.trooptrainingsimulator.controller;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Barbarian;
import com.amaap.trooptrainingsimulator.domain.model.Troop;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TroopFactory {
    public static Queue<Troop> getTroops() {
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

    public static List<Troop> getTroopList() {
        Troop trooper1 = new Archer(1, 6, 20);
        Troop trooper2 = new Barbarian(2, 3, 10);
        return List.of(trooper1, trooper2);
    }
}
