package com.kitri.springbasicboot.lesson.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @Qualifier("englishGreeting")
    @Autowired
    Greeting greeting;
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", greeting.hello());
        return "greeting";
    }

}
