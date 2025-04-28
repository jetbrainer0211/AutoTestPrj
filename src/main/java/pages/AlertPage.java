package pages;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.PropertiesReader;

import java.io.IOException;

public class AlertPage extends BasePage {
    private PropertiesReader locators;
    private By jsAlertBtn;
    private By jsConfirmBtn;
    private By jsPromptBtn;
    public AlertPage(WebDriver driver) throws IOException {
        super(driver);

        locators = new PropertiesReader("src/main/resources/locators.properties");
        jsAlertBtn = By.xpath(locators.get("alertPage.alert.xpath"));
        jsConfirmBtn = By.xpath(locators.get("alertPage.confirm.xpath"));
        jsPromptBtn = By.xpath(locators.get("alertPage.prompt.xpath"));
    }

    public void actionForAlert(String message) {
        clickToElement(getDriver(), jsAlertBtn);
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(), message);
        alert.accept();
    }

    public void actionForConfirm(boolean isAccept, String message) {
        clickToElement(getDriver(), jsConfirmBtn);
        Alert confirm = getDriver().switchTo().alert();
        Assert.assertEquals(confirm.getText(), message);
        if(isAccept) {
            confirm.accept();
        } else {
            confirm.dismiss();
        }
    }

    public void actionForPrompt(boolean isAccept, String message) {
        clickToElement(getDriver(), jsPromptBtn);
        Alert prompt = getDriver().switchTo().alert();
        Assert.assertEquals(prompt.getText(), message);
        prompt.sendKeys("123");
        if(isAccept) {
            prompt.accept();
        } else {
            prompt.dismiss();
        }
    }
}
