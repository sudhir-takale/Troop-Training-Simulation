package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.service.TroopTrainer;
import com.amaap.trooptrainingsimulator.repository.BarrackRepository;

import java.util.List;
import java.util.Queue;

public class BarrackService {

    private BarrackRepository barrackRepository;
    private ArmyCampService armyCampService;

    public BarrackService(BarrackRepository barrackRepository, ArmyCampService armyCampService) {
        this.barrackRepository = barrackRepository;
        this.armyCampService = armyCampService;
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
        for (int i = 0; i < size; i++) {
            Troop troop = barracks.poll();
            Troop trainedTroop = TroopTrainer.troopTrainer(troop, troop.getTrainingTime());
            TroopType troopToUpdate;
            if (trainedTroop instanceof Archer) troopToUpdate = TroopType.ARCHER;
            else troopToUpdate = TroopType.BARBARIAN;
            armyCampService.updateTroopCount(troopToUpdate);
        }
    }
}
