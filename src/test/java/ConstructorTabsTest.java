import base.BaseTest;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.stellar.burgers.ui.constants.Env;
import org.stellar.burgers.ui.page.HomePage;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class ConstructorTabsTest extends BaseTest {
    private HomePage homePage;
    private String tabName;

    public ConstructorTabsTest(String tabName) {
        this.tabName = tabName;
    }

    @Before
    public void setUp() {
        homePage = open(Env.URL, HomePage.class);
    }

    @Parameterized.Parameters()
    public static Object[][] getData() {
        return new Object[][]{
                {"Булки"},
                {"Соусы"},
                {"Начинки"},
        };
    }

    @Test
    @DisplayName("Test change tabs")
    public void testClickTab() {
        SelenideElement tabEl = homePage.findTab(tabName);
        actions().moveToElement(tabEl).click(tabEl).perform();
        assertThat("Tab is not current", tabEl.getAttribute("class"), containsString("tab_tab_type_current"));
    }

    @After()
    @Step("Close browser")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
