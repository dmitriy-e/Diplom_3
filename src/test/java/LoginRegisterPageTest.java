import base.BaseTest;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.stellar.burgers.ui.constants.Env;
import org.stellar.burgers.ui.page.HomePage;
import org.stellar.burgers.ui.page.LoginPage;
import org.stellar.burgers.ui.page.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.stellar.burgers.ui.constants.Credentials.SAVED_USER_EMAIL;
import static org.stellar.burgers.ui.constants.Credentials.SAVED_USER_PASSWORD;

public class LoginRegisterPageTest extends BaseTest {
    private RegisterPage registerPage;

    @Test
    @DisplayName("Test login from already login button")
    public void testAlreadyLoginButtonProcessSuccessfully() {
        registerPage = open(Env.URL + "/register", RegisterPage.class);
        LoginPage loginPage = registerPage.clickAlreadyLoginButton();
        HomePage homePage = loginPage.signIn(SAVED_USER_EMAIL, SAVED_USER_PASSWORD);

        assertEquals("Error occurred while login", "Оформить заказ", homePage.getOrderButton());
    }

    @After()
    @Step("Close browser")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
