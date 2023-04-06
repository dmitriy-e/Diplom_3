package org.stellar.burgers.ui.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.stellar.burgers.ui.constants.Env;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class RegisterPage {
    @FindBy(how = How.XPATH, using = ".//main/div/form/fieldset[1]/div/div/input")
    private SelenideElement nameField;
    @FindBy(how = How.XPATH, using = ".//main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailField;
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordField;
    @FindBy(how = How.XPATH, using = ".//main/div/form/button")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//main/div/div/p/a")
    private SelenideElement alreadyLoginButton;
    @FindBy(how = How.XPATH, using = ".//main/div/form/fieldset[3]/div/p")
    private SelenideElement inputErrorLabel;

    public void setUsername(String username) {
        nameField.setValue(username);
    }

    public void setEmail(String email) {
        emailField.setValue(email);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public LoginPage clickAlreadyLoginButton() {
        alreadyLoginButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();

        return loginPage;
    }

    public String getInputErrorLabel() {
        return inputErrorLabel.getText();
    }

    public void setUpFields(String username, String email, String password) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public void submitForm() {
        clickRegisterButton();
    }

    public LoginPage register(String username, String email, String password) {
        setUpFields(username, email, password);
        submitForm();

        LoginPage loginPage = open(Env.URL + "/login", LoginPage.class);
        loginPage.waitForLoadLoginPage();

        return loginPage;
    }
}
