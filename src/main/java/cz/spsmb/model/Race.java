package cz.spsmb.model;

import jakarta.persistence.*;

import java.io.Serializable;

    @Entity
    @Table(name = "race")
    public class Race implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        String race;

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        @Override
        public String toString() {
            return "Race{" +
                    "race='" + race + '\'' +
                    '}';

    }
}