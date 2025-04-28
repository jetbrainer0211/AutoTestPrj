package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.PropertiesReader;

import java.io.File;
import java.io.IOException;

public class UploadPage extends BasePage {
    private PropertiesReader locators;
    private By chooseFileInput;
    private By uploadButton;
    private By uploadedFiles;

    public UploadPage(WebDriver driver) throws IOException {
        super(driver);

        locators = new PropertiesReader("src/main/resources/locators.properties");

        chooseFileInput = By.id(locators.get("upload.fileUpload.id"));
        uploadButton = By.id(locators.get("upload.fileSubmit.id"));
        uploadedFiles = By.id(locators.get("upload.uploadedFile.id"));


    }

    public void uploadFile(String fileName) {
        String uploadFolder = "/Users/hoangth16.dls/jenkins-agent/workspace/AutoTestPrj/src/main/resources/upload/";

        String fullPath = uploadFolder + fileName;
        WebElement uploadInput = waitForElementVisible(driver, chooseFileInput);
        uploadInput.sendKeys(new File(fullPath).getAbsolutePath());
        clickToElement(driver, driver.findElement(uploadButton));
    }

    public void verifyFileUploaded(String fileName) {
        WebElement uploaded = waitForElementVisible(driver, uploadedFiles);
        Assert.assertEquals(uploaded.getText().trim(), fileName, "Uploaded file name mismatch!");
    }
}
