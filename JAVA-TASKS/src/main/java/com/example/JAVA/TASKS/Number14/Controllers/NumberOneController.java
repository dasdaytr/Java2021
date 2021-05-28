package com.example.JAVA.TASKS.Number14.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumberOneController {
    @GetMapping("/hello")
    public String GetHello(){
        return "hello";
    }
}
