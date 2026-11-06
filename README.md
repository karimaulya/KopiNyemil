# ☕ Kopé dan Nyemil
> *Brew your story. Savor your snacks!*

Kopé dan Nyemil adalah aplikasi pemesanan kopi dan camilan berbasis Android dengan tampilan retro pop yang ceria: warna-warna kontras, border hitam tebal, dan bayangan keras di setiap tombol dan kartu. Pengguna bisa mendaftar atau masuk ke akunnya, menjelajahi 10 menu minuman dan makanan lengkap dengan foto dan harga, memilih jumlah porsi lewat tombol tambah dan kurang, lalu melihat ringkasan pesanan beserta total harganya. Setelah mengisi alamat pengiriman, pesanan dikonfirmasi dalam satu alur yang singkat dan mudah dipahami.

Aplikasi ini dibuat dengan Kotlin dan Android Studio sebagai Tugas UTS Pemrograman Mobile. Navigasi utamanya memakai Fragment (Home, Order, Profile) dan daftar menu memakai RecyclerView. Tidak memakai database: menu bersifat statis, data akun disimpan di SharedPreferences, dan keranjang dikelola di memori.

---

- **Nama**: Karima Ulya Hermawan 
- **NIM**: 1247050089
- **Mata Kuliah**: Pengembangan Aplikasi Mobile

## 📑 Daftar Isi

1. [Fitur](#-fitur)
2. [Panduan Penggunaan (per Halaman)](#-panduan-penggunaan-per-halaman)
3. [Alur Aplikasi](#️-alur-aplikasi)
4. [Teknologi](#️-teknologi--spesifikasi)
5. [Struktur Project](#-struktur-project)
6. [Cara Menjalankan](#️-cara-menjalankan)

---

## ✨ Fitur

**Akun & Autentikasi**
- **Splash / Welcome**: halaman pembuka dengan logo dan hiasan.
- **Sign Up**: pintu masuk dengan pilihan *Create New Account* atau *Already a Member*.
- **Register**: membuat akun dengan nama lengkap, username, dan password; semua kolom wajib diisi. Akun yang tersimpan hanya satu, jadi mendaftar lagi akan menimpa akun sebelumnya.
- **Login**: autentikasi username dan password. Username tidak membedakan huruf besar/kecil, password membedakan; spasi di tepi otomatis dibuang.
- **Logout**: keluar dari akun dan kembali ke Sign Up; tombol Back tidak bisa kembali ke halaman sebelumnya.

**Pemesanan**
- **Daftar menu** (10 item) memakai `RecyclerView`, lengkap dengan foto, deskripsi, dan harga.
- **Pengatur jumlah (+ / −)** di setiap menu untuk memilih berapa porsi yang dipesan.
- **Keranjang melayang**: muncul otomatis saat ada menu yang dipilih, menampilkan jumlah item, dan bila diketuk langsung membuka tab Order.
- **Ringkasan pesanan**: halaman Order menampilkan daftar menu terpilih beserta **total harga**.
- **Alamat pengiriman**: nama penerima, alamat lengkap, dan patokan.
- **Validasi pesanan**: order ditolak jika keranjang kosong atau data pengiriman belum lengkap.
- **Konfirmasi pesanan**: halaman sukses setelah order dikirim; keranjang otomatis dikosongkan.

**Profil & Navigasi**
- **Profile**: ubah *Full Name* dan *Username*, simpan dengan *Save Changes*; nama baru langsung dipakai di sapaan Home dan isian otomatis form Order.
- **Bottom Navigation** (Home, Order, Profile) berbasis **Fragment** di dalam `HomeActivity`.

---

## 📱 Panduan Penggunaan (per Halaman)

### 1. Splash / Welcome

<img src="screenshots/01_splash.jpeg" alt="Splash" width="250">

Halaman pertama yang muncul saat aplikasi dibuka, berisi logo **Kopi dan Nyemil**.

**Cara pakai:**
1. Ketuk tombol **Let's Get Started** untuk lanjut ke halaman Sign Up.
   
---

### 2. Sign Up

<img src="screenshots/02_signup.jpeg" alt="Sign Up" width="250">

Pintu masuk untuk menentukan apakah kamu pengguna baru atau sudah punya akun.

**Cara pakai:**
1. Jika **belum punya akun**, ketuk **Create New Account** untuk menuju halaman Register.
2. Jika **sudah punya akun**, ketuk **Already a Member** untuk menuju halaman Login.

---

### 3. Register

<img src="screenshots/04_register.jpeg" alt="Register" width="250">

Halaman untuk membuat akun baru.

**Cara pakai:**
1. Isi **Full Name** dengan nama lengkapmu.
2. Isi **Username** (pilih yang unik, dipakai untuk login).
3. Isi **Password**.
4. Ketuk **Register Now**.

---

### 4. Login

<img src="screenshots/03_login.jpeg" alt="Login" width="250">

Halaman masuk untuk pengguna yang sudah punya akun.

**Cara pakai:**
1. Isi **Username** dan **Password** akun yang sudah didaftarkan.
2. Ketuk **Log In**.
3. Jika benar, kamu masuk ke Home. Jika salah, muncul pesan *Username atau password salah*. Kolom yang kosong juga memunculkan peringatan.

---

### 5. Home (Daftar Menu)

<img src="screenshots/05_home.jpeg" alt="Home" width="250">

Halaman utama berisi sapaan dengan namamu dan daftar menu kopi serta camilan.

**Cara pakai:**
1. Ketuk tombol **+** pada menu yang kamu inginkan untuk menambah jumlah porsi. Ketuk **−** untuk menguranginya (jumlah tidak bisa kurang dari 0).
3. Angka di antara tombol menunjukkan jumlah porsi yang sedang dipilih.
4. Gunakan bar navigasi di bawah (**Home**, **Order**, **Profile**) untuk berpindah halaman.

#### Memilih beberapa menu

<img src="screenshots/09_home_cart.jpeg" alt="Home dengan keranjang" width="250">

Setelah ada menu yang dipilih, **tombol keranjang** muncul di pojok kanan bawah dan menampilkan jumlah item (misalnya *2 Items*).

**Cara pakai:**
1. Tambahkan menu sebanyak yang kamu mau dengan tombol **+**.
2. Pantau jumlah total porsi lewat tombol keranjang di pojok kanan bawah.
3. Setelah selesai memilih, ketuk tombol keranjang tersebut, atau tab **Order** di bawah, untuk melanjutkan pesanan.

---

### 6. Order (Alamat Pengiriman)

<img src="screenshots/07_order.jpeg" alt="Order" width="250">

Halaman untuk memeriksa pesanan dan mengisi alamat pengiriman.

**Cara pakai:**
1. Periksa kartu **Selected Items**: di sini terlihat daftar menu yang kamu pilih (contoh: `2x Iced Americano`) dan **Total** harganya. Jika masih kosong, kembali ke Home dan pilih menu dulu.
2. Periksa **Full Name**. Kolom ini sudah terisi otomatis dengan nama akunmu, dan boleh diganti jika pesanan untuk orang lain.
3. Isi **Address** dengan alamat lengkap (jalan dan nomor rumah).
4. Isi **Landmark** dengan patokan, misalnya "Pagar hijau dekat warung".
5. Ketuk **Order & Deliver Now**.

---

### 7. Konfirmasi Pesanan

<img src="screenshots/08_konfirmasi.jpeg" alt="Konfirmasi" width="250">

Halaman yang menandakan pesananmu sudah diterima.

**Cara pakai:**
1. Ketuk **Awesome!** untuk kembali ke Home. Keranjang sudah kosong, jadi kamu bisa langsung memesan lagi.

---

### 8. Profile

<img src="screenshots/06_profile.jpeg" alt="Profile" width="250">

Halaman untuk melihat dan mengubah data akunmu.

**Cara pakai:**
1. Ubah **Full Name** dan/atau **Username** pada kolom yang tersedia. Keduanya tidak boleh kosong.
3. Ketuk **Save Changes** untuk menyimpan. Muncul pesan *Profile berhasil disimpan* dan lencana username langsung berubah. 
4. Ketuk **Logout** untuk keluar dari akun dan kembali ke halaman Sign Up. Tombol Back tidak akan membawamu kembali ke Home.

---

## 🗂️ Alur Aplikasi

```
Splash → Sign Up ─┬→ Register ─┐
                  └→ Login ────┴→ HomeActivity (Fragment Host)
                                    ├── HomeFragment    (Daftar Menu + pilih jumlah + keranjang melayang ──┐)
                                    ├── OrderFragment   (Ringkasan + Alamat) ◄─────────────────────────────┘
                                    │        └→ ConfirmationActivity → HomeActivity (keranjang dikosongkan)
                                    └── ProfileFragment (Ubah data / Logout → SignUpActivity)
```

---

## 🛠️ Teknologi & Spesifikasi

| Komponen | Keterangan |
|---|---|
| Bahasa Pemrograman | Kotlin |
| Minimum SDK | API 27 (Android 8.1) |
| Target SDK | API 37 |
| IDE | Android Studio |
| Arsitektur UI | Multi-Activity + Fragment (`HomeActivity` sebagai host 3 fragment) |
| UI Components | XML Layout, Material Components (`Theme.KopiNyemil`) |
| Daftar menu | `RecyclerView` + `MenuAdapter` |
| Keranjang | `CartManager` (object/singleton yang menyimpan jumlah per menu di memori, dipakai bersama oleh Home dan Order; total harga dihitung otomatis dan diformat rupiah) |
| Manajemen sesi | `SessionManager` via `SharedPreferences` (`kopi_nyemil_prefs`) |
| Styling retro | Drawable XML (`shape`, `layer-list`, `selector`) untuk border dan bayangan |
| Aset gambar | WebP / JPG / Vector untuk ilustrasi dan foto menu |

---

## 📁 Struktur Project

```
app/src/main/
├── java/lat/pam/kopinyemil/
│   ├── SplashActivity.kt        # Halaman pembuka
│   ├── SignUpActivity.kt        # Pilihan Register / Login
│   ├── LoginActivity.kt         # Autentikasi
│   ├── RegisterActivity.kt      # Pendaftaran akun
│   ├── HomeActivity.kt          # Host fragment + bottom navigation
│   ├── HomeFragment.kt          # Daftar menu + keranjang melayang
│   ├── OrderFragment.kt         # Ringkasan pesanan + alamat
│   ├── ProfileFragment.kt       # Ubah data akun + logout
│   ├── ConfirmationActivity.kt  # Konfirmasi pesanan
│   ├── FoodMenu.kt              # Model dan data menu dummy
│   ├── MenuAdapter.kt           # Adapter RecyclerView (termasuk tombol + / −)
│   ├── CartManager.kt           # Penyimpan isi keranjang
│   └── SessionManager.kt        # Penyimpan akun
└── res/
    ├── layout/                  # *_activity.xml, fragment_*.xml, item_menu.xml
    ├── drawable/                # foto menu, logo, dekorasi, bg_btn_*, bg_card_*, bg_box_*, bg_qty_*
    └── values/                  # colors.xml, themes.xml, strings.xml
```

---

## ▶️ Cara Menjalankan

1. Clone repository:
   ```bash
   git clone https://github.com/<username>/<nama-repo>.git
   ```
2. Buka folder project di **Android Studio**, lalu tunggu **Gradle Sync** selesai.
3. Hubungkan perangkat Android (aktifkan USB Debugging) atau gunakan **Android Emulator**.
4. Klik **Run ▶️**.

**Akun untuk mencoba:**
- Buat akun baru lewat **Create New Account**, atau
- Langsung login dengan akun demo: username `admin`, password `123456` (hanya jika belum ada akun yang didaftarkan; kalau sudah, pakai akun tersebut atau hapus data aplikasi lewat Settings).

**Skenario uji cepat:**
1. Login dengan akun demo (atau akun yang kamu daftarkan).
2. Di Home, tambahkan 2-3 menu dengan tombol **+**.
3. Buka tab **Order**, cek ringkasan dan total, isi alamat, ketuk **Order & Deliver Now**.
4. Pada halaman konfirmasi, ketuk **Awesome!**.
5. Buka tab **Profile**, ubah nama, ketuk **Save Changes**, lalu **Logout**.


