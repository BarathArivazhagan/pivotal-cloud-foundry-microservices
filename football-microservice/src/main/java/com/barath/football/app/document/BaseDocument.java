package com.barath.football.app.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by barath on 01/04/18.
 */

public class BaseDocument implements Serializable {

    @Id
    @JsonIgnore
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
