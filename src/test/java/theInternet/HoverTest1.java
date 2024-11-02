package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest1 {
    @Test
    void ableToHoverImage1(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);

        actions
                .moveToElement(
                        driver
                                .findElements(By.cssSelector("#content .figure"))
                                .get(1))
                .perform();
//        String imageName = driver.findElement(By.xpath("//*[@id='content']//div[@class='figure'][2]//h5")).getText();
        String imageName = driver.findElements(By.cssSelector(".figcaption h5")).get(0).getText();
        Assert.assertEquals(imageName,"name: user2");
    }
}
