package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.domain.models.TrainTroopRequest;
import com.amaap.trooptrainingsimulator.domain.models.exceptions.InvalidCountException;
import com.amaap.trooptrainingsimulator.models.Archers;
import com.amaap.trooptrainingsimulator.models.Barbarian;

public class TrainingManager {
    public boolean trainTheNewTroop(String archers, int count) throws InvalidCountException {
        TrainTroopRequest trainRequest = new TrainTroopRequest(archers, count);
        return true;
    }

    public int createNewTroopers() {

        Archers archers = new Archers();
        Barbarian barbarian = new Barbarian();
        return 1;
    }
}
