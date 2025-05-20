package com.mg.solidaritynetwork.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

    @GetMapping("/home")
    public ModelAndView getHome() {
        return new ModelAndView("index");
    }
}
