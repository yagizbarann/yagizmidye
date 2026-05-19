package com.yagizmidye.controller;

import com.yagizmidye.entity.Product;
import com.yagizmidye.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.yagizmidye.service.OrderService;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

        model.addAttribute("cancelledOrders", orderService.getCancelledOrderCount());
        return "admin-products";
    }

    @PostMapping("/admin/products/add")
    public String addProduct(@ModelAttribute Product product,
                             @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        product.setActive(true);
        product.setImageUrl(saveImage(imageFile));

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
                                @ModelAttribute Product product,
                                @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        Product existingProduct = productService.getProductById(id);

        if (imageFile != null && !imageFile.isEmpty()) {
            product.setImageUrl(saveImage(imageFile));
        } else {
            product.setImageUrl(existingProduct.getImageUrl());
        }

        productService.updateProduct(id, product);

        return "redirect:/admin/products";
    }
    private String saveImage(MultipartFile imageFile) throws IOException {

        if (imageFile == null || imageFile.isEmpty()) {
            return "";
        }

        String uploadPath = System.getProperty("user.dir") + File.separator + "uploads";

        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();

        File destination = new File(uploadDir, fileName);

        imageFile.transferTo(destination);

        return "/uploads/" + fileName;
    }
}