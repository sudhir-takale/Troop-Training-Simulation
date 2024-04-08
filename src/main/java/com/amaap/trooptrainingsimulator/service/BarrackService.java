package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.service.TrainService;
import com.amaap.trooptrainingsimulator.repository.BarrackRepository;

import java.util.List;
import java.util.Queue;

public class BarrackService {

    BarrackRepository barrackRepository;

    public BarrackService(BarrackRepository barrackRepository) {
        this.barrackRepository = barrackRepository;
    }

    public boolean addTroops(List<Troop> troops, int count) {
        if (count > 10) count = 10;

        for (int i = 0; i < count; i++) {
            barrackRepository.add(troops.get(i));
        }
        return true;
    }

    public Queue<Troop> getAllTroops() {
        return barrackRepository.getBarracksQueue();
    }


    public void trainTheTroop() throws InterruptedException {

        Queue<Troop> barracks = getAllTroops();
        int size = barracks.size();
       for(int i = 0; i < size; i++) {
           Troop troop = barracks.poll();
            TrainService.train(troop, troop.getTrainingTime());
        }
    }
}
