package com.higo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.*;
import java.util.List;

public class BlogPage extends BasePage {
    // Locators
    private By listLinkArtikel = By.xpath("//h6[contains(@class, 'line-clamp-2')]/ancestor::a");
    private By inputNama = By.name("name");
    private By inputKomentar = By.name("comment");
    private By tombolKirim = By.xpath("//button[normalize-space()='Kirim']");

    // Constructor
    public BlogPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void bukaWebsite() {
        openUrl("https://blog.higo.id/");
    }

    public void klikArtikelPertama() {
        // Tunggu minimal 1 artikel muncul
        wait.until(ExpectedConditions.presenceOfElementLocated(listLinkArtikel));
        String urlLama = driver.getCurrentUrl();

        // Loop Retry (Anti-Stale)
        for (int i = 0; i < 3; i++) {
            try {
                List<WebElement> artikel = driver.findElements(listLinkArtikel);

                if (!artikel.isEmpty()) {
                    WebElement linkPertama = artikel.get(0);
                    scrollTo(linkPertama);
                    Thread.sleep(1000);
                    System.out.println("Klik artikel ke-1...");
                    clickWithJS(linkPertama);

                    // Tunggu pindah halaman
                    wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(urlLama)));
                    System.out.println("Berhasil pindah ke halaman artikel!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Gagal klik, mencoba lagi... (" + e.getClass().getSimpleName() + ")");
            }
        }
    }

    public void scrollKeFormKomentar() {
        // Scroll otomatis ke input nama
        WebElement fieldNama = wait.until(ExpectedConditions.visibilityOfElementLocated(inputNama));
        scrollTo(fieldNama);
    }

    public void isiForm(String nama, String komentar) {
        type(inputNama, nama);
        type(inputKomentar, komentar);
    }

    public void klikTombolKirim() {
        clickWithJS(tombolKirim);
    }

    // Logic Counter File
    public int ambilNomorAntrian() {
        File file = new File("counter.txt");
        int angka = 1;
        try {
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                if (line != null) angka = Integer.parseInt(line) + 1;
                reader.close();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(String.valueOf(angka));
            writer.close();
        } catch (IOException e) { e.printStackTrace(); }
        return angka;
    }
}