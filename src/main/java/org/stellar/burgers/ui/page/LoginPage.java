package org.stellar.burgers.ui.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    @FindBy(how = How.NAME, using = "name")
    private SelenideElement emailField;
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordField;
    @FindBy(how = How.XPATH, using = ".//main/div/form/button")
    private SelenideElement signInButton;

    public SelenideElement getSignInButton() {
        return signInButton;
    }

    public void waitForLoadLoginPage() {
        signInButton.shouldBe(visible);
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public HomePage signIn(String email, String password) {
        setEmail(email);
        setPassword(password);
        signInButton.click();

        HomePage homePage = page(HomePage.class);
        homePage.waitForLoadHomePage();

        return homePage;
    }
}
