package com.amaap.trooptrainingsimulator.domain.service;

import com.amaap.trooptrainingsimulator.domain.model.Troop;

public class TrainService {
    public static synchronized Troop train(Troop troop, int trainingTime) throws InterruptedException {

        System.out.println("training");
        Thread.sleep(trainingTime * 1000L);
        System.out.println("training completed");
        return troop;

    }
}
