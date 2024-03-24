package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.domain.models.TrainTroopRequest;
import com.amaap.trooptrainingsimulator.domain.models.Trooper;
import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import com.amaap.trooptrainingsimulator.domain.services.BarrackService;
import com.amaap.trooptrainingsimulator.domain.services.TrainService;
import com.amaap.trooptrainingsimulator.viewer.ArmyCamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrainingManager {

    private final TrainService trainingService;
    private final BarrackService barrackService;
    private final Barrack barrack;
    private final ArmyCamp armyCamp;
    private List<TrainTroopRequest> pendingRequests;


    public TrainingManager(TrainService trainingService, BarrackService barrackService, Barrack barrack, ArmyCamp armyCamp) {
        this.trainingService = trainingService;
        this.barrackService = barrackService;
        this.barrack = barrack;
        this.armyCamp = armyCamp;
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

    public boolean processPendingRequests() throws InvalidCountException {
        for (TrainTroopRequest request : pendingRequests) {
            barrackService.addTroops(request);
        }
        return true;

    }

    public boolean startTraining() {
        return trainingService.trainTroops(barrack);
    }

    public Map<Trooper, Integer> viewTrainedTroop() {
        return armyCamp.viewTrainedTroops();
    }
}
