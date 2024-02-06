package com.kitri.springbasicboot.project.login;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @GetMapping
    public String loginPage() {
        return "redirect:/login/login.html";
    }

    @PostMapping
    public String login(LoginDto loginDto, HttpServletRequest request, HttpServletResponse response) {
        if (loginDto.getRememberEmail() != null) {
            response.addCookie(new Cookie("loginEmail", loginDto.getEmail()));
        }
//        } else {
//            Arrays.stream(request.getCookies()).forEach((cookie) -> {
//                if (cookie.getName().equals("loginEmail")) {
//                    cookie.setMaxAge(0);
//                }
//            });
//        }
        if (!loginService.login(loginDto)) {
            return "redirect:/login/fail.html";
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginService.getMember(loginDto.getEmail()));

        return "redirect:/login/success.html";
    }

    @GetMapping("/logout")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/login";
    }

    @PostMapping("/signup")
    public String signUp(@Valid SignUpFormDto form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/login/signup.html";
        }

        if (loginService.isDuplicated(form)) return "redirect:/login/signup.html";
        if (!loginService.isPasswordsSame(form)) return "redirect:/login/signup.html";

        loginService.joinMember(form);

        model.addAttribute("name", form.getName());
        return "/project/login/signup-success";
    }

    @GetMapping("/after-login")
    public String afterLogin() {
        return "redirect:/login/after-login.html";
    }
}
