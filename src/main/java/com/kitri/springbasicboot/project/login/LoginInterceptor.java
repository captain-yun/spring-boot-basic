package com.kitri.springbasicboot.project.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
       Member member = (Member) session.getAttribute("loginMember");
        if (member == null) {
            response.sendRedirect("/login/forbidden.html");
            return false;
        }
        return true;
    }
}
