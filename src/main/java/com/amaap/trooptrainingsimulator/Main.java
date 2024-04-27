package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.controller.ArmyCampController;
import com.amaap.trooptrainingsimulator.controller.BarrackController;
import com.amaap.trooptrainingsimulator.controller.TroopController;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.service.exception.InvalidTroopException;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws InvalidTroopParamsException, InvalidTroopException {

        Injector injector = Guice.createInjector(new TroopModule());

        TroopController troopController = injector.getInstance(TroopController.class);
        BarrackController barrackController = injector.getInstance(BarrackController.class);
        ArmyCampController armyCampController = injector.getInstance(ArmyCampController.class);

        troopController.createTroop(TroopType.ARCHER, 3, 10);
        troopController.createTroop(TroopType.ARCHER, 3, 10);
        troopController.createTroop(TroopType.ARCHER, 3, 10);
        troopController.createTroop(TroopType.ARCHER, 3, 10);
        troopController.createTroop(TroopType.BARBARIAN, 3, 10);
        troopController.createTroop(TroopType.BARBARIAN, 3, 10);
        troopController.createTroop(TroopType.BARBARIAN, 3, 10);
        troopController.createTroop(TroopType.BARBARIAN, 3, 10);
        troopController.createTroop(TroopType.BARBARIAN, 3, 10);
        troopController.createTroop(TroopType.BARBARIAN, 3, 10);
        troopController.createTroop(TroopType.ARCHER, 3, 5);

        boolean b = barrackController.addTroops(TroopType.BARBARIAN, 4);
        barrackController.addTroops(TroopType.ARCHER, 2);
        System.out.println("Barrack " + b);

        barrackController.trainTheTrooper();

        Map<TroopType, Integer> trainedTroops = armyCampController.getTrainedTroops();
        trainedTroops.forEach((troopType, count) -> System.out.println(troopType + " : " + count));


    }

}
