package pages;

import core.BasePage;
import utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class WaitPage extends BasePage {
    private PropertiesReader locators;
    private By buttonStart;
    private By finishText;

    public WaitPage(WebDriver driver) throws IOException {
        super(driver);

        locators = new PropertiesReader("src/main/resources/locators.properties");
        buttonStart = By.tagName(locators.get("wait.button.tagName"));
        finishText = By.id(locators.get("wait.finishText.id"));
    }

    public void verifyMessage(String message) {
        clickToElement(getDriver(), getDriver().findElement(buttonStart));

//        === ExplicitWait Test ===
//        WebElement finishTextElement = waitForElementVisible(getDriver(), finishText); //explicitWait
////        WebElement finishTextElement = waitForElementVisible(getDriver(), getDriver().findElement(finishText)); //NoSuchElement do driver.findElement(), implicit
//        Assert.assertEquals(getElementText(getDriver(), finishTextElement), message);

         //=== FluentWait test ===
        Wait<WebDriver> fluentWait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        WebElement finishTextElement = fluentWait.until(driver ->
                driver.findElement(finishText)
        );

        Assert.assertEquals(getElementText(getDriver(), finishTextElement), message);



    }


}



