package com.example.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //fluent wait declaration
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                                                                .pollingEvery(Duration.ofSeconds(5))
                                                                .ignoring(NoSuchElementException.class);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userName = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//input[@placeholder='Username']"));
            }
        });
        userName.sendKeys("Admin");

        Thread.sleep(3000);

        driver.quit();
    }
}
