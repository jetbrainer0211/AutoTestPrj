package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertiesReader;

import java.io.IOException;

public class iFramePage extends BasePage {
    private PropertiesReader locators;
    private By iframeTinyMCE;
    private By bodyEditor;

    public iFramePage(WebDriver driver) throws IOException {
        super(driver);

        locators = new PropertiesReader("src/main/resources/locators.properties");
        iframeTinyMCE = By.id(locators.get("iframe.iframetiny.id"));
        bodyEditor = By.id(locators.get("iframe.editBody.id"));
    }

    public void inputTextToTinyMCE(String text) {
        WebElement iframe = waitForElementVisible(getDriver(), iframeTinyMCE);
        driver.switchTo().frame(iframe);

        WebElement inputElement = waitForElementVisible(getDriver(), bodyEditor);
        inputElement.clear();
        inputElement.sendKeys(Keys.chord(Keys.META, "b"));
        inputElement.sendKeys(text);



        getDriver().switchTo().defaultContent();
    }
}

