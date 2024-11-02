package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EdgeTest {
    @Test
    void openBrowserWithDefaultMode() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://selenium.dev");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }
}
