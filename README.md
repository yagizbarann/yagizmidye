# 🍽️ Yağız Midye - Restoran Otomasyon Sistemi

Modern restoran yönetimi için geliştirilmiş full-stack restoran otomasyon sistemi.

---

## 🚀 Özellikler

### 👤 Müşteri Sistemi
- Menü görüntüleme
- Kategori bazlı ürün listeleme
- Ürün arama
- Kategori filtreleme
- Sepet özeti
- Masada sipariş
- Online sipariş
- Online ödeme formu
- 16 haneli kart numarası kontrolü
- CVV kontrolü
- Ürün görselleri
- Modern responsive tasarım

---

### 👨‍🍳 Garson Paneli
- Canlı sipariş takibi
- Yeni sipariş bildirimi
- Sesli bildirim
- Sipariş durum güncelleme
- Masa doluluk sistemi
- Online sipariş görüntüleme
- Sipariş durum renkleri

---

### 🛠️ Admin Paneli
- Ürün ekleme
- Ürün silme
- Ürün güncelleme
- Görsel yükleme sistemi
- Sipariş geçmişi
- Online sipariş detayları
- Ödeme bilgisi görüntüleme
- Toplam sipariş istatistikleri
- Restoran masa yönetimi
- Modern sipariş geçmişi arayüzü

---

## 🥤 Menü Kategorileri

- Midye Dolma
- Kokoreç
- Çiğköfte
- Balık Ekmek
- İçecekler

---

## 🌐 Ana Sayfa

- Modern landing page
- WhatsApp destek hattı
- İşletme konumu
- Google Maps entegrasyonu
- Yağız Midye tanıtım alanı

---

## ⚙️ Kullanılan Teknolojiler

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate

### Frontend
- HTML5
- CSS3
- JavaScript
- Thymeleaf

### Database
- H2 Database

---

## 🔐 Demo Kullanıcılar

### Admin

```text
Kullanıcı Adı: admin
Şifre: 12345
```

### Garson

```text
Kullanıcı Adı: garson
Şifre: 12345
```

---

## ▶️ Projeyi Çalıştırma

### 1) Projeyi klonla

```bash
git clone <repo-url>
```

### 2) Proje dizinine gir

```bash
cd YagizMidye
```

### 3) Projeyi çalıştır

```bash
mvn spring-boot:run
```

veya IntelliJ IDEA üzerinden `Run` butonuna bas.

---

## 🗄️ H2 Console

Tarayıcıdan aç:

```text
http://localhost:8080/h2-console
```

Bilgiler:

```text
JDBC URL: jdbc:h2:mem:yagiz_midye_db
User: sa
Password: boş
```

---

## 📂 Proje Yapısı

```text
src/
 ├── main/
 │    ├── java/com/yagizmidye/
 │    │    ├── config/
 │    │    ├── controller/
 │    │    ├── dto/
 │    │    ├── entity/
 │    │    ├── repository/
 │    │    ├── security/
 │    │    └── service/
 │    └── resources/
 │         ├── static/
 │         │    └── images/products/
 │         ├── templates/
 │         └── application.properties
```

---

## 📌 Sipariş Durumları

| Durum | Açıklama |
|---|---|
| PENDING | Bekliyor |
| PREPARING | Hazırlanıyor |
| READY | Hazır |
| SERVED | Teslim Edildi |
| CANCELLED | İptal Edildi |
----

## 📄 Lisans

Bu proje eğitim ve portföy amaçlı geliştirilmiştir.

---

## ✨ Geliştirici

**Baran YAĞIZ / Yağız Midye Project**