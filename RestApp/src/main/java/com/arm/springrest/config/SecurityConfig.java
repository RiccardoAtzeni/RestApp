package com.arm.springrest.config;

import com.arm.springrest.controller.CustomAuthFailureHandler;
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

    @Autowired
    CustomAuthFailureHandler customAuthFailureHandler;

    @Autowired
    CustomAuthProvider customAuthProvider;

    protected void configure(HttpSecurity http) throws Exception{
        /*
        authentication is required (redirect to /login) but welcome pages
        auth fails -> redirect to /login?error
        logout -> redirect to /login?logout
        formLogin().permitAll() allows access to any URL (i.e. /login and /login?error) associated to formLogin
        Anyone can access to URL that begins with /resources (css, js, images ecc.)
         */
        http.authorizeRequests()
                .antMatchers("/","/welcome","/homepage").permitAll()
                .antMatchers("/static/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().failureHandler(customAuthFailureHandler).loginPage("/login").loginProcessingUrl("/login")
                .permitAll()
                 .and().logout().permitAll();

        //only user with role:SPITTER can access to specific url, all other url have no constraints
        //register form requires HTTPS
                //.antMatchers("/spitter").hasRole("SPITTER")
                //.antMatchers(org.springframework.http.HttpMethod.POST, "/spittle").hasRole("SPITTER")
                //.anyRequest().permitAll();
        //.and().requiresChannel().antMatchers("/spitter/register").requiresSecure();
    }

    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(customAuthProvider);

        /*
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled" +
                        "from Spitter where username=?")
                .authoritiesByUsernameQuery("select username, role_user" +
                        "from Spitter where username=?")
                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));*/
    }
}
