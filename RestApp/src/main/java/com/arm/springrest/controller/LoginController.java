package com.arm.springrest.controller;

import com.arm.springrest.model.Spitter;
import com.arm.springrest.service.SpitterService;
import com.arm.springrest.service.SpitterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping({"/login"})
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SpitterService spitterService;

    @RequestMapping(method= RequestMethod.GET)
    public String getLoginPage(ModelMap model) {
        logger.info("Received a GET request for the login page");

        if(model.containsAttribute("error"))
            return null;
        return "login";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String processLogin(ModelMap model, @RequestParam("username") String username) {

            logger.info("Received a POST request for the username: "+username);
            Spitter spitter = spitterService.findByUsername(username);
            if(spitter==null)
                return "redirect:/welcome";
            else
                model.addAttribute("spitter",spitter);
                return "profile";
    }
}
