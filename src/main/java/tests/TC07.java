package tests;

import core.BaseTest;
import utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SliderPage;

import java.io.IOException;

public class TC07 extends BaseTest {
    @Test(dataProvider = "testData")
    public void test(String value) throws IOException, InterruptedException {
        SliderPage sliderPage = new SliderPage(getDriver());
        sliderPage.navigateToPage("https://the-internet.herokuapp.com/horizontal_slider");
        sliderPage.adjustSlider(value);
        sliderPage.verifySlider(value);

    }

    @DataProvider(name = "testData")
    public Object[][] getData() throws IOException {
        return ExcelUtils.getTableArray("src/sliderValue.xlsx", "Sheet1", 0, 1);
    }
}
