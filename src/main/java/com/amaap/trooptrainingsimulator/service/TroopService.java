package com.amaap.trooptrainingsimulator.service;

import com.amaap.trooptrainingsimulator.domain.model.Archer;
import com.amaap.trooptrainingsimulator.domain.model.Barbarian;
import com.amaap.trooptrainingsimulator.domain.model.Troop;
import com.amaap.trooptrainingsimulator.domain.model.TroopType;
import com.amaap.trooptrainingsimulator.domain.model.exception.InvalidTroopParamsException;
import com.amaap.trooptrainingsimulator.domain.model.validator.TroopValidator;
import com.amaap.trooptrainingsimulator.repository.TroopRepository;
import com.amaap.trooptrainingsimulator.service.exception.InvalidTroopException;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class TroopService {
    private final TroopRepository troopRepository;

    @Inject
    public TroopService(TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    public Troop create(TroopType troopType) throws InvalidTroopParamsException, InvalidTroopException {
        if (!TroopValidator.validatesType(troopType)) {
            throw new InvalidTroopException("Invalid Troop Type Exception");
        }
        Troop troop;
        if (TroopType.ARCHER == troopType) {
            troop = new Archer(1, 6, 20);
        } else {
            troop = new Barbarian(1, 3, 10);
        }
        return troopRepository.insert(troop);

    }

    public List<Troop> getTroops(TroopType troopType, int count) throws InvalidTroopParamsException, InvalidTroopException {
        List<Troop> troopList = new ArrayList<>();
        while (troopList.size() != count) {

            if (troopList.size() < count) {
                create(troopType);
            } else {
                troopList.add(troopRepository.getTroopOf(troopType));
            }
        }
        return troopList;
    }
}
