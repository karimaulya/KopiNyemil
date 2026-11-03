# ☕ Kopi dan Nyemil

Aplikasi mobile Android untuk memesan kopi dan camilan, dibuat sebagai **Tugas UTS Pemrograman Mobile**. Tampilan mengusung tema **retro pop** dengan warna-warni kontras, border tebal, dan sudut membulat pada setiap tombol, input, dan kartu.

> *Get a taste of your wish.*

---

## 📱 Screenshot

| Splash | Sign Up | Login | Register |
|:---:|:---:|:---:|:---:|
| ![Splash](screenshots/01_splash.png) | ![Sign Up](screenshots/02_signup.png) | ![Login](screenshots/03_login.png) | ![Register](screenshots/04_register.png) |

| Home | Profile | Alamat (Order) | Konfirmasi |
|:---:|:---:|:---:|:---:|
| ![Home](screenshots/05_home.png) | ![Profile](screenshots/06_profile.png) | ![Order](screenshots/07_order.png) | ![Konfirmasi](screenshots/08_konfirmasi.png) |

---

## ✨ Fitur Utama

- **Splash / Welcome Screen**: Halaman pembuka dengan logo *Kopi dan Nyemil* serta tombol *Let's Get Started*.
- **Sign Up**: Halaman sambutan awal dengan dekorasi banner retro & pilihan navigasi (*Create New Account* atau *Already a Member*).
- **Register**: Membuat akun baru dengan mengisikan nama lengkap, username, dan password.
- **Login**: Autentikasi pengguna menggunakan username & password (mendukung pencarian *case-insensitive*, penanganan spasi otomatis, serta *fallback* akun demo `admin` / `123456`).
- **Home**: Menampilkan sapaan personal *"Halo {nama},"*, teks kutipan, badge kategori retro, dan daftar 10 menu kopi & makanan menggunakan `RecyclerView` & `MenuAdapter`.
- **Profile**: Menampilkan avatar profil di tengah, badge username, serta form pengaturan untuk mengubah **Full Name** dan **Username** secara langsung, tombol *Save Changes*, dan *Logout*.
- **Order (Alamat Pengiriman)**: Form isi alamat pengiriman (*Where to?*) yang meliputi Nama Penerima, Alamat Lengkap, dan Landmark/Patokan.
- **Konfirmasi Pesanan**: Halaman pesan sukses *"Order Received!"*, detail ucapan terima kasih, dekorasi visual retro, dan tombol *Awesome!* untuk kembali ke Home.
- **Bottom Navigation**: Navigasi bawah kustom (Home, Order, Profile) berbasis **Fragment** di dalam `HomeActivity`.
- **Tema Retro Pop**: Palette warna cerah, border tebal, sudut *rounded*, serta responsif di berbagai ukuran layar device.

---

## 🗂️ Alur Aplikasi

```
Splash → Sign Up ─┬→ Register ─┐
                  └→ Login ────┴→ HomeActivity (Fragment Host)
                                    ├── HomeFragment (Daftar Menu)
                                    ├── OrderFragment (Alamat) ──> ConfirmationActivity ──> HomeActivity
                                    └── ProfileFragment (Update Profile / Logout ──> SignUpActivity)
```

---

## 🛠️ Teknologi & Spesifikasi

| Komponen | Keterangan |
|---|---|
| Bahasa Pemrograman | Kotlin |
| Minimum SDK | API 27 (Android 8.1) |
| Target SDK | API 37 |
| IDE | Android Studio |
| Architecture / Design | Single-Activity Fragment Container + Multi-Activity Flow |
| UI Components | XML Layouts, Material Components (`Theme.KopiNyemil`) |
| List & Adapters | `RecyclerView` + `MenuAdapter` (`fitCenter` Image Ratio) |
| Management Sesi | `SessionManager` via `SharedPreferences` (`kopi_nyemil_prefs`) |
| Custom Styling | Drawable XML (`shape`, `layer-list`, `selector`) retro border |

---

## 🎨 Palette Warna Retro

| Warna | Hex | Penggunaan Utama |
|---|---|---|
| Kuning | `#FFC567` | Background Home & Tombol |
| Pink | `#FB7DA8` | Background Register & Badge |
| Merah | `#FD5A46` | Akses Badge & Tombol |
| Ungu | `#552CB7` | Background Profile & Tombol |
| Hijau | `#00995E` | Background Sign Up & Badge |
| Biru | `#058CD7` | Background Login & Tombol |
| Cream | `#FFF4DC` | Background Utama & Teks Kontras |

---

## 📁 Struktur Project

```
app/src/main/
├── java/lat/pam/kopinyemil/
│   ├── SplashActivity.kt        # Halaman pembuka / Splash
│   ├── SignUpActivity.kt        # Halaman landas login/register
│   ├── LoginActivity.kt         # Halaman autentikasi login
│   ├── RegisterActivity.kt      # Halaman pendaftaran akun
│   ├── HomeActivity.kt          # Host Fragment + Bottom Navigation Bar
│   ├── HomeFragment.kt          # Tab utama (Daftar menu)
│   ├── OrderFragment.kt         # Tab pengiriman / alamat
│   ├── ProfileFragment.kt       # Tab profil & update username/nama
│   ├── ConfirmationActivity.kt  # Halaman konfirmasi order
│   ├── FoodMenu.kt              # Data model & dummy list menu (10 items)
│   ├── MenuAdapter.kt           # Adapter RecyclerView untuk daftar menu
│   └── SessionManager.kt        # Manajemen sesi & penyimpanan akun
└── res/
    ├── layout/                  # XML Layouts (*_activity.xml, fragment_*.xml, item_menu.xml)
    ├── drawable/                # Asset gambar menu, logo, dekorasi, & bg_btn_*, bg_card_*
    └── values/                  # colors.xml, themes.xml, strings.xml
```

---

## 🧪 Data Menu Dummy (10 Items)

Aplikasi menyimpan data akun di `SharedPreferences`. Daftar menu dikelola secara statis melalui `FoodMenu.kt`:

| Menu | Deskripsi | Harga |
|---|---|---|
| **Iced Palm Sugar Latte** | Authentic palm sugar sweetness, fresh milk, and rich espresso. | Rp22.000 |
| **Iced Americano** | Pure black coffee extraction to refresh your day. | Rp18.000 |
| **Matcha Latte Pop** | Premium Japanese green tea mixed with milk, creamy and sweet. | Rp27.000 |
| **Classic Cappuccino** | Sharp espresso blended with super soft milk foam. | Rp25.000 |
| **Taro Milkshake** | Sweet retro-style purple taro milk to boost your mood. | Rp24.000 |
| **Crispy French Fries** | Crunchy and savory fries, the perfect hangout buddy. | Rp18.000 |
| **Choco Sprinkles Donut** | Soft vintage donut with thick chocolate sprinkles. | Rp12.000 |
| **Sourdough Loaf** | Naturally fermented bread, crispy on the outside and soft inside. | Rp35.000 |
| **Nougat Toast** | Classic toast spread with mocha cream and peanuts. | Rp20.000 |
| **Classic Choco Cookie** | Crunchy cookie with melted chocolate in every bite. | Rp10.000 |

---

## ▶️ Cara Menjalankan

1. Buka folder project di **Android Studio**.
2. Tunggu proses **Gradle Sync** hingga selesai.
3. Hubungkan perangkat Android (aktifkan USB Debugging) atau gunakan **Android Emulator**.
4. Klik tombol **Run ▶️** (atau jalankan `app:assembleDebug`).

**Akun Pengujian (Demo):**
- Anda dapat membuat akun baru via **Create New Account**.
- Atau langsung login menggunakan akun demo bawaan:
  - **Username**: `admin`
  - **Password**: `123456`

---

## 👤 Pembuat

- **Nama**: _isi nama kamu_
- **NIM**: _isi NIM kamu_
- **Mata Kuliah**: Pemrograman Mobile, UTS 2026
