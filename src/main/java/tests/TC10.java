package tests;

import core.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TablePage;
import utils.ExcelUtils;

import java.io.IOException;

public class TC10 extends BaseTest {

    @Test(dataProvider = "tableData")
    public void testTableActions(String last, String first, String email, String due, String site, String action) throws IOException {
        TablePage tablePage = new TablePage(getDriver());
        tablePage.navigateToTable();

        tablePage.performActionForName(first, last, action);
        tablePage.getNameWithMaxDue();
    }

    @DataProvider(name = "tableData")
    public Object[][] getData() throws IOException {
        return ExcelUtils.getTableArray("src/TableActions.xlsx", "Sheet1", 0, 6);
    }
}
