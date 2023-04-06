package org.stellar.burgers.ui.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {
    @FindBy(how = How.XPATH, using = ".//main/section[2]/div/button")
    private SelenideElement loginButton;
    @FindBy(how = How.XPATH, using = ".//header/nav/a")
    private SelenideElement profileButton;
    @FindBy(how = How.CSS, using = "section.BurgerConstructor_basket__29Cd7.mt-25 > div > button")
    private SelenideElement orderButton;
    private SelenideElement tab;

    public void waitForLoadHomePage() {
        loginButton.shouldBe(visible);
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public SelenideElement getProfileButton() {
        return profileButton;
    }

    public LoginPage clickLoginButton(SelenideElement el) {
        el.click();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();

        return loginPage;
    }

    public ProfilePage clickProfileButton() {
        profileButton.click();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.waitForLoadProfilePage();

        return profilePage;
    }

    public String getOrderButton() {
        return orderButton.getText();
    }

    public SelenideElement findTab(String tabText) {
        return tab = $(byTagAndText("span", tabText)).parent();
    }
}
