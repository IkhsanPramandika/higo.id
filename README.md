# HIGO Website Automation Test

Repository ini berisi script automation testing untuk Technical Test QA Engineer. 
Project ini mencakup pengujian pada website **higo.id** dan **blog.higo.id**.

## 🛠 Tech Stack
Language: Java (JDK 21)
Framework:TestNG
Tool: Selenium WebDriver
Build Tool: Gradle
Pattern: Page Object Model (POM)

## 📋 Fitur Testing
1.  Contact Us Form: Validasi positif dan negatif (pengecekan format email).
2.  Blog Automation:
   1. Pencarian artikel dinamis (mengambil artikel teratas).
   2. Simulasi scroll membaca artikel.
   3. Input komentar dengan *auto-counter* (Test 1, Test 2, dst).
   4. Handling *Stale Element* dan *Lazy Loading*.

## 🚀 Cara Menjalankan (How to Run)

### Prasyarat
Pastikan Java (JDK) sudah terinstall di komputer Anda.

### Perintah Terminal
Jalankan perintah berikut di terminal/cmd:

```bash
# Untuk menjalankan semua test
./gradlew test

# Atau jika menggunakan Windows Command Prompt
gradlew.bat test
