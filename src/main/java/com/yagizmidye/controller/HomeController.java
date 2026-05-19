package com.yagizmidye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/login-success")
    public String loginSuccess(Authentication authentication) {

        boolean isAdmin = authentication.getAuthorities()
                .stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));

        boolean isWaiter = authentication.getAuthorities()
                .stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_WAITER"));

        if (isAdmin) {
            return "redirect:/admin/products";
        }

        if (isWaiter) {
            return "redirect:/waiter/orders";
        }

        return "redirect:/";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}