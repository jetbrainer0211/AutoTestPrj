package pages;

import core.BasePage;
import utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HoverPage extends BasePage {
    private PropertiesReader locators;
    private By image1;
    private By image2;
    private By image3;

    public HoverPage(WebDriver driver) throws IOException {
        super(driver);

        locators = new PropertiesReader("src/main/resources/locators.properties");
        image1 = By.xpath(locators.get("hover.image1.xpath"));
        image2 = By.xpath(locators.get("hover.image2.xpath"));
        image3 = By.xpath(locators.get("hover.image3.xpath"));
    }

    public void hover() {

        waitForElementVisible(getDriver(), image1);
        hoverToElement(getDriver(), getDriver().findElement(image1));

        waitForElementVisible(getDriver(), image2);
        hoverToElement(getDriver(), getDriver().findElement(image2));

        waitForElementVisible(getDriver(), image3);
        hoverToElement(getDriver(), getDriver().findElement(image3));
    }
}
