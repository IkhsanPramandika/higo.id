package com.higo.tests.contact;

import com.higo.pages.ContactPage;
import com.higo.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class ContactUsTest extends BaseTest {

    @Test(description = "Test Positif: Mengisi form dengan data valid")
    public void testValidContactForm() {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.openPage();
        // Isi form
        contactPage.fillForm(
                "QA Candidate",
                "candidate@test.com",
                "HIGO Test",
                "HIGOspot",
                "Ini adalah test automation."
        );

        // Agar tidak terkirim
        // contactPage.clickSubmit();

        System.out.println("Test Validasi Form Berhasil (Tanpa Submit)");
    }

    @Test(description = "Test Negatif: Email format salah")
    public void testInvalidEmail() {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.openPage();

        // Input email salah
        contactPage.inputFullName("User Iseng");
        contactPage.inputEmail("email-salah-tanpa-at");
        contactPage.inputMessage("Test negative");

        // Klik submit
        contactPage.clickSubmit();

        // Ambil pesan validasi
        String errorMsg = driver.findElement(By.name("email")).getAttribute("validationMessage");

        // Validasi
        Assert.assertTrue(errorMsg.contains("@"), "Seharusnya muncul error minta '@'!");
        System.out.println("Pesan Error Browser Muncul: " + errorMsg);
    }
}