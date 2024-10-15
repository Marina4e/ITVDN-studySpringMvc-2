package org.mvc.itvdnstudyspringmvc2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @ModelAttribute("greeting")
    public String greeting() {
        return "Привіт, як справи";
    }

    @ModelAttribute("bookNames")
    public List<String> bookNames() {
        return List.of("B1",
                "F1",
                "r3");
    }

    @GetMapping("/")
    public String hello(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/{name}")
    public String hello1(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
