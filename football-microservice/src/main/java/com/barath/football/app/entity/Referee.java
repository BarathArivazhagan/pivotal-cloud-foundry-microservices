package com.barath.football.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by barath on 18/03/18.
 */

@Document(collection = "referee")
public class Referee {

    @Id
    @Field
    private int refereeId;

    @Field
    private String refereeName;


}
