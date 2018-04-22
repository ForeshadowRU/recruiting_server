package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String hub() {
        return "hub";
    }
    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }
}
