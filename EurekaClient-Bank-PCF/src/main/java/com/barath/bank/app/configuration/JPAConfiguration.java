package com.barath.bank.app.configuration;



import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
public class JPAConfiguration {
	
	@Value("${spring.profiles.active}")
	private String[] profiles;
	
	
	@Value("${datasource.connection.${spring.profiles.active}.url}")
	private String dataSourceConnectionUrl;
	
	
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory=new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaDialect(hibernateJpaDialect());
		entityManagerFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter());
		entityManagerFactory.setPersistenceUnitName("bank-unit-pcf");
		entityManagerFactory.setPersistenceXmlLocation("classpath:/META-INF/persistence.xml");
		return entityManagerFactory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager 	transactionManager=new JpaTransactionManager();
		//jpaTransactionManager.setEntityManagerFactory((EntityManagerFactory) entityManagerFactory());
		transactionManager.setJpaDialect(hibernateJpaDialect());
		transactionManager.setDataSource(dataSource());
		return 	transactionManager;
	}
	
	
	@Bean
	public JpaDialect hibernateJpaDialect(){
		return new HibernateJpaDialect();
	}
	
	@Bean
	public JpaVendorAdapter hibernateJpaVendorAdapter(){
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter=new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		return hibernateJpaVendorAdapter;
		
	}
	
	
	@Bean
	public DataSource dataSource(){
		DataSource dataSource=new DataSource();
		dataSource.setUsername("postgres");
		dataSource.setPassword("barath");
		System.out.println("PROFILES ARE "+profiles);
		dataSource.setDriverClassName("org.postgresql.Driver");
		
		dataSource.setUrl(dataSourceConnectionUrl);
		return dataSource;
	}
	

}
