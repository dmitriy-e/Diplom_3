import base.BaseTest;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.stellar.burgers.ui.constants.Env;
import org.stellar.burgers.ui.page.HomePage;
import org.stellar.burgers.ui.page.LoginPage;
import org.stellar.burgers.ui.page.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class RegisterTest extends BaseTest {
    private String username;
    private String email;
    private String password;

    @Before
    @Step("Generate user credentials")
    public void setUp() {
        username = faker.name().username();
        email = username + "@yandex.ru";
        password = faker.internet().password();
    }

    @Test
    @DisplayName("Test register successfully")
    public void testRegisterSuccessfully() {
        RegisterPage registerPage = open(Env.URL + "/register", RegisterPage.class);

        LoginPage loginPage = registerPage.register(username, email, password);
        HomePage homePage = loginPage.signIn(email, password);
        String getOrderButtonText = homePage.getOrderButton();

        assertEquals("Error occurred while login", getOrderButtonText, "Оформить заказ");
    }

    @Test
    @DisplayName("Test register successfully")
    public void testRegisterWithInvalidPasswordError() {
        RegisterPage registerPage = open(Env.URL + "/register", RegisterPage.class);

        registerPage.setUpFields(username, email, "1");
        registerPage.submitForm();
        String errorForPassword = registerPage.getInputErrorLabel();

        Assert.assertEquals("Expected error message: \"Некорректный пароль\"", "Некорректный пароль", errorForPassword);
    }

    @After()
    @Step("Close browser")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
