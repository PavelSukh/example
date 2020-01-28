import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.core.context.RetryerContext;
import io.qameta.atlas.core.internal.DefaultRetryer;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.util.Collections;

public class SetUpAndTearDown {

    private Atlas atlas;
    public static WebDriver webDriver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        WebDriverManager.chromedriver().version("78.0.3904.70").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        webDriver = new ChromeDriver(options);
        atlas = new Atlas(new WebDriverConfiguration(webDriver)).context(new RetryerContext(new DefaultRetryer(30000L, 1000L, Collections.singletonList(Throwable.class))));
    }

    @AfterClass
    public void stopDriver() throws Exception {
        webDriver.close();
    }

    protected Action actions() {
        return atlas.create(getDriver(), Action.class);
    }

    private WebDriver getDriver() {
        return webDriver;
    }

}
