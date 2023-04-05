package base;

import com.github.javafaker.Faker;
import org.stellar.burgers.ui.constants.Env;

public class BaseTest {
    protected Faker faker;

    public BaseTest() {
        faker = new Faker();
        setUpBrowser();
    }

    private void setUpBrowser() {
        System.setProperty("selenide.browser", Env.BROWSER_NAME);
    }
}
