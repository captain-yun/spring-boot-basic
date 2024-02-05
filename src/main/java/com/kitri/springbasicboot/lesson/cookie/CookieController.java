package com.kitri.springbasicboot.lesson.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/cookie")
public class CookieController {

    @PostMapping
    public String makeCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("id", request.getParameter("id"));
//        cookie.setMaxAge(60 * 60 * 24 * 7); // 쿠키 만료기간 : 일주일
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        return cookie.getValue();
    }

    @GetMapping
    public String readCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id")) return cookie.getValue();
        }
        return null;
    }

    @GetMapping("/read")
    public String readCookie2(@CookieValue(name = "id", required = false) String id) {
        return id;
    }

    @DeleteMapping
    public void deleteCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }

}
