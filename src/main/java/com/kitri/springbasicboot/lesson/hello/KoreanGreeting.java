package com.kitri.springbasicboot.lesson.hello;

import org.springframework.stereotype.Component;

@Component
public class KoreanGreeting implements Greeting {
    @Override
    public String hello() {
        return "안녕 !!!";
    }
}
