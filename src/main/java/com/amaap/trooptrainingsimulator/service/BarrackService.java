package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.repository.dao.Troop;

import java.util.LinkedList;
import java.util.Queue;

public class BarrackService {

    private Queue<Troop> troopList;


    public BarrackService() {
        troopList = new LinkedList<>();
    }

    public void add(Troop troop) {

        troopList.add(troop);
    }

    public Queue<Troop> getTroopList() {
        return troopList;
    }


    public void trainTheTroop() throws InterruptedException {
        while (!troopList.isEmpty()) {
            for (Troop troop : troopList) {

                int cost = troop.getTrainingCost();
                int time = troop.getTrainingTime();

                delay(time);
                troopList.remove(troop);

            }
        }
    }

    private void delay(int time) throws InterruptedException {
        System.out.println("training ....");
        Thread.sleep(time * 1000L);
        System.out.println("training completed and troops are available in army camp");

    }
}
