package com.yagizmidye.config;

import com.yagizmidye.entity.Product;
import com.yagizmidye.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (productRepository.count() == 0) {

            Product midye = new Product(
                    null,
                    "Midye Dolma",
                    "Özel soslu midye dolma",
                    25.0,
                    true
            );

            Product kokorec = new Product(
                    null,
                    "Kokoreç",
                    "Baharatlı tam ekmek kokoreç",
                    120.0,
                    true
            );

            Product cigkofte = new Product(
                    null,
                    "Çiğköfte",
                    "Acılı etsiz çiğköfte",
                    80.0,
                    true
            );

            Product balikEkmek = new Product(
                    null,
                    "Balık Ekmek",
                    "Izgara balık ekmek",
                    150.0,
                    true
            );

            productRepository.save(midye);
            productRepository.save(kokorec);
            productRepository.save(cigkofte);
            productRepository.save(balikEkmek);

            System.out.println("Ürünler başarıyla eklendi.");
        }
    }
}