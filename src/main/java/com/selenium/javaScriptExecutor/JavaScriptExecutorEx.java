package com.selenium.javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavaScriptExecutorEx {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement inpBox = driver.findElement(By.xpath("//input[@id='name']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //passing text into textbox -> alternative of sendKeys()
        js.executeScript("arguments[0].setAttribute('value','Swapnil')", inpBox);

        //radio button click
        WebElement rdBtn = driver.findElement(By.xpath("//input[@id='male']"));
        js.executeScript("arguments[0].click()", rdBtn);

        Thread.sleep(3000);
        driver.quit();
    }
}
