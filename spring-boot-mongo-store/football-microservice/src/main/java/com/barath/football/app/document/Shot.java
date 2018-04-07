package com.barath.football.app.document;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by barath on 18/03/18.
 */
public class Shot {

    @Field(value = "HS")
    private int homeShots;

    @Field(value = "AS")
    private int awayShots;

    @Field(value = "HST")
    private int homeShotsOnTarget;

    @Field(value = "AST")
    private int awayShotsOnTarget;

    @PersistenceConstructor
    public Shot(int homeShots, int awayShots, int homeShotsOnTarget, int awayShotsOnTarget) {
        this.homeShots = homeShots;
        this.awayShots = awayShots;
        this.homeShotsOnTarget = homeShotsOnTarget;
        this.awayShotsOnTarget = awayShotsOnTarget;
    }

    public Shot() {
    }

    public int getHomeShots() {
        return homeShots;
    }

    public void setHomeShots(int homeShots) {
        this.homeShots = homeShots;
    }

    public int getAwayShots() {
        return awayShots;
    }

    public void setAwayShots(int awayShots) {
        this.awayShots = awayShots;
    }

    public int getHomeShotsOnTarget() {
        return homeShotsOnTarget;
    }

    public void setHomeShotsOnTarget(int homeShotsOnTarget) {
        this.homeShotsOnTarget = homeShotsOnTarget;
    }

    public int getAwayShotsOnTarget() {
        return awayShotsOnTarget;
    }

    public void setAwayShotsOnTarget(int awayShotsOnTarget) {
        this.awayShotsOnTarget = awayShotsOnTarget;
    }

    @Override
    public String toString() {
        return "Shot{" +
                "homeShots=" + homeShots +
                ", awayShots=" + awayShots +
                ", homeShotsOnTarget=" + homeShotsOnTarget +
                ", awayShotsOnTarget=" + awayShotsOnTarget +
                '}';
    }
}
