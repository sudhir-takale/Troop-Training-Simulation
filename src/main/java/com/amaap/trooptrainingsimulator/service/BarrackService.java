package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.domain.service.TroopTrainer;
import com.amaap.trooptrainingsimulator.repository.BarrackRepository;
import com.amaap.trooptrainingsimulator.service.exception.InvalidTroopException;
import com.google.inject.Inject;

import java.util.List;
import java.util.Queue;

public class BarrackService {

    private final BarrackRepository barrackRepository;
    private final ArmyCampService armyCampService;
    private final TroopService troopService;

    @Inject
    public BarrackService(BarrackRepository barrackRepository, ArmyCampService armyCampService, TroopService troopService) {
        this.barrackRepository = barrackRepository;
        this.armyCampService = armyCampService;
        this.troopService = troopService;
    }

    public boolean addTroops(TroopType troopType, int count) throws InvalidTroopParamsException, InvalidTroopException {
        if (count > 10) count = 10;
        List<Troop> troops = troopService.getTroops(troopType, count);

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
