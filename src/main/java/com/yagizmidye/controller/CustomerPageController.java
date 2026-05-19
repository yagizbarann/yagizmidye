package com.yagizmidye.controller;

import com.yagizmidye.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.yagizmidye.entity.Product;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CustomerPageController {

    private final ProductService productService;

    public CustomerPageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/customer/menu")
    public String customerMenuPage(Model model) {

        Map<String, List<Product>> groupedProducts = productService.getActiveProducts()
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        model.addAttribute("groupedProducts", groupedProducts);

        return "customer-menu";
    }
    @GetMapping("/customer/success")
    public String customerSuccessPage() {
        return "customer-success";
    }
}
