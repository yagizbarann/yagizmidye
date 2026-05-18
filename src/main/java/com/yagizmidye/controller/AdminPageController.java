package com.yagizmidye.controller;

import com.yagizmidye.entity.Product;
import com.yagizmidye.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.yagizmidye.service.OrderService;

@Controller
public class AdminPageController {

    private final ProductService productService;
    private final OrderService orderService;

    public AdminPageController(ProductService productService,
                               OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }
    @GetMapping("/admin/products")
    public String adminProductsPage(Model model) {

        model.addAttribute("products", productService.getAllProducts());

        model.addAttribute("product", new Product());

        model.addAttribute("productCount", productService.getProductCount());

        model.addAttribute("orderCount", orderService.getTotalOrderCount());

        model.addAttribute("totalRevenue", orderService.getTotalRevenue());

        model.addAttribute("pendingOrders", orderService.getPendingOrderCount());

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

    @PostMapping("/admin/products/update/{id}")
    public String updateProduct(@PathVariable Long id,
                                @ModelAttribute Product product) {

        productService.updateProduct(id, product);

        return "redirect:/admin/products";
    }
}