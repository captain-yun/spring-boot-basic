package com.kitri.springbasicboot.project.random_page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/random")
public class RandomController {
    @GetMapping("/color")
    public String randomColor(Model model) {

        model.addAttribute("color", generateRandomHex());
        return "/project/random_page/random-color";
    }

    public String generateRandomHex() {
        // Random instance
        Random r = new Random();
        int n = r.nextInt();

        // n stores the random integer in defcimal form
        String hexadecimal = Integer.toHexString(n);

        // toHexString(n) converts n to hexadecimal form
        System.out.println("Random Hexadecimal Byte: "
                + hexadecimal);

        return "#" + hexadecimal.substring(0, 6);
    }
}
