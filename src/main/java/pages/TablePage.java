package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertiesReader;

import java.io.IOException;
import java.util.List;

public class TablePage extends BasePage {
    private PropertiesReader locators;
    private By byRows;

    public TablePage(WebDriver driver) throws IOException {
        super(driver);
        locators = new PropertiesReader("src/main/resources/locators.properties");
        byRows = By.xpath(locators.get("table.xpath"));
    }

    public void navigateToTable() {
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    public void performActionForName(String firstName, String lastName, String action) {
        List<WebElement> rows = driver.findElements(byRows);

        for (WebElement row : rows) {
            String first = row.findElement(By.xpath("./td[2]")).getText().trim();
            String last = row.findElement(By.xpath("./td[1]")).getText().trim();

            if (first.equals(firstName) && last.equals(lastName)) {
                WebElement actionButton = row.findElement(By.xpath(".//a[text()='" + action.toLowerCase() + "']"));
                actionButton.click();
                System.out.println("✅ Đã " + action + " cho: " + firstName + " " + lastName);
                break;
            }
        }
    }

    public String getNameWithMaxDue() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        double maxDue = 0;
        String fullName = "";

        for (WebElement row : rows) {
            double due = Double.parseDouble(row.findElement(By.xpath("./td[4]")).getText().replace("$", ""));
            String first = row.findElement(By.xpath("./td[2]")).getText();
            String last = row.findElement(By.xpath("./td[1]")).getText();

            if (due > maxDue) {
                maxDue = due;
                fullName = first + " " + last;
            }
        }

        System.out.println("💰 Người có DUE cao nhất là: " + fullName + " - $" + maxDue);
        return fullName;
    }
}
