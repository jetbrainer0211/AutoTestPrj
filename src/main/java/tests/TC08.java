package tests;

import core.BaseTest;
import utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.WindowPage;

import java.io.IOException;

public class TC08 extends BaseTest {
    @Test(dataProvider = "testData")
    public void test(String message) throws IOException {
        WindowPage windowPage = new WindowPage(getDriver());

        windowPage.navigateToPage("https://the-internet.herokuapp.com/windows");
        windowPage.handleWindow();
        windowPage.verifyMessage(message);
    }

    @DataProvider(name = "testData")
    public Object[][] getData() throws IOException {
        return ExcelUtils.getTableArray("src/WindowData.xlsx", "Trang tính1", 0, 1);
    }
}
