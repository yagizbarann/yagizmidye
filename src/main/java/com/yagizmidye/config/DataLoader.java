package com.yagizmidye.config;

import com.yagizmidye.entity.AppUser;
import com.yagizmidye.entity.Product;
import com.yagizmidye.entity.Role;
import com.yagizmidye.repository.AppUserRepository;
import com.yagizmidye.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.yagizmidye.entity.RestaurantTable;
import com.yagizmidye.entity.TableStatus;
import com.yagizmidye.repository.RestaurantTableRepository;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final AppUserRepository appUserRepository;
    private final RestaurantTableRepository restaurantTableRepository;

    public DataLoader(ProductRepository productRepository,
                      AppUserRepository appUserRepository,
                      RestaurantTableRepository restaurantTableRepository) {
        this.productRepository = productRepository;
        this.appUserRepository = appUserRepository;
        this.restaurantTableRepository = restaurantTableRepository;
    }

    @Override
    public void run(String... args) {

        if (productRepository.count() == 0) {

            productRepository.save(new Product(null, "Klasik Midye Dolma", "Özel soslu klasik midye dolma", 25.0, true, "Midye Dolma", "/images/products/klasik-midye.jpeg  " , 0.0));
            productRepository.save(new Product(null, "Köri Soslu Midye", "Köri aromalı özel midye dolma", 30.0, true, "Midye Dolma", "/images/products/kori-soslu-midye.jpeg",0.0));
            productRepository.save(new Product(null, "Acılı Midye Dolma", "Acı sevenlere özel midye dolma", 28.0, true, "Midye Dolma", "/images/products/acili-midye.jpeg",0.0));
            productRepository.save(new Product(null, "Beşamel Soslu Midye", "Beşamel soslu lezzetli midye", 30.0, true, "Midye Dolma", "/images/products/besamel-soslu-midye.jpeg",0.0));

            productRepository.save(new Product(null, "Çeyrek Kokoreç", "Bol baharatlı çeyrek kokoreç", 75.0, true, "Kokoreç", "/images/products/ceyrek-kokorec.jpeg",0.0));
            productRepository.save(new Product(null, "Yarım Kokoreç", "Baharatlı yarım ekmek kokoreç", 120.0, true, "Kokoreç", "/images/products/yarim-kokorec.jpeg",0.0));
            productRepository.save(new Product(null, "Tam Ekmek Kokoreç", "Doyurucu tam ekmek kokoreç", 180.0, true, "Kokoreç", "/images/products/tam-ekmek-kokorec.jpeg",0.0));
            productRepository.save(new Product(null, "Acılı Kokoreç", "Acılı baharatlı kokoreç", 130.0, true, "Kokoreç", "/images/products/acili-kokorec.jpeg",0.0));

            productRepository.save(new Product(null, "Çiğköfte Dürüm", "Acılı etsiz çiğköfte dürüm", 60.0, true, "Çiğköfte", "/images/products/cigkofte-durum.jpeg",0.0));
            productRepository.save(new Product(null, "Çiğköfte Porsiyon", "Bol yeşillikli çiğköfte porsiyon", 90.0, true, "Çiğköfte", "/images/products/cigkofte-porsiyon.jpeg",0.0));
            productRepository.save(new Product(null, "Mega Çiğköfte Dürüm", "Daha büyük ve doyurucu çiğköfte dürüm", 85.0, true, "Çiğköfte", "/images/products/mega-cigkofte-durum.jpeg",0.0));
            productRepository.save(new Product(null, "Aile Boyu Çiğköfte", "Kalabalık sofralar için aile boyu", 180.0, true, "Çiğköfte", "/images/products/aile-boyu-cigkofte.jpeg",0.0));

            productRepository.save(new Product(null, "Uskumru Balık Ekmek", "Besleyici ve doyurucu uskumrudan balık ekmek", 250.0, true, "Balık Ekmek", "/images/products/uskumru-balik.jpeg",0.0));
            productRepository.save(new Product(null, "Sardalya Balık Ekmek", "Denizin favori balığı sardalyadan balık ekmek", 220.0, true, "Balık Ekmek", "/images/products/sardalya-balik.jpeg",0.0));
            productRepository.save(new Product(null, "Hamsi Balık Ekmek", "Hızlı ve pratik karadeniz hamsisinden balık ekmek", 160.0, true, "Balık Ekmek", "/images/products/hamsi-balik.jpeg",0.0));
            productRepository.save(new Product(null, "Mezgit Balık Ekmek", "Halkın gurme lezzeti mezgit balık ekmek", 255.0, true, "Balık Ekmek", "/images/products/mezgit-balik.jpeg",0.0));

            productRepository.save(new Product(
                    null,
                    "Kola",
                    "Soğuk kola",
                    40.0,
                    true,
                    "İçecekler",
                    "/images/products/kola.jpeg"
                    ,0.0
            ));

            productRepository.save(new Product(
                    null,
                    "Ayran",
                    "Soğuk yayık ayran",
                    25.0,
                    true,
                    "İçecekler",
                    "/images/products/ayran.jpeg"
                    ,0.0
            ));

            productRepository.save(new Product(
                    null,
                    "Şalgam",
                    "Acılı şalgam suyu",
                    30.0,
                    true,
                    "İçecekler",
                    "/images/products/salgam.jpeg"
                    ,0.0
            ));

            productRepository.save(new Product(
                    null,
                    "Soda",
                    "Limonlu soda",
                    20.0,
                    true,
                    "İçecekler",
                    "/images/products/soda.jpeg"
                    ,0.0
            ));

            System.out.println("Ürün çeşitleri başarıyla eklendi.");
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
            if (restaurantTableRepository.count() == 0) {

                for (int i = 1; i <= 10; i++) {
                    RestaurantTable table = new RestaurantTable(
                            null,
                            String.valueOf(i),
                            TableStatus.EMPTY
                    );

                    restaurantTableRepository.save(table);
                }

                System.out.println("Masalar oluşturuldu.");
            }

            System.out.println("Kullanıcılar oluşturuldu.");
        }
    }
}