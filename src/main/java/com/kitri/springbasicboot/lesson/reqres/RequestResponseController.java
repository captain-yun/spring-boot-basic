package com.kitri.springbasicboot.lesson.reqres;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
//@RequestMapping("/countries")
public class RequestResponseController {
    static HashMap<String, String> countries = new HashMap<>();
    static {
        countries.put("한국", "서울");
        countries.put("미국", "워싱턴DC");
        countries.put("프랑스", "파리");
        countries.put("몽골", "울란바토르");
        countries.put("아르헨티나", "부에노스아이레스");
    }
    static HashMap<String, Country> countries2 = new HashMap<>();
    static {
        countries2.put("한국", new Country("한국", "서울"));
        countries2.put("미국", new Country("미국", "워싱턴DC"));
        countries2.put("프랑스", new Country("프랑스", "파리"));
        countries2.put("몽골", new Country("몽골", "울란바토르"));
        countries2.put("아르헨티나", new Country("아르헨티나", "부에노스아이레스"));
    }
    // 국가, 수도
    @GetMapping("/{name}")
    public String searchCapital(@PathVariable String name, Model model) {
        String capital = countries.get(name);
        if (capital == null) {
            throw new RuntimeException("찾으려는 국가가 없습니다.");
        }
        model.addAttribute("name", name);
        model.addAttribute("capital", capital);

        return "/lesson/reqres/countries";
    }

    @GetMapping("/searchCapital")
    // @RequestParam("name") String name
    // @RequestParam String name
    // String name
    public String searchCapital2(String name, Model model) {

        String capital = countries.get(name);
        if (capital == null) {
            throw new RuntimeException("찾으려는 국가가 없습니다.");
        }
        model.addAttribute("name", name);
        model.addAttribute("capital", capital);

        return "/lesson/reqres/countries";
    }

    @PostMapping("/addCountry")
    public String addCountry(@RequestParam String name, @RequestParam String capital) {
        countries.put(name, capital);
        return "redirect:/";
    }

    @PostMapping("/addCountry2")
    public void addCountry2(@RequestBody Country country) {
       countries2.put(country.getName(), country);
    }


}
