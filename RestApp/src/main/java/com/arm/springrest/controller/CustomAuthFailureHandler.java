package com.arm.springrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

@Component(value="customAuthFailureHandler")
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static Logger logger = LoggerFactory.getLogger(CustomAuthFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        org.springframework.security.core.AuthenticationException exception) throws ServletException, IOException {

        try
        {
            File file = new File("C:\\Users\\Riccardo\\Downloads\\wildfly-9.0.2.Final\\standalone\\log\\authException.txt");
            PrintStream ps = new PrintStream(file);

            logger.error("Login request throws a "+exception.getClass());
            logger.error(exception.getMessage());
            exception.printStackTrace(ps);
            logger.info("For complete stacktrace, please see file to the follow path: "+file.getAbsolutePath());
        }catch(IOException e)
        {
            exception.printStackTrace();
        }


        getRedirectStrategy().sendRedirect(request,response,"/welcome");
    }
}
