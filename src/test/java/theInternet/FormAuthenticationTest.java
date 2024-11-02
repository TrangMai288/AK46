package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    WebDriver driver;
    /**
     *
     1. Open browser
     2. Navigate to https://the-internet.herokuapp.com/login
     3. Fill in username with tomsmith
     4. Fill in the password with SuperSecretPassword!
     5. Click on Login button
     6. And the home page is appear
     */
    @BeforeMethod
    void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    void shouldBeSuccessfullyWithValidCredentials() {
        driver.get("https://the-internet.herokuapp.com/login");

        // tagName=input
//      driver.findElement(By.tagName("input")).sendKeys("tomsmith");

        // type=text
//      driver.findElement(By.cssSelector("[type=text]")).sendKeys("tomsmith");
//      driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");

        // name=username
//        driver.findElement((By.name("username"))).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("[name=username")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");

        // id=username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");

        // tagName=input
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

//        driver.findElement(By.className("radius")).click();
//        driver.findElement(By.cssSelector(".radius")).click();
//        driver.findElement(By.xpath("//*[@class='radius']")).click();
//
//        driver.findElement(By.cssSelector("type=submit")).click();
        driver.findElement(By.cssSelector("button[type=submit]")).click();


        // verify current url = https://the-internet.herokuapp.com/secure
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");

        // verify message You logged into a secure area!
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));

        driver.quit();
    }

    @Test
    void loginUnsuccessfulWhenEnteringWrongUsername() {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("a");
        driver.findElement(By.id("password")).sendKeys("tomsmith1");

        driver.findElement(By.cssSelector("button[type=submit]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains( "Your username is invalid!"));
    }

    @Test
    void loginUnsuccessfulWhenEnteringWrongPassword() {
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("a");

        driver.findElement(By.cssSelector("button[type=submit]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains( "Your password is invalid!"));
    }
}
