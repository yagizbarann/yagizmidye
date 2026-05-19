# 🍽️ Yağız Midye - Restoran Otomasyon Sistemi

Modern restoran yönetimi için geliştirilmiş full-stack restoran otomasyon sistemi.

Bu proje ile:
- müşteriler sipariş verebilir,
- garsonlar siparişleri yönetebilir,
- admin ürünleri ve restoran sürecini kontrol edebilir.

---

# 🚀 Özellikler

## 👤 Müşteri Sistemi
- Menü görüntüleme
- Kategori bazlı ürün listeleme
- Ürün arama sistemi
- Kategori filtreleme
- Sepet özeti
- Online sipariş sistemi
- Masada sipariş sistemi
- Demo online ödeme ekranı
- Ürün görselleri
- Responsive tasarım

---

## 👨‍🍳 Garson Paneli
- Canlı sipariş takibi
- Sipariş durum güncelleme
- Masa doluluk sistemi
- Online sipariş görüntüleme
- Sipariş durum renkleri
- Canlı sipariş bildirimi

### Sipariş Durumları

| Durum | Renk |
|---|---|
| Bekliyor | 🟡 Sarı |
| Hazırlanıyor | 🔵 Mavi |
| Hazır | 🟢 Yeşil |
| İptal Edildi | 🔴 Kırmızı |

---

## 🛠️ Admin Paneli
- Ürün ekleme
- Ürün silme
- Ürün güncelleme
- Görsel yükleme sistemi
- Sipariş geçmişi
- Online sipariş detayları
- Toplam sipariş istatistikleri
- Restoran masa yönetimi

---

# 🥤 Menü Kategorileri

- Midye Dolma
- Kokoreç
- Çiğköfte
- Balık Ekmek
- İçecekler

---

# 📸 Görsel Sistemi

Projede:
- hazır ürün görselleri
- admin panelinden görsel yükleme
- local upload sistemi

desteklenmektedir.

---

# 🌐 Ana Sayfa Özellikleri

- Modern landing page
- WhatsApp destek hattı
- İşletme konumu
- Google Maps entegrasyonu

---

# ⚙️ Kullanılan Teknolojiler

## Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate

## Frontend
- HTML5
- CSS3
- JavaScript
- Thymeleaf

## Database
- H2 Database

---

# 🔐 Kullanıcı Rolleri

| Rol | Açıklama |
|---|---|
| ADMIN | Sistem yönetimi |
| WAITER | Garson paneli yönetimi |

---

# 📂 Proje Yapısı

```text
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/
 ├── config/
 ├── security/
 └── resources/
      ├── templates/
      └── static/
```

---

# ▶️ Projeyi Çalıştırma

## 1) Projeyi klonla

```bash
git clone <repo-url>
```

---

## 2) application.properties ayarla

```properties
spring.datasource.url=jdbc:h2:file:./data/yagizmidye
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

---

## 3) Projeyi çalıştır

```bash
mvn spring-boot:run
```

---

# 👨‍💻 Demo Kullanıcılar

## Admin

```text
Kullanıcı Adı: admin
Şifre: 12345
```

## Garson

```text
Kullanıcı Adı: garson
Şifre: 12345
```



# 📄 Lisans

Bu proje eğitim ve portföy amaçlı geliştirilmiştir.

---

# ✨ Geliştirici

**Baran  YAĞIZ / Yağız Midye Project**