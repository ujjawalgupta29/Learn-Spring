package com.learning.todoWebApp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("name", "Ujjawal");
        return "welcome";
    }
}
