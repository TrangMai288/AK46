package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {
    /**
     *
     1. Open browser
     2. Navigate to https://the-internet.herokuapp.com/checkboxes
     3. Check on checkbox1
     4. Verify checkbox1 is checked
     5. Check on checkbox2
     6. Verify checkbox2 is checked
     */

    @Test
    void tc02() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath(
                "//form[@id='checkboxes']/input[1]"));
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());

        WebElement checkbox2 = driver.findElement(By.cssSelector(
                "#checkboxes input:nth-child[3]")); // xpath: //input[1]/../input[2]
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());
        driver.quit();
    }
}
