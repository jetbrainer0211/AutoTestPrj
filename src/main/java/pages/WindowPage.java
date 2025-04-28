package pages;

import core.BasePage;
import utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class WindowPage extends BasePage {
    private PropertiesReader locators;
    private By buttonOpen;
    private By message;

    public WindowPage(WebDriver driver) throws IOException {
        super(driver);

        locators = new PropertiesReader("src/main/resources/locators.properties");
        buttonOpen = By.xpath(locators.get("window.button.xpath"));
        message = By.tagName(locators.get("window.text.tagName"));
    }

    public void handleWindow() {
        clickToElement(getDriver(), getDriver().findElement(buttonOpen));
        switchToNewWindow(getDriver());
    }

    public void verifyMessage(String msg) {
        Assert.assertEquals(getDriver().findElement(message).getText(), msg);
    }
}
