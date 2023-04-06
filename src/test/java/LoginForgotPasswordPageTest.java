import base.BaseTest;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.stellar.burgers.ui.constants.Env;
import org.stellar.burgers.ui.page.ForgotPasswordPage;
import org.stellar.burgers.ui.page.HomePage;
import org.stellar.burgers.ui.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.stellar.burgers.ui.constants.Credentials.SAVED_USER_EMAIL;
import static org.stellar.burgers.ui.constants.Credentials.SAVED_USER_PASSWORD;

public class LoginForgotPasswordPageTest extends BaseTest {
    private ForgotPasswordPage forgotPasswordPage;

    @Test
    @DisplayName("Test login from already login button")
    public void testAlreadyLoginButtonProcessSuccessfully() {
        forgotPasswordPage = open(Env.URL + "/forgot-password", ForgotPasswordPage.class);
        LoginPage loginPage = forgotPasswordPage.clickLoginLink();
        HomePage homePage = loginPage.signIn(SAVED_USER_EMAIL, SAVED_USER_PASSWORD);

        assertEquals("Error occurred while login", "Оформить заказ", homePage.getOrderButton());
    }

    @After()
    @Step("Close browser")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
