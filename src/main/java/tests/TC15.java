package tests;

import core.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.JQueryUI;
import pages.iFramePage;
import utils.ExcelUtils;

import java.io.IOException;

public class TC15 extends BaseTest {

    @Test(dataProvider = "inputData")
    public void test(String inputText) throws IOException {
        iFramePage iframe = new iFramePage(getDriver());
        iframe.navigateToPage("https://www.tiny.cloud/docs/tinymce/latest/basic-example1s/");
        iframe.inputTextToTinyMCE(inputText);
    }

    @DataProvider(name = "inputData")
    public Object[][] getAlertData() throws IOException {
        return ExcelUtils.getTableArray("src/iFrame_data.xlsx", "Sheet1", 0, 1);
    }
}
