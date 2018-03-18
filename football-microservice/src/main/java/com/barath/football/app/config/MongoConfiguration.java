package com.barath.football.app.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by barath on 18/03/18.
 */
//@Configuration
//@EnableReactiveMongoRepositories
public class MongoConfiguration extends AbstractReactiveMongoConfiguration{

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Arrays.asList("com.barath.football.app.repository");
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }
}
