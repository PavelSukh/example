import io.qameta.atlas.appium.AtlasMobileElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Action extends AtlasMobileElement {

    @FindBy("//img[@alt='Google']")
    AtlasMobileElement icon();

    default void getUrl(String url){
        SetUpAndTearDown.webDriver.get(url);
    }
}
