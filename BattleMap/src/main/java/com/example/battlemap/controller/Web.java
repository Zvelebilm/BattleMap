package com.example.battlemap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Web {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
