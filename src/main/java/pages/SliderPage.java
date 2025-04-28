package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SliderPage extends BasePage {
    private PropertiesReader locators;
    private By slider;
    private By sliderValue;

    public SliderPage(WebDriver driver) throws IOException {
        super(driver);

        locators = new PropertiesReader("src/main/resources/locators.properties");
        slider = By.xpath(locators.get("slider.xpath"));
        sliderValue = By.id(locators.get("slider.id"));
    }

    public void adjustSlider(String value) {
        setSliderValue(getDriver(), getDriver().findElement(slider), value);
    }

    public void verifySlider(String value) {
        WebElement sliderValueElement = waitForElementVisible(getDriver(), sliderValue);
        Assert.assertEquals(Double.parseDouble(sliderValueElement.getText()), Double.parseDouble(value));
    }
}
