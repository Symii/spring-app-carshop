package me.symi.carshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "security/login-form";
    }

    @GetMapping("/access-denied")
    public String getAccessDeniedPage() {
        return "security/access-denied";
    }

}
