package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.domain.models.TrainTroopRequest;
import com.amaap.trooptrainingsimulator.domain.models.Trooper;
import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import com.amaap.trooptrainingsimulator.domain.services.BarrackService;
import com.amaap.trooptrainingsimulator.domain.services.TrainService;

import java.util.ArrayList;
import java.util.List;

public class TrainingManager {

    private List<TrainTroopRequest> pendingRequests;
    private TrainService trainingService;
    private BarrackService barrackService;
    private Barrack barrack;


    public TrainingManager(TrainService trainingService, BarrackService barrackService, Barrack barrack) {
        this.trainingService = trainingService;
        this.barrackService = barrackService;
        this.barrack = barrack;
        pendingRequests = new ArrayList<>();
    }

    public boolean trainTheNewTroop(Trooper troop, int count) throws InvalidCountException {
        if (count < 1 || count > 10) throw new InvalidCountException(count + " Count should not be greater than 10!");
        TrainTroopRequest trainRequest = new TrainTroopRequest(troop, count);
        pendingRequests.add(trainRequest);
        return true;
    }

    public List<TrainTroopRequest> getPendingRequests() {
        return pendingRequests;
    }

    public void processPendingRequests() throws InvalidCountException {
        for (TrainTroopRequest request : pendingRequests) {
            barrackService.addTroops(request);
        }
        trainingService.trainTroops(barrack);
        pendingRequests.clear();
    }
}
