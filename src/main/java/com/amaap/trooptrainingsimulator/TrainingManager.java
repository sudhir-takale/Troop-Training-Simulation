package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.domain.models.Barrack;
import com.amaap.trooptrainingsimulator.domain.models.TrainTroopRequest;
import com.amaap.trooptrainingsimulator.domain.models.Troop;
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
        if (count < 1 || count > 10) throw new InvalidCountException(count + " Count should not be greater than 10!");
        TrainTroopRequest trainRequest = new TrainTroopRequest(troop, count);
        pendingRequests.add(trainRequest);
        return true;
    }

    public Troop createNewTroopers(TrainTroopRequest request) {

        if (request.getTroop() == Trooper.ARCHER) {
            return new Archers();
        }
        return new Barbarian();
    }

    public List<TrainTroopRequest> getPendingRequests() {
        return pendingRequests;
    }

    public void processPendingRequests() throws InvalidCountException {
        for (TrainTroopRequest request : pendingRequests) {
            int numberOfTrooper = request.getCount();

            for (int i = 0; i < numberOfTrooper; i++) {
                Troop troop = createNewTroopers(request);

                if (barrack.getTroops().size() < barrack.getCapacity()) {
                    System.out.println(troop);
                    System.out.println(troop.getClass());
                    barrack.getTroops().add(troop);
                } else {
                    barrack.getWaitingList().add(troop);
                }
            }
        }

        trainingService.trainTroops(new TrainTroopRequest(Trooper.ARCHER, 4), barrack);
    }

}
