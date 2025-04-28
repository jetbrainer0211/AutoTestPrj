package pages;

import core.BasePage;
import utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class InputPage extends BasePage {
    private PropertiesReader locators;
    private By input;

    public InputPage(WebDriver driver) throws IOException {
        super(driver);
        locators = new PropertiesReader("src/main/resources/locators.properties");
        input = By.tagName(locators.get("input.tagName"));
    }

    public void inputValue(String value) {
        sendKeyToElement(getDriver(), getDriver().findElement(input), value);
    }
}
