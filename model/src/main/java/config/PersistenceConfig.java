package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * Config JDBC
 *
 * @author gandrieu
 * @version 1.0
 */

@Configuration
@PropertySource("classpath:database.properties")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = { "model.repository" })
@EntityScan(basePackages="model")
@ComponentScan(basePackages = { "model", "site" })
@EnableTransactionManagement
public class PersistenceConfig {
    @Value("${appli.jdbc.driverClassName}")
    private String DRIVER_JDBC;

    @Value("${appli.jdbc.url}")
    private String DRIVER_JDBC_URL;

    @Value("${appli.jdbc.user}")
    private String DRIVER_JDBC_USER;

    @Value("${appli.jdbc.password}")
    private String DRIVER_JDBC_PWD;

    // Entity JPA
    private final static String[] ENTITIES_PACKAGES = { "model.entity", "site.config" };

    /**
     * DataSource MySQL
     *
     * @return dataSource
     */
    @Bean(name = "datasourcePersistence")
    public DataSource dataSource() {
        // DataSource TomcatJdbc
        DataSource dataSource = new DataSource();
        // configuration JDBC
        dataSource.setDriverClassName(DRIVER_JDBC);
        dataSource.setUrl(DRIVER_JDBC_URL);
        dataSource.setUsername(DRIVER_JDBC_USER);
        dataSource.setPassword(DRIVER_JDBC_PWD);
        // initialization connection
        dataSource.setInitialSize(5);
        // dataSource result
        return dataSource;
    }

    /**
     * Provider JPA is Hibernate
     *
     * @return hibernateJpaVendorAdapter
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    /**
     * EntityManagerFactory
     *
     * @param jpaVendorAdapter
     * @param dataSource
     * @return
     */
    @Bean
    public EntityManagerFactory entityManagerFactory(JpaVendorAdapter jpaVendorAdapter, DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPackagesToScan(ENTITIES_PACKAGES);
        factory.setDataSource(dataSource);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    /**
     * Transaction manager
     *
     * @param entityManagerFactory
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}

