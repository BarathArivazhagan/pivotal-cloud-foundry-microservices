package com.barath.bank.app.configuration;



import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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
	
	
	@Value("${spring.datasource.url}")
	private String dataSourceConnectionUrl;
	
	@Value("${entity.packagesToScan: com.barath.app.entity}")
	private String packagesToScan;
	
	private DataSource dataSource;
	
	 public JPAConfiguration(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory=new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setJpaDialect(hibernateJpaDialect());
		entityManagerFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter());
		entityManagerFactory.setPersistenceUnitName("bank-unit-pcf");
		entityManagerFactory.setPackagesToScan(packagesToScan);
		return entityManagerFactory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager 	transactionManager=new JpaTransactionManager();		
		transactionManager.setJpaDialect(hibernateJpaDialect());
		transactionManager.setDataSource(dataSource);
		return 	transactionManager;
	}
	
	
	@Bean
	public JpaDialect hibernateJpaDialect(){
		return new HibernateJpaDialect();
	}
	
	@Profile(value= "postgres")
	@Bean
	public JpaVendorAdapter hibernateJpaVendorAdapter(){
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter=new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		return hibernateJpaVendorAdapter;
		
	}
	
	
	@Profile(value= "mysql")
	@Bean
	public JpaVendorAdapter mysqlHibernateJpaVendorAdapter(){
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter=new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		return hibernateJpaVendorAdapter;
		
	}
	
	
	
	

}
