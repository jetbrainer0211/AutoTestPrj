package pages;

import core.BasePage;
import utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class CheckBoxes extends BasePage {
    private PropertiesReader locators;
    private By checkbox1;
    private By checkbox2;

    public CheckBoxes(WebDriver driver) throws IOException {
        super(driver);
        locators = new PropertiesReader("src/main/resources/locators.properties");
        checkbox1 = By.xpath(locators.get("checkboxes.checkbox1.xpath"));
        checkbox2 = By.xpath(locators.get("checkboxes.checkbox2.xpath"));
    }

    public void actionForCheckbox() {
        WebElement cb1 = waitForElementVisible(getDriver(), getDriver().findElement(checkbox1));
        WebElement cb2 = waitForElementVisible(getDriver(), getDriver().findElement(checkbox2));

        if (!cb1.isSelected()) {
            cb1.click();
        }
        if (!cb2.isSelected()) {
            cb2.click();
        }

        Assert.assertTrue(cb1.isSelected());
        Assert.assertTrue(cb2.isSelected());
    }

}
