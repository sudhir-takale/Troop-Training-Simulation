package com.amaap.trooptrainingsimulator;

import com.amaap.trooptrainingsimulator.repository.ArmyCampRepository;
import com.amaap.trooptrainingsimulator.repository.BarrackRepository;
import com.amaap.trooptrainingsimulator.repository.TroopRepository;
import com.amaap.trooptrainingsimulator.repository.db.FakeInMemoryDatabase;
import com.amaap.trooptrainingsimulator.repository.db.InMemoryDB;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryArmyCampRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryBarrackRepository;
import com.amaap.trooptrainingsimulator.repository.impl.InMemoryTroopRepository;
import com.google.inject.AbstractModule;

public class TroopModule extends AbstractModule {

    @Override
    public void configure() {
        bind(ArmyCampRepository.class).to(InMemoryArmyCampRepository.class);
        bind(BarrackRepository.class).to(InMemoryBarrackRepository.class);
        bind(TroopRepository.class).to(InMemoryTroopRepository.class);
        bind(InMemoryDB.class).to(FakeInMemoryDatabase.class).asEagerSingleton();
    }
}
