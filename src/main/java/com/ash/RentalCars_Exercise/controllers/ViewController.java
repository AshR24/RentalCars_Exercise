package com.ash.RentalCars_Exercise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController
{
    @RequestMapping(value = "/")
    public String index(Model model)
    {
        return "index";
    }
}
