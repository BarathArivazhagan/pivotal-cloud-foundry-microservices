package com.barath.school.app.configuration;


import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import com.mongodb.MongoClient;


@Configuration
@AutoConfigureAfter(MongoAutoConfiguration.class)
public class MongoConfiguration {
	
	private MongoClient mongoClient;

	public MongoConfiguration(MongoClient mongoClient) {
		super();
		this.mongoClient = mongoClient;
		Assert.notNull(this.mongoClient, "mongo client cannot be null");
	}
	
	
	
	
	
	

}
