package com.example.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleAlertUsingExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //declaration

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(myAlert.getText());
        myAlert.accept();

        Thread.sleep(3000);
        driver.quit();
    }
}
