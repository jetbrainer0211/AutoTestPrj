package pages;

import core.BasePage;
import utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class LoginPage extends BasePage {
    private PropertiesReader locators;
    private By username;
    private By password;
    private By submit;
    private By messageField;

    public LoginPage(WebDriver driver) throws IOException {
        super(driver);

        locators = new PropertiesReader("src/main/resources/locators.properties");
        username = By.id(locators.get("login.username.id"));
        password = By.id(locators.get("login.password.id"));
        submit = By.xpath(locators.get("login.submit.xpath"));
        messageField = By.id(locators.get("home.flash.id"));

    }



    public void login(String u, String p) {
        sendKeyToElement(getDriver(), getDriver().findElement(username), u);
        sendKeyToElement(getDriver(),  getDriver().findElement(password), p);
        clickToElement(getDriver(), getDriver().findElement(submit));
    }

    public void verifyMessage(String message) {
        WebElement messageElement = waitForElementVisible(getDriver(), messageField); //visibilityofElementLocated
        if(message.equals("successed")) {
            Assert.assertEquals(messageElement.getText(), "You logged into a secure area!\n" +
                    "×");
        } else {
            Assert.assertEquals(messageElement.getText(), "Your username is invalid!\n" +
                    "×");
        }
    }


}
