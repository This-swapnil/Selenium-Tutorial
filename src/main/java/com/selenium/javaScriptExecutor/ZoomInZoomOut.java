package com.selenium.javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZoomInZoomOut {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("document.body.style.zoom='20%'"); // set zoom level 50%

        Thread.sleep(5000);

        js.executeScript("document.body.style.zoom='75%'"); // set zoom level 75%

        Thread.sleep(5000);
        driver.quit();
    }
}
