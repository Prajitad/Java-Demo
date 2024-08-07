package com.prajita.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {

    @GetMapping("/my")
    public String homeHandler(){
        return "helloooo";

    }
}
