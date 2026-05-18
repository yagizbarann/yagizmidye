package com.yagizmidye.config;

import com.yagizmidye.entity.Product;
import com.yagizmidye.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.yagizmidye.entity.AppUser;
import com.yagizmidye.entity.Role;
import com.yagizmidye.repository.AppUserRepository;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final AppUserRepository appUserRepository;

    public DataLoader(ProductRepository productRepository,
                      AppUserRepository appUserRepository)
    {
        this.productRepository = productRepository;
        this.appUserRepository = appUserRepository;
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
        if (appUserRepository.count() == 0) {

            AppUser admin = new AppUser(
                    null,
                    "System Admin",
                    "admin",
                    "12345",
                    Role.ADMIN
            );

            AppUser waiter = new AppUser(
                    null,
                    "Garson User",
                    "garson",
                    "12345",
                    Role.WAITER
            );

            appUserRepository.save(admin);
            appUserRepository.save(waiter);

            System.out.println("Kullanıcılar oluşturuldu.");
        }
    }
}