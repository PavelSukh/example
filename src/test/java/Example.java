import org.testng.annotations.Test;



public class Example extends SetUpAndTearDown {

    @Test
    public void openUrl(){
        actions().getUrl("https://www.google.com");
        actions().icon().isDisplayed();
    }
}
