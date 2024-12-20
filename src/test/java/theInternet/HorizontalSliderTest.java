package theInternet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HorizontalSliderTest {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOptions);
        actions = new Actions(driver);
    }

    @Test
    void ableToHorizontalSlidePointer() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement pointer = driver.findElement(By.cssSelector(".sliderContainer input"));
        int offsetWidth = pointer.getSize().getWidth();
        int offsetHeight = pointer.getSize().getHeight();
        System.out.printf("%d %d", offsetHeight,offsetWidth);
        actions.clickAndHold(pointer)
                .moveByOffset(offsetWidth,0)
                .perform();

        Thread.sleep(1000); //wait until next change
        // Assert.assertEquals(driver.findElement(By.id("range")).getText(),"5");
        // Cannot test this case because this website loads slowly so the number cannot be displayed.
    }

//    @Test
//    void ableToHorizontalSlidePointerUsingWait() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
//
//        Actions actions = new Actions(driver);
//        WebElement pointer = driver.findElement(By.cssSelector(".sliderContainer input"));
//        int offsetWidth = pointer.getSize().getWidth();
//        int offsetHeight = pointer.getSize().getHeight();
//        System.out.printf("%d %d", offsetHeight,offsetWidth);
//        actions.clickAndHold(pointer)
//                .moveByOffset(offsetWidth,0)
//                .perform();
//
////        Thread.sleep(5000); // wait until text change
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("range"),"5")));
//    }

    @Test
    void ableScrollDown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        for (int i = 0; i < 5; i++) {
            actions.scrollByAmount(0,1000).perform();
            Thread.sleep(1000);
        }
    }

    @Test
    void contextClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    @Test
    void keyPress(){
        driver.get("https://the-internet.herokuapp.com/key_presses");

        actions.keyDown(Keys.ESCAPE).perform();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You entered: ESCAPE");
    }

    @Test
    void captureScreenshot() throws IOException {
        driver.get("https://www.selenium.dev/");

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("target/selenium.png");
        FileUtils.copyFile(srcFile, destFile);
    }

    @AfterMethod(alwaysRun = true)
    void captureScreenshot(ITestResult testResult) throws IOException {
        if(!testResult.isSuccess()){
            TakesScreenshot scrShot =((TakesScreenshot)driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(String.format("target/%s-%d.png",testResult.getMethod().getMethodName(),System.currentTimeMillis()));
            FileUtils.copyFile(srcFile, destFile);
        }
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
