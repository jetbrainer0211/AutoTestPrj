package tests;

import core.BaseTest;
import utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class TC01 extends BaseTest {


    @Test(dataProvider = "testData")
    public void test(String name, String pass, String message) throws IOException {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.navigateToPage("https://the-internet.herokuapp.com/login");
        loginPage.login(name, pass);
        loginPage.verifyMessage(message);
    }

    @DataProvider(name = "testData")
    public Object[][] getData() throws IOException {
        return ExcelUtils.getTableArray("src/Data.xlsx", "Trang tính1", 0, 3);
    }


}
