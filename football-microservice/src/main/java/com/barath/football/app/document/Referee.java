package com.barath.football.app.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by barath on 18/03/18.
 */

@Document(collection = "referee")
public class Referee {

    @Id
    @JsonIgnore
    private String id;

    @Indexed
    @Field
    private Long refereeId;

    @Field
    private String refereeName;

    @PersistenceConstructor
    public Referee(Long refereeId, String refereeName) {
        this.refereeId = refereeId;
        this.refereeName = refereeName;
    }

    public Referee() {
    }

    public Long getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Long refereeId) {
        this.refereeId = refereeId;
    }

    public String getRefereeName() {
        return refereeName;
    }

    public void setRefereeName(String refereeName) {
        this.refereeName = refereeName;
    }

    @Override
    public String toString() {
        return "Referee{" +
                "refereeId=" + refereeId +
                ", refereeName='" + refereeName + '\'' +
                '}';
    }
}
