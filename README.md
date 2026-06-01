# 🍽️ Yağız Midye - Restoran Otomasyon Sistemi

Modern restoran yönetimi için geliştirilmiş, Spring Boot tabanlı full-stack restoran otomasyon sistemi.

---

# 📖 Proje Hakkında

Yağız Midye, restoran süreçlerini dijital ortamda yönetmek amacıyla geliştirilmiş kapsamlı bir otomasyon sistemidir.

Sistem; müşteri sipariş yönetimi, masa takibi, online sipariş, online ödeme, ürün yönetimi, kampanya sistemi ve personel yetkilendirme gibi restoran operasyonlarında ihtiyaç duyulan temel özellikleri tek bir platformda sunmaktadır.

Proje Spring Boot mimarisi kullanılarak geliştirilmiş olup katmanlı mimari prensiplerine uygun şekilde tasarlanmıştır.

---

# 🚀 Özellikler

## 👤 Müşteri Sistemi

* Menü görüntüleme
* Kategori bazlı ürün listeleme
* Ürün arama
* Kategori filtreleme
* Sepet özeti
* Masada sipariş oluşturma
* Online sipariş oluşturma
* Online ödeme sistemi
* 16 haneli kart numarası doğrulama
* CVV doğrulama
* Ürün görselleri
* Responsive tasarım
* Kampanya ve indirim görüntüleme
* Toplam indirim tutarını gösterme

---

## 👨‍🍳 Garson Paneli

* Canlı sipariş takibi
* Yeni sipariş bildirimi
* Sipariş durum güncelleme
* Masa doluluk takibi
* Online sipariş görüntüleme
* Sipariş durum renkleri
* Sipariş hazırlama süreci yönetimi

### Sipariş Durumları

| Durum     | Açıklama      |
| --------- | ------------- |
| PENDING   | Bekliyor      |
| PREPARING | Hazırlanıyor  |
| READY     | Hazır         |
| SERVED    | Teslim Edildi |
| CANCELLED | İptal Edildi  |

---

## 🛠️ Admin Paneli

* Ürün ekleme
* Ürün güncelleme
* Ürün silme
* Ürün görseli yükleme
* Sipariş geçmişi görüntüleme
* Online sipariş detayları
* Ödeme bilgilerini görüntüleme
* Toplam sipariş istatistikleri
* Toplam ciro hesaplama
* Bekleyen sipariş sayısı
* İptal edilen sipariş sayısı
* Kampanya ve indirim yönetimi
* Restoran masa yönetimi

---

## 🥤 Menü Kategorileri

* Midye Dolma
* Kokoreç
* Çiğköfte
* Balık Ekmek
* İçecekler

---

## 🌐 Ana Sayfa

* Modern landing page tasarımı
* Yağız Midye tanıtım alanı
* WhatsApp destek hattı
* İşletme konumu
* Google Maps entegrasyonu
* Mobil uyumlu yapı

---

# 🎯 Kampanya Sistemi

Sistem içerisinde ürün bazlı kampanya ve indirim desteği bulunmaktadır.

Özellikler:

* Ürün bazlı indirim oranı tanımlama
* İndirimli fiyat hesaplama
* Toplam sepet indirimi hesaplama
* Kampanyalı ürünleri görüntüleme

---

# 🔒 Güvenlik

Spring Security kullanılarak rol bazlı yetkilendirme uygulanmıştır.

### Roller

#### Admin

* Ürün yönetimi
* Sipariş yönetimi
* Restoran yönetimi

#### Waiter

* Sipariş yönetimi
* Masa yönetimi

Yetkisiz kullanıcılar korunan sayfalara erişemez.

---

# ✅ Validation ve Hata Yönetimi

Projede veri doğrulama işlemleri uygulanmıştır.

Kullanılan Validation Yapıları:

* @Valid
* @NotBlank
* @NotEmpty
* @Min

Global hata yönetimi:

* GlobalExceptionHandler
* Validation Error Handling
* Runtime Exception Handling

---

# 🔍 Derived Query Methods

Repository katmanında aşağıdaki Spring Data JPA sorguları kullanılmaktadır:

```java
findByCategory(String category)

findByActiveTrue()

findByNameContainingIgnoreCase(String name)

findByStatus(OrderStatus status)

findByOrderType(OrderType orderType)

findByTableNumber(String tableNumber)
```

---

# 🏗️ Katmanlı Mimari

Proje aşağıdaki katmanlar kullanılarak geliştirilmiştir:

```text
Controller Layer
       ↓
Service Layer
       ↓
Repository Layer
       ↓
Database
```

Kullanılan paket yapısı:

```text
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/
 ├── dto/
 ├── exception/
 ├── security/
 ├── config/
 ├── templates/
 └── static/
```

---

# ⚙️ Kullanılan Teknolojiler

## Backend

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* Maven

## Frontend

* HTML5
* CSS3
* JavaScript
* Thymeleaf

## Database

* H2 Database

---

# 🔐 Demo Kullanıcılar

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

---

# ▶️ Projeyi Çalıştırma

## 1. Projeyi Klonla

```bash
git clone <repo-url>
```

## 2. Proje Dizinine Gir

```bash
cd YagizMidye
```

## 3. Uygulamayı Başlat

```bash
mvn spring-boot:run
```

veya IntelliJ IDEA üzerinden Run butonunu kullanabilirsiniz.

---

# 🗄️ Veritabanı

Proje H2 In-Memory Database kullanmaktadır.

Temel Tablolar:

* Product
* CustomerOrder
* OrderItem
* RestaurantTable
* AppUser

---

# 📡 Örnek API Endpointleri

```http
GET  /api/products

GET  /api/products/active

GET  /api/products/search?name=midye

POST /api/orders

GET  /api/orders

GET  /api/orders/status/PENDING

GET  /api/orders/type/ONLINE

PUT  /api/orders/{id}/status?status=READY
```

---

# 👨‍💻 Geliştirici

**Baran Yağız**

Yağız Midye Restaurant Automation Project

---

# 📄 Lisans

Bu proje eğitim, öğrenim ve portföy amaçlı geliştirilmiştir.
