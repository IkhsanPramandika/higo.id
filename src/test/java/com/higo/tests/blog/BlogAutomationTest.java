package com.higo.tests.blog;

import com.higo.pages.BlogPage;
import com.higo.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlogAutomationTest extends BaseTest {

    @Test(description = "Skenario Komentar Berurutan")
    public void testIsiKomentarDinamis() throws InterruptedException {
        BlogPage blog = new BlogPage(driver);

        // 1. Buka Website
        blog.bukaWebsite();

        // 2. Klik Artikel & Tunggu URL berubah
        blog.klikArtikelPertama();

        // 3. Validasi URL
        String urlSekarang = driver.getCurrentUrl();
        System.out.println("URL Artikel: " + urlSekarang);
        Assert.assertTrue(urlSekarang.contains("-"), "Gagal! Masih di halaman home.");

        // 4. Scroll ke Form
        blog.scrollKeFormKomentar();

        // 5. Isi Form (Ketik Nama & Komentar)
        int nomor = blog.ambilNomorAntrian();
        String komen = "Test " + nomor + " (Automation)";
        blog.isiForm("QA Bot", komen);

        System.out.println("Sukses input: " + komen);

        // 6. Klik Tombol Kirim
        System.out.println("Menekan tombol Kirim...");
//        blog.klikTombolKirim(); // Command kalo gamau

        // 7. Wait 5 Detik
        Thread.sleep(5000);
    }
}