package com.yagizmidye.controller;

import com.yagizmidye.entity.Product;
import com.yagizmidye.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminPageController {

    private final ProductService productService;

    public AdminPageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/admin/products")
    public String adminProductsPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product", new Product());
        return "admin-products";
    }

    @PostMapping("/admin/products/add")
    public String addProduct(@ModelAttribute Product product) {
        product.setActive(true);
        productService.addProduct(product);
        return "redirect:/admin/products";
    }

    @PostMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/products";
    }
}