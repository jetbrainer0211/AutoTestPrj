package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.WaitPage;

import java.io.IOException;

public class TC05 extends BaseTest {
    @Test
    public void test() throws IOException {
        WaitPage waitPage= new WaitPage(getDriver());
        waitPage.navigateToPage("https://the-internet.herokuapp.com/dynamic_loading/2");
        waitPage.verifyMessage("Hello World!");


    }

}
