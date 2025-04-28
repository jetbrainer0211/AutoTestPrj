package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.CheckBoxes;

import java.io.IOException;

public class TC02 extends BaseTest {
    @Test
    public void test() throws IOException {
        CheckBoxes checkBoxes = new CheckBoxes(getDriver());
        checkBoxes.navigateToPage("https://the-internet.herokuapp.com/checkboxes");
        checkBoxes.actionForCheckbox();
    }
}
