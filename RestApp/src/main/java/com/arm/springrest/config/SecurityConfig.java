package com.arm.springrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;

    //only user with role:SPITTER can access to specific url, all other url have no constraints
    //register form requires HTTPS
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                //.antMatchers("/spitter").hasRole("SPITTER")
                .antMatchers(org.springframework.http.HttpMethod.POST, "/spittle").hasRole("SPITTER")
                .anyRequest().permitAll();
        //.and().requiresChannel().antMatchers("/spitter/register").requiresSecure();
    }

    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        /*
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");*/
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled" +
                        "from Spitter where username=?")
                .authoritiesByUsernameQuery("select username, role_user" +
                        "from Spitter where username=?")
                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
    }
}
