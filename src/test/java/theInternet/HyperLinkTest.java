package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperLinkTest {
    @Test
    void tc04(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.xpath("//a[@href='status_codes/200' and text()='200']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/200");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/301");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/404");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/500");
        driver.findElement(By.linkText("here")).click();

        driver.navigate().back();

        driver.quit();
    }

    @Test
    void tc04Update() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/status_codes");

        String href = driver.findElement(By.linkText("200")).getAttribute("href");
        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
        driver.navigate().back();

        href = driver.findElement(By.linkText("301")).getAttribute("href");
        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
        driver.navigate().back();

        href = driver.findElement(By.linkText("404")).getAttribute("href");
        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
        driver.navigate().back();

        href = driver.findElement(By.linkText("500")).getAttribute("href");
        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);

        driver.quit();
    }
}
