package com.selenium.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 1. Normal Alert with "OK" button

        /*
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Thread.sleep(3000);

        Alert myAlert = driver.switchTo().alert();
        System.out.println(myAlert.getText());

        myAlert.accept();

         */

        // 2. Confirmation Alert "OK" & "Cancel"

        /*
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert myAlert = driver.switchTo().alert();

        System.out.println(myAlert.getText());
        Thread.sleep(3000);
        myAlert.dismiss();

         */

        // 3. Prompt alert- Input Box
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert myAlert = driver.switchTo().alert();

        //send text to alert
        myAlert.sendKeys("Swapnil");
        myAlert.accept();


        Thread.sleep(3000);
        driver.quit();
    }
}
