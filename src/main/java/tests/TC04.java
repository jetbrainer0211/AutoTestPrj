package tests;

import core.BaseTest;
import utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InputPage;

import java.io.IOException;

public class TC04 extends BaseTest {

    @Test(dataProvider = "testData")
    public void test(String value) throws IOException {
        InputPage inputPage = new InputPage(getDriver());
        inputPage.navigateToPage("https://the-internet.herokuapp.com/inputs");
        inputPage.inputValue(value);
    }


    @DataProvider(name = "testData")
    public Object[][] getData() throws IOException {
        return ExcelUtils.getTableArray("src/Input_Data.xlsx", "Sheet1", 0, 1);
    }
}
