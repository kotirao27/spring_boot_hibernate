package koti.sample.util;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	/**
	 * DataSource definition for database connection. Settings are read from
	 * the application.properties file (using the env object).
	 */
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("db.driver"));
			dataSource.setJdbcUrl(env.getProperty("db.url"));
			dataSource.setUser(env.getProperty("db.username"));
			dataSource.setPassword(env.getProperty("db.password"));		  
			dataSource.setInitialPoolSize(env.getProperty("db.jdbc.initialPoolSize") != null ?
					Integer.parseInt(env.getProperty("db.jdbc.initialPoolSize")) : 0);
			dataSource.setMaxPoolSize(env.getProperty("db.jdbc.maxPoolSize") != null ?
					Integer.parseInt(env.getProperty("db.jdbc.maxPoolSize")) : 0);
			dataSource.setMinPoolSize(env.getProperty("db.jdbc.minPoolSize") != null ?
					Integer.parseInt(env.getProperty("db.jdbc.minPoolSize")) : 0);
			dataSource.setAcquireIncrement(env.getProperty("db.jdbc.acquireIncrement") != null ?
					Integer.parseInt(env.getProperty("db.jdbc.acquireIncrement")) : 0);
			dataSource.setAcquireRetryAttempts(env.getProperty("db.jdbc.acquireRetry") != null ?
					Integer.parseInt(env.getProperty("db.jdbc.acquireRetry")) : 0);
			dataSource.setNumHelperThreads(env.getProperty("db.jdbc.numHelperThreads") != null ?
					Integer.parseInt(env.getProperty("db.jdbc.numHelperThreads")) : 0);
			return dataSource;
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = 
				new LocalSessionFactoryBuilder(dataSource());
		builder.scanPackages(env.getProperty("db.packagescan"))
		.addProperties(getHibernateProperties());
		//uncomment if you want to load a mapping resource
		//builder.addResource(env.getProperty("db.nativesqlresource"));
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.connection.release_mode",
				env.getProperty("db.hibernate.connection.release_mode"));
		prop.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		prop.put("hibernate.dialect", 
				env.getProperty("hibernate.dialect"));
/*		prop.put("hibernate.generate_statistics",
				env.getProperty("hibernate.generate_statistics"));*/
/*		prop.put("hibernate.cache.use_query_cache",
				env.getProperty("db.hibernate.cache.use_query_cache"));*/
		return prop;
	}

	@Bean
	public HibernateTransactionManager txManager() {
		return new HibernateTransactionManager(sessionFactory());
	}


	@Autowired
	private Environment env;


}