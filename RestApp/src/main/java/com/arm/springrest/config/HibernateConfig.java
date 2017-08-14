package com.arm.springrest.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@PropertySource(value={"classpath:application.properties"})
@Resource(name="java:jboss/datasources/restAppDS", type=javax.sql.DataSource.class, lookup="java:jboss/datasources/restAppDS")
public class HibernateConfig {

    @Bean(name="restAppDataSource")
    public DataSource dataSource(@Value("${db.jndi}") String jndiName){
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource(jndiName);
    }

    @Bean(name="restAppDataSourceJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("restAppDataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }
}
