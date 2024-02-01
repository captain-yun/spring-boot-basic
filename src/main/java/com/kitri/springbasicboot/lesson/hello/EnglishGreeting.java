package com.kitri.springbasicboot.lesson.hello;

import org.springframework.stereotype.Component;

@Component
public class EnglishGreeting implements Greeting {
    @Override
    public String hello() {
        return "Hello !!!";
    }

}
