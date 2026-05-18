package com.yagizmidye.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Authentication authentication) {

        if (authentication != null && authentication.isAuthenticated()) {

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
        }

        return "redirect:/login";
    }
}