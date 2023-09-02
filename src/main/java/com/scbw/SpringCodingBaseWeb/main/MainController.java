package com.scbw.SpringCodingBaseWeb.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/hello")
    public String mainHello(){
        return "response/hello";
    }

}
