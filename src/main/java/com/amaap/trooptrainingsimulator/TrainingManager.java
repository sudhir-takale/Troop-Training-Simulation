package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.domain.models.TrainTroopRequest;
import com.amaap.trooptrainingsimulator.domain.models.Trooper;
import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import com.amaap.trooptrainingsimulator.domain.services.TrainService;
import com.amaap.trooptrainingsimulator.models.Archers;
import com.amaap.trooptrainingsimulator.models.Barbarian;

import java.util.ArrayList;
import java.util.List;

public class TrainingManager {

    private List<TrainTroopRequest> pendingRequests;
    private TrainService trainingService;
    private Barrack barrack;

    public TrainingManager(TrainService trainingService, Barrack barrack) {
        this.trainingService = trainingService;
        this.barrack = barrack;
        pendingRequests = new ArrayList<TrainTroopRequest>();
    }

    public boolean trainTheNewTroop(Trooper troop, int count) throws InvalidCountException {
        TrainTroopRequest trainRequest = new TrainTroopRequest(troop, count);
        pendingRequests.add(trainRequest);
        return true;
    }

    public int createNewTroopers() {

        Archers archers = new Archers();
        Barbarian barbarian = new Barbarian();
        return 1;
    }

    public List<TrainTroopRequest> getPendingRequests() {
        return pendingRequests;
    }

    public void processPendingRequests() {
        for (TrainTroopRequest request : pendingRequests) {

            trainingService.trainTroops(request, barrack);

        }
        pendingRequests.clear();


    }

}
