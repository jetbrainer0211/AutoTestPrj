package tests;

import core.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HoverPage;
import pages.JQueryUI;
import utils.ExcelUtils;

import java.io.IOException;

public class TC14 extends BaseTest {

    @Test(dataProvider = "hoverData")
    public void hoverAndClickMenuTest(String firstMenu, String secondMenu) throws IOException {
        JQueryUI JQueryUI = new JQueryUI(getDriver());
        JQueryUI.navigateToPage("https://the-internet.herokuapp.com/jqueryui/menu1");
        JQueryUI.navigateAndClick(firstMenu, secondMenu);
    }

    @DataProvider(name = "hoverData")
    public Object[][] getHoverData() throws IOException {
        return ExcelUtils.getTableArray("src/menu_test_data.xlsx", "Sheet1", 0, 2);
    }
}
