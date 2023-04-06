package org.stellar.burgers.ui.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {
    @FindBy(how = How.XPATH, using = ".//main/div/nav/ul/li[1]/a")
    private SelenideElement profileLabel;
    @FindBy(how = How.XPATH, using = ".//header/nav/ul/li[1]/a/p")
    private SelenideElement constructorLogo;
    @FindBy(how = How.CSS, using = ".AppHeader_header__logo__2D0X2 a")
    private SelenideElement logo;
    @FindBy(how = How.XPATH, using = ".//main/div/nav/ul/li[3]/button")
    private SelenideElement signOutButton;

    public void waitForLoadProfilePage() {
        profileLabel.shouldBe(visible);
    }

    public String getProfileLabel() {
        return profileLabel.getText();
    }

    public HomePage clickConstructorLogo() {
        constructorLogo.click();

        HomePage homePage = page(HomePage.class);
        homePage.waitForLoadHomePage();

        return homePage;
    }

    public HomePage clickLogo() {
        logo.click();

        HomePage homePage = page(HomePage.class);
        homePage.waitForLoadHomePage();

        return homePage;
    }

    public LoginPage clickSignOutButton() {
        signOutButton.click();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();

        return loginPage;
    }
}
