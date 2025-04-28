package tests;

import core.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.UploadPage;
import utils.ExcelUtils;

import java.io.IOException;

public class TC12 extends BaseTest {

    @Test(dataProvider = "uploadData")
    public void uploadFileTest(String fileName) throws IOException {
        UploadPage uploadPage = new UploadPage(getDriver());
        uploadPage.navigateToPage("https://the-internet.herokuapp.com/upload");
        uploadPage.uploadFile(fileName);
        uploadPage.verifyFileUploaded(fileName);
    }

    @DataProvider(name = "uploadData")
    public Object[][] getUploadData() throws IOException {
        return ExcelUtils.getTableArray("src/UploadFiles.xlsx", "Sheet1", 0, 1);
    }
}
