package com.barath.school.app.configuration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration {
	
	
	private   Map<String, Object> map = new HashMap();
	
	@Autowired
	private Environment env;
	
	
	@Value("${mongo.host}")
	private String mongoHost;
	
	@Value("${mongo.port}")
	private int mongoPort;
	
//	
//	@Bean
//	@Profile("cloud")
//	public MongoClientFactoryBean mongo(){
//		MongoClientFactoryBean mongoFactory=new MongoClientFactoryBean();
//		System.out.println("MONGO DB CONNECTION ===> "+mongoHost+" MONGO PORT "+mongoPort);
//		mongoFactory.setHost(mongoHost);		
//		mongoFactory.setHost(mongoPort);
////		mongoFactory.setHost("192.168.1.35");		
////		mongoFactory.setHost("27017");
//		return mongoFactory;
//	}
	
	@Bean
	@Profile("cloud")
	public MongoDbFactory mongoDbCloudFactory(){
		System.out.println("CLOUD MONGO DB FACTORY IS ON ");
		MongoClient mongoClient=new MongoClient(mongoHost,mongoPort);
		SimpleMongoDbFactory mongoFactory =new SimpleMongoDbFactory(mongoClient, "test");
		return mongoFactory;
	}
	
//	@Bean	
//	public MongoClientFactoryBean mongoLocal(){
//		MongoClientFactoryBean mongoFactory=new MongoClientFactoryBean();
//		System.out.println("MONGO DB LOCAL CONNECTION ===> "+mongoHost+" MONGO PORT "+mongoPort);
//			mongoFactory.setHost("192.168.1.35");		
//		mongoFactory.setPort("27017");
//		return mongoFactory;
//	}
	
	@Bean
	@Profile("local")
	public MongoDbFactory mongoDbFactory(){
		System.out.println("LOCAL MONGO DB FACTORY IS ON ");
		MongoClient mongoClient=new MongoClient(mongoHost,mongoPort);
		SimpleMongoDbFactory mongoFactory =new SimpleMongoDbFactory(mongoClient, "test");
		return mongoFactory;
	}
	
	@PostConstruct
	public void init(){
		
		
	      System.out.println("INIT CONFIGURATION OF MONGO CONFIGURATION");
	        for(Iterator it = ((AbstractEnvironment) env).getPropertySources().iterator(); it.hasNext(); ) {
	            PropertySource propertySource = (PropertySource) it.next();
	            if (propertySource instanceof MapPropertySource) {
	                map.putAll(((MapPropertySource) propertySource).getSource());
	            }
	        }
		map.entrySet().stream().forEach(entry ->{
			
			System.out.println("KEY "+entry.getKey()+"  VALUE "+entry.getValue());
			
			
			
		});
		
		
	}

}
