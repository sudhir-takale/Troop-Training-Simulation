package com.amaap.trooptrainingsimulator.domain.model;

import java.util.Objects;

public class Barbarian extends Troop {
    public Barbarian(int id, int trainingTime, int trainingCost) {
        super(id, trainingTime, trainingCost);
    }

    public static class Troop {

        private int id;
        private int trainingTime;
        private int trainingCost;

        public Troop(int id, int trainingTime, int trainingCost) {
            this.id = id;
            this.trainingTime = trainingTime;
            this.trainingCost = trainingCost;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Troop troop = (Troop) o;
            return id == troop.id && trainingTime == troop.trainingTime && trainingCost == troop.trainingCost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, trainingTime, trainingCost);
        }

        public int getId() {
            return this.id;
        }
    }
}
