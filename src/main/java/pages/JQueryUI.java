package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertiesReader;

import java.io.IOException;

public class JQueryUI extends BasePage {

    private PropertiesReader locators;
    private By enabledMenu;
    private By downloadsMenu;
    private By pdfMenu;
    private By csvMenu;
    private By excelMenu;
    private By backMenu;

    public JQueryUI(WebDriver driver) throws IOException {
        super(driver);
        locators = new PropertiesReader("src/main/resources/locators.properties");

        enabledMenu = By.xpath(locators.get("menuPage.enabledMenu.xpath"));
        downloadsMenu = By.xpath(locators.get("menuPage.downloadsMenu.xpath"));
        pdfMenu = By.xpath(locators.get("menuPage.pdfMenu.xpath"));
        csvMenu = By.xpath(locators.get("menuPage.csvMenu.xpath"));
        excelMenu = By.xpath(locators.get("menuPage.excelMenu.xpath"));
        backMenu = By.xpath(locators.get("menuPage.backMenu.xpath"));
    }

    public void navigateAndClick(String parentMenu, String childMenu) {
        hoverToElement(getDriver(), enabledMenu);
        switch (parentMenu.toLowerCase()) {
            case "downloads":
                hoverToElement(getDriver(), downloadsMenu);

                switch (childMenu.toLowerCase()) {
                    case "pdf":
                        clickToElement(getDriver(), pdfMenu);
                        break;
                    case "csv":
                        clickToElement(getDriver(), csvMenu);
                        break;
                    case "excel":
                        clickToElement(getDriver(), excelMenu);
                        break;
                    default:
                        throw new RuntimeException("Invalid child menu under Downloads: " + childMenu);
                }
                break;

            case "back":
                clickToElement(getDriver(), backMenu);
                break;

            default:
                throw new RuntimeException("Invalid parent menu: " + parentMenu);
        }
    }

}
