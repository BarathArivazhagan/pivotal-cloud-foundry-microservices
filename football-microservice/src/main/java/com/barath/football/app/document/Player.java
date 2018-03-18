package com.barath.football.app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by barath on 18/03/18.
 */
@Document(collection = "player")
public class Player {

    @Id
    @Field
    private Long playerId;

    @Field
    private String playerName;

    @DBRef
    private Team team;

    @PersistenceConstructor
    public Player(Long playerId, String playerName, Team team) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.team = team;
    }

    public Player() {
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", team=" + team +
                '}';
    }
}
