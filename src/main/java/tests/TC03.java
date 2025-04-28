package tests;

import core.BaseTest;
import utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DropDown;

import java.io.IOException;

public class TC03 extends BaseTest {

    @Test(dataProvider = "testData")
    public void test(String option, String value) throws IOException {
        DropDown dropDown = new DropDown(getDriver());
        dropDown.navigateToPage("https://the-internet.herokuapp.com/dropdown");
        dropDown.actionForDropDown(option, value);
    }

    @DataProvider(name = "testData")
    public Object[][] getData() throws IOException {
        return ExcelUtils.getTableArray("src/DropDown_Data.xlsx", "Sheet1", 0, 2);
    }
}
