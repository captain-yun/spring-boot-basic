package com.kitri.springbasicboot.lesson.mapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MappingController {
    // @ResponseBody : return 값을 responseBody에 넣겠다
    @GetMapping("/get")
    @ResponseBody
    public String get() {
        return "hello";
    }

    @GetMapping("/get2")
    public String get2(Model model) {
        model.addAttribute("message", "GET2");
        return "/lesson/mapping";
    }
    @GetMapping("/get3")
    public String get3(HttpServletRequest request) {
        request.setAttribute("message", "GET3");
        return "/lesson/mapping";
    }

    @RequestMapping(value = "/get4", method = RequestMethod.GET)
    public ModelAndView get4(ModelAndView mv) {
        mv.addObject("message", "GET4");
        mv.setViewName("/lesson/mapping");
        return mv;
    }

    @RequestMapping(
            value = {"/a", "/b", "c"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String multiURL(Model model) {
        model.addAttribute("message", "MULTI_URL_MAPPING");
        return "/lesson/mapping";
    }

    @PostMapping("/post")
    public String post(Model model) {
        model.addAttribute("message", "POST");
        return "/lesson/mapping";
    }

    @RequestMapping(value = "/put", method = {RequestMethod.GET, RequestMethod.PUT})
    public ModelAndView put(ModelAndView mv) {
        mv.setViewName("/lesson/mapping");
        mv.addObject("message", "PUT");
        return mv;
    }

    @DeleteMapping("/delete")
    public String delete(Model model) {
        model.addAttribute("message", "DELETE");
        return "/lesson/mapping";
    }

}
