package com.selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaits {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//declaration

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

        //use
        WebElement userName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        userName.sendKeys("Admin");

        WebElement userPass = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        userPass.sendKeys("admin123");

        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        btnLogin.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
