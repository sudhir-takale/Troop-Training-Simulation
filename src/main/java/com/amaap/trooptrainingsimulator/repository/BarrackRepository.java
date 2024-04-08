package com.amaap.trooptrainingsimulator.repository;

import com.amaap.trooptrainingsimulator.domain.model.Troop;

import java.util.Queue;

public interface BarrackRepository {
     void add(Troop troop);
     Queue<Troop> getBarracksQueue();
}
