package com.niit.shopperBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shopperBackend.dao.CategoryDAO;
import com.niit.shopperBackend.daoImpl.CategoryDAOImpl;

@Configuration
@ComponentScan("com.niit.shopperBackend.dto")
@EnableTransactionManagement
public class ApplicationContextConfig {

	
	@Bean("dataSource")
    public DataSource getDataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/cart");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
		
		return dataSource;
	}
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
    	builder.addProperties(getHibernateProperties());
    	builder.scanPackages("com.niit.shopperBackend.dto");
    	return builder.buildSessionFactory();
    }
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	properties.put("hibernate.format_sql", "true");
    	properties.put("hibernate.hbm2ddl.auto", "update");
    	return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
			 
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			

		return transactionManager;
	}
	
	   
   
}
