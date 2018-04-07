package com.barath.football.app.document;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by barath on 01/04/18.
 */

@Document(collection = "sequence")
public class SequenceDocument extends  BaseDocument implements Serializable{

    private Long teamSequence;

    private Long matchSequence;

    private Long refereeSequence;
    private Long playerSequence;

    private Long divisionSequence;

    @PersistenceConstructor
    public SequenceDocument(Long teamSequence, Long matchSequence, Long refereeSequence, Long playerSequence, Long divisionSequence) {
        this.teamSequence = teamSequence;
        this.matchSequence = matchSequence;
        this.refereeSequence = refereeSequence;
        this.playerSequence = playerSequence;
        this.divisionSequence = divisionSequence;
    }

    public SequenceDocument() {
    }

    public Long getTeamSequence() {
        return teamSequence;
    }

    public void setTeamSequence(Long teamSequence) {
        this.teamSequence = teamSequence;
    }

    public Long getMatchSequence() {
        return matchSequence;
    }

    public void setMatchSequence(Long matchSequence) {
        this.matchSequence = matchSequence;
    }

    public Long getRefereeSequence() {
        return refereeSequence;
    }

    public void setRefereeSequence(Long refereeSequence) {
        this.refereeSequence = refereeSequence;
    }

    public Long getPlayerSequence() {
        return playerSequence;
    }

    public void setPlayerSequence(Long playerSequence) {
        this.playerSequence = playerSequence;
    }

    public Long getDivisionSequence() {
        return divisionSequence;
    }

    public void setDivisionSequence(Long divisionSequence) {
        this.divisionSequence = divisionSequence;
    }
}
