package pages;

import core.BasePage;
import utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class DropDown extends BasePage {
    private PropertiesReader locators;
    private By dropDown;

    public DropDown(WebDriver driver) throws IOException {
        super(driver);
        locators = new PropertiesReader("src/main/resources/locators.properties");
        dropDown = By.id(locators.get("dropdown.select.id"));
    }

    public void actionForDropDown(String option, String value) {
        WebElement dropdownElement = waitForElementVisible(getDriver(), getDriver().findElement(dropDown));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(option);
        select.selectByValue(value);

    }


}
