package com.yagizmidye.controller;

import com.yagizmidye.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerPageController {

    private final ProductService productService;

    public CustomerPageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/customer/menu")
    public String customerMenuPage(Model model) {
        model.addAttribute("products", productService.getActiveProducts());
        return "customer-menu";
    }
    @GetMapping("/customer/success")
    public String customerSuccessPage() {
        return "customer-success";
    }
}
