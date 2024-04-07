package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.repository.dao.Troop;

import java.util.LinkedList;
import java.util.Queue;

public class BarrackService {

    private Queue<Troop> troopList;

    public  BarrackService () {
        troopList = new LinkedList<>();
    }
    public void add(Troop troop) {

        troopList.add(troop);
    }
    public Queue<Troop> getTroopList() {
        return troopList;
    }
}
