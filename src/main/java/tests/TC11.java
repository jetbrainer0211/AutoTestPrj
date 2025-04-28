package tests;

import core.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DownloadPage;
import utils.ExcelUtils;
import java.io.IOException;

public class TC11 extends BaseTest {

    @Test(dataProvider = "fileData")
    public void downloadFileTest(String fileName) throws IOException {
        DownloadPage downloadPage = new DownloadPage(getDriver());

        downloadPage.navigateToDownloadPage();
        downloadPage.downloadFile(fileName);

        System.out.println("File Downloaded: " + fileName);
    }

    @DataProvider(name = "fileData")
    public Object[][] getFileData() throws IOException {
        return ExcelUtils.getTableArray("src/SampleDownloadFiles.xlsx", "Sheet1", 0, 1);
    }
}
