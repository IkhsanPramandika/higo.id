package com.higo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends BasePage {

    // Locators
    private By fullNameInput = By.name("fullName");
    private By emailInput = By.name("email");
    private By companyInput = By.name("companyName");
    private By serviceDropdown = By.name("service");
    private By messageInput = By.name("message");
    private By submitButton = By.xpath("//button[normalize-space()='Submit']");

    // Constructor
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    // --- ACTIONS ---

    public void openPage() {
        openUrl("https://higo.id/contact-us");
    }

    public void inputFullName(String name) {
        type(fullNameInput, name);
    }

    public void inputEmail(String email) {
        type(emailInput, email);
    }

    public void inputCompany(String company) {
        type(companyInput, company);
    }

    public void inputMessage(String msg) {
        type(messageInput, msg);
    }

    public void fillForm(String name, String email, String company, String service, String msg) {
        type(fullNameInput, name);
        type(emailInput, email);
        type(companyInput, company);

        // Select Dropdown manual karena logic khusus
        Select select = new Select(driver.findElement(serviceDropdown));
        select.selectByVisibleText(service);

        type(messageInput, msg);
    }

    public void clickSubmit() {
        clickWithJS(submitButton);
    }
}