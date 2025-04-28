package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertiesReader;

import java.io.IOException;
import java.util.List;

public class DownloadPage extends BasePage {
    private PropertiesReader locators;
    private By fileLinks;

    public DownloadPage(WebDriver driver) throws IOException {
        super(driver);
        locators = new PropertiesReader("src/main/resources/locators.properties");
        fileLinks = By.cssSelector(locators.get("download.css"));
    }

    public void navigateToDownloadPage() {
        driver.get("https://the-internet.herokuapp.com/download");
    }

    public List<WebElement> getAllDownloadLinks() {
        return driver.findElements(fileLinks);
    }

    public WebElement getFileLinkByName(String fileName) {
        List<WebElement> links = getAllDownloadLinks();
        for (WebElement link : links) {
            if (link.getText().trim().equalsIgnoreCase(fileName)) {
                return link;
            }
        }
        return null;
    }

    public void downloadFile(String fileName) {
        WebElement fileLink = getFileLinkByName(fileName);
        if (fileLink != null) {
            fileLink.click();
        } else {
            throw new RuntimeException("Không tìm thấy file: " + fileName);
        }
    }
}
