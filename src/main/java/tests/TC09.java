package tests;

import utils.ActionKeywords;
import utils.ExcelUtils;
import org.testng.annotations.Test;



public class TC09 {

    @Test
    public void runLoginKeywordTest() throws Exception {
        Object[][] steps = ExcelUtils.getTableArray("src/LoginKeywords.xlsx", "Sheet1", 0, 5);

        for (Object[] step : steps) {
            String action = (String) step[1];
            String locatorType = (String) step[2];
            String locatorValue = (String) step[3];
            String data = (String) step[4];


            switch (action) {
                case "openBrowser" -> ActionKeywords.openBrowser(data);
                case "navigate" -> ActionKeywords.navigate(data);
                case "inputText" -> ActionKeywords.inputText(locatorType, locatorValue, data);
                case "click" -> ActionKeywords.click(locatorType, locatorValue);
                case "verifyText" -> ActionKeywords.verifyText(locatorType, locatorValue, data);
                case "closeBrowser" -> ActionKeywords.closeBrowser();
                default -> throw new Exception("Unknown action: " + action);
            }
        }
    }
}
