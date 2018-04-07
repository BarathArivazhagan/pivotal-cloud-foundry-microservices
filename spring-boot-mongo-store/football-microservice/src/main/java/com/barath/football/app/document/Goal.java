package com.barath.football.app.document;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by barath on 18/03/18.
 */
public class Goal {

    @Field(value= "FTHG")
    private int fullTimeHomeGoals;

    @Field(value= "FTAG")
    private int fullTimeAwayGoals;

    @Field(value= "HTHG")
    private int halfTimeHomeGoals;

    @Field(value= "HTAG")
    private int halfTimeAwayGoals;


    @PersistenceConstructor
    public Goal(int fullTimeHomeGoals, int fullTimeAwayGoals, int halfTimeHomeGoals, int halfTimeAwayGoals) {
        this.fullTimeHomeGoals = fullTimeHomeGoals;
        this.fullTimeAwayGoals = fullTimeAwayGoals;
        this.halfTimeHomeGoals = halfTimeHomeGoals;
        this.halfTimeAwayGoals = halfTimeAwayGoals;
    }

    public Goal() {
    }

    public int getFullTimeHomeGoals() {
        return fullTimeHomeGoals;
    }

    public void setFullTimeHomeGoals(int fullTimeHomeGoals) {
        this.fullTimeHomeGoals = fullTimeHomeGoals;
    }

    public int getFullTimeAwayGoals() {
        return fullTimeAwayGoals;
    }

    public void setFullTimeAwayGoals(int fullTimeAwayGoals) {
        this.fullTimeAwayGoals = fullTimeAwayGoals;
    }

    public int getHalfTimeHomeGoals() {
        return halfTimeHomeGoals;
    }

    public void setHalfTimeHomeGoals(int halfTimeHomeGoals) {
        this.halfTimeHomeGoals = halfTimeHomeGoals;
    }

    public int getHalfTimeAwayGoals() {
        return halfTimeAwayGoals;
    }

    public void setHalfTimeAwayGoals(int halfTimeAwayGoals) {
        this.halfTimeAwayGoals = halfTimeAwayGoals;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "fullTimeHomeGoals=" + fullTimeHomeGoals +
                ", fullTimeAwayGoals=" + fullTimeAwayGoals +
                ", halfTimeHomeGoals=" + halfTimeHomeGoals +
                ", halfTimeAwayGoals=" + halfTimeAwayGoals +
                '}';
    }
}
