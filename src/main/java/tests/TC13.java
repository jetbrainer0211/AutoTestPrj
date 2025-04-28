package tests;

import core.BasePage;
import core.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AlertPage;
import utils.ExcelUtils;

import java.io.IOException;

public class TC13 extends BaseTest {

    @Test(dataProvider = "alertData")
    public void test(String type, String accept, String expectedMessage) throws IOException {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.navigateToPage("https://the-internet.herokuapp.com/javascript_alerts");
        switch (type.toLowerCase()) {
            case "alert":
                alertPage.actionForAlert(expectedMessage);
                break;

            case "confirm":
                boolean isAcceptConfirm = Boolean.parseBoolean(accept);
                alertPage.actionForConfirm(isAcceptConfirm, expectedMessage);
                break;

            case "prompt":
                boolean isAcceptPrompt = Boolean.parseBoolean(accept);
                alertPage.actionForPrompt(isAcceptPrompt,expectedMessage);
                break;

            default:
                throw new IllegalArgumentException("Invalid alert type: " + type);
        }
    }

    @DataProvider(name = "alertData")
    public Object[][] getAlertData() throws IOException {
        return ExcelUtils.getTableArray("src/alert_test_data.xlsx", "Sheet1", 0, 3);
    }
}
