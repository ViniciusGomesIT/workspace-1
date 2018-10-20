package br.com.vinicius.configuration;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
[1] This is the central interface in Spring's transaction infrastructure. Applications can use this directly, 
but it is not primarily meant as API: Typically, applications will work with either TransactionTemplate or 
declarative transaction demarcation through AOP.
For implementors, it is recommended to derive from the provided AbstractPlatformTransactionManager class, 
which pre-implements the defined propagation behavior and takes care of transaction synchronization handling. 
Subclasses have to implement template methods for specific states of the underlying transaction, for example: 
begin, suspend, resume, commit.

The default implementations of this strategy interface are JtaTransactionManager and DataSourceTransactionManager, 
which can serve as an implementation guide for other transaction strategies. 
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		//Configures the name of the EntityManagerFactory bean definition to be used to create repositories 
		//discovered through this annotation. Defaults to entityManagerFactory.
        entityManagerFactoryRef = "entityManagerFactory",
        //Configures the name of the PlatformTransactionManager[1] bean definition to be used to create repositories 
        //discovered through this annotation. Defaults to transactionManager.
        transactionManagerRef = "transactionManager",
        //Base packages to scan for annotated >> components. << value() is an alias for (and mutually exclusive with) this attribute. 
        //Use basePackageClasses() for a type-safe alternative to String-based package names.
        basePackages = {"br.com.vinicius.repository"})
public class HibernateConfiguration {
	
	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.jpa.properties.dialect}")
	private String dialect;
	
	@Value("${spring.datasource.jpa.show-sql}")
	private String showSQL;
	
	@Value("${spring.datasource.jpa.properties.format-sql}")
	private String formatSQL;
	
	@Value("${spring.datasource.jpa.properties.use-sql-comments}")
	private String commentsSQL;
	
	@Value("${spring.datasource.use-legacy-date-time-code}")
	private String useLegacyDatetimeCode;
	
	@Value("${spring.datasource.default-timezone}")
	private String defaultTimeZone;

	@Primary
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(getFormatedUrl());
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		return dataSource;
	}
	

	@Primary
	@Bean
	public EntityManager entityManager() {
		return entityManagerFactory().getObject().createEntityManager();
	}

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("br.com.vinicius.model");
		em.setPersistenceUnitName("default");
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(getProperties());

		return em;
	}

	@Primary
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}


	private Properties getProperties() {
		Properties properties = new Properties();

		properties.put(Environment.DIALECT, dialect);
		properties.put(Environment.SHOW_SQL, showSQL);
		properties.put(Environment.FORMAT_SQL, formatSQL);
		properties.put(Environment.USE_SQL_COMMENTS, commentsSQL);
		properties.put(Environment.HBM2DDL_AUTO, "");
		properties.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, true);
		// properties.put(Environment.USE_SECOND_LEVEL_CACHE, true);
		// properties.put(Environment.CACHE_REGION_FACTORY,
		// "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
		// properties.put(Environment.CACHE_PROVIDER_CONFIG, "/ehcache.xml");
		// properties.put(Environment.USE_QUERY_CACHE, true);
		return properties;
	}

	private String getFormatedUrl() {		
		return String.format(url, useLegacyDatetimeCode, defaultTimeZone);
	}
	
}
