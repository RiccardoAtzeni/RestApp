package com.arm.springrest.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan({"com.arm.springrest.model"})
@EnableTransactionManagement
@PropertySource(value={"classpath:application.properties"})
@Resource(name="java:jboss/datasources/restAppDS", type=javax.sql.DataSource.class, lookup="java:jboss/datasources/restAppDS")
public class HibernateConfig {

    @Value("${hibernate.dialect}")      private String hibernateDialect;
    @Value("${hibernate.show_sql}")     private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2ddlAuto;

    @Bean(name="restAppDataSource")
    public DataSource dataSource(@Value("${db.jndi}") String jndiName){
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource(jndiName);
    }

    @Bean(name="restAppDataSourceJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("restAppDataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }

    @Bean
    @Autowired
    LocalSessionFactoryBean sessionFactory(DataSource ds){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(ds);
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan(new String[]{"com.arm.springrest"});
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    Properties hibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        return properties;
    }
}
