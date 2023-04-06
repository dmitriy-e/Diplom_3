package org.stellar.burgers.ui.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {
    @FindBy(how = How.XPATH, using = ".//main/div/div/p/a")
    private SelenideElement loginLink;

    public LoginPage clickLoginLink() {
        loginLink.click();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();

        return loginPage;
    }
}
