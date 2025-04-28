package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.HoverPage;

import java.io.IOException;

public class TC06 extends BaseTest {
    @Test
    public void test() throws IOException {
        HoverPage hoverPage = new HoverPage(getDriver());
        hoverPage.navigateToPage("https://the-internet.herokuapp.com/hovers");
        hoverPage.hover();
    }
}
