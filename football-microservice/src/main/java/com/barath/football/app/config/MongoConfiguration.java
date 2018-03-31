package com.barath.football.app.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by barath on 18/03/18.
 */

@Configuration
@AutoConfigureAfter(MongoReactiveDataAutoConfiguration.class)
public class MongoConfiguration {

    private MongoClient mongoClient;

    public MongoConfiguration(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        Assert.notNull(mongoClient,"mongo client cannot be null , recheck the configuration");
    }
}
