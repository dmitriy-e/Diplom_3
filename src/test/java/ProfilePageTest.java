import base.BaseTest;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.stellar.burgers.ui.constants.Env;
import org.stellar.burgers.ui.page.HomePage;
import org.stellar.burgers.ui.page.LoginPage;
import org.stellar.burgers.ui.page.ProfilePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.stellar.burgers.ui.constants.Credentials.SAVED_USER_EMAIL;
import static org.stellar.burgers.ui.constants.Credentials.SAVED_USER_PASSWORD;

public class ProfilePageTest extends BaseTest {
    private HomePage homePage;
    private ProfilePage profilePage;

    @Before
    @Step("Opening profile page")
    public void setUp() {
        homePage = open(Env.URL, HomePage.class);
        LoginPage loginPage = homePage.clickLoginButton(homePage.getProfileButton());
        HomePage homePage = loginPage.signIn(SAVED_USER_EMAIL, SAVED_USER_PASSWORD);
        profilePage = homePage.clickProfileButton();
    }

    @Test
    @DisplayName("Test open profile page successfully")
    public void testOpenProfilePageSuccessfully() {
        assertEquals("Error occurred with opening profile", "Профиль", profilePage.getProfileLabel());
    }

    @Test
    @DisplayName("Test click constructor logo and redirect to homepage")
    public void testClickConstructorLogoOpenHomePage() {
        HomePage homePage = profilePage.clickConstructorLogo();

        assertEquals("Can't redirect to homepage from profile page", "Оформить заказ", homePage.getOrderButton());
    }

    @Test
    @DisplayName("Test click logo and redirect to homepage")
    public void testClickLogoOpenHomePage() {
        HomePage homePage = profilePage.clickLogo();

        assertEquals("Can't redirect to homepage from profile page", "Оформить заказ", homePage.getOrderButton());
    }

    @Test
    @DisplayName("Test sign out successfully")
    public void testSignOutSuccessfully() {
        LoginPage loginPage = profilePage.clickSignOutButton();

        assertEquals("Error occurred with logout", "Войти", loginPage.getSignInButton().getText());
    }

    @After()
    @Step("Close browser")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
