package com.scbw.SpringCodingBaseWeb.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/hello")
    public String mainHello(){
        return "response/hello";
    }
}
