package com.kitri.springbasicboot.lesson.reqres;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/countries")
public class CountryController {
    static HashMap<String, Country> countries = new HashMap<>();
    static {
        countries.put("한국", new Country("한국", "서울"));
        countries.put("미국", new Country("미국", "워싱턴DC"));
        countries.put("프랑스", new Country("프랑스", "파리"));
        countries.put("몽골", new Country("몽골", "울란바토르"));
        countries.put("아르헨티나", new Country("아르헨티나", "부에노스아이레스"));
    }

    @GetMapping
    public ArrayList<Country> countries() {
        return new ArrayList<>(countries.values());
    }

//    @PostMapping("")
    public Country addCountry(@RequestParam String name, @RequestParam String capital) {
        countries.put(name, new Country(name, capital));
        return countries.get(name);
    }

//    @PostMapping("")
    public Country addCountry2(@RequestBody Country country) {
        countries.put(country.getName(), country);
        return countries.get(country.getName());
    }

    @PostMapping("")
    public Country addCountry3(@ModelAttribute Country country) {
        countries.put(country.getName(), country);
        return countries.get(country.getName());
    }

    @PostMapping("/4")
    public ResponseEntity<Country> addCountry4(@ModelAttribute Country country) {
        countries.put(country.getName(), country);
        return new ResponseEntity<>(countries.get(country.getName()), HttpStatus.UNAUTHORIZED);
    }
//    @GetMapping("/get2")
//    public Country getCountry2(@ModelAttribute Country country) {
//        return countries.get(country.getName());
//    }
//    @PostMapping("")
//    public Country addCountry(@RequestBody Country country) {
//        countries.put(country.getName(), country);
//        return country;
//    }
}
