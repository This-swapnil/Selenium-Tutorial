package DataProviderAnnotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderEx {

    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "dp")
    void testLogin(String email, String pwd) throws InterruptedException {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Thread.sleep(3000);

        boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
        if (status) {
            driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "dp", indices = {0, 4})
    Object[][] loginData() {
        Object[][] data = {

                {"abc@gmail.com", "test123"},
                {"xyz@gmail.com", "test012"},
                {"swapnil988@gmail.com", "test@1234"},
                {"johncanedy@gmail.com", "test"},
                {"swapnil98@gmail.com", "test@1234"},
        };
        return data;
    }
}
