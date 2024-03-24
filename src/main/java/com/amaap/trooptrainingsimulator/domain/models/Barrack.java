package com.amaap.trooptrainingsimulator.domain.models;

import java.util.ArrayList;
import java.util.List;

public class Barrack {
    private final int capacity = 10;
    private List<Troop> troops = new ArrayList<>();
    private List<Troop> waitingList = new ArrayList<>();

    public int getCapacity() {
        return capacity;
    }

    public List<Troop> getTroops() {
        return troops;
    }

    public List<Troop> getWaitingList() {
        return waitingList;
    }
}
