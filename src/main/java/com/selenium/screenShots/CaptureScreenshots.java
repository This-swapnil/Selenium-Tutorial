package com.selenium.screenShots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CaptureScreenshots {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");

        // 1 ==> capture full page screenshot
        /*
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/Screenshots/Full_Page.png";
        File targetFile = new File(path);
        FileUtils.copyFile(srcFile, targetFile);

         */

        // 2 ==> capture screenshot from the specific section
        /*
        WebElement featureProducts = driver.findElement(
                By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File srcFile = featureProducts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir") + "/Screenshots/featureProducts.png");
        FileUtils.copyFile(srcFile, targetFile);

         */

        // 3 ==> capture screenshot from the specific element
        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File srcFile = logo.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir") + "/Screenshots/logo.png");
        FileUtils.copyFile(srcFile, targetFile);

        Thread.sleep(3000);
        driver.quit();
    }
}
