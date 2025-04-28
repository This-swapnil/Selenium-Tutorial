package com.selenium.mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseHoverAction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement pointMe = driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
        WebElement laptops = driver.findElement(By.xpath("//a[normalize-space()='Laptops']"));

        Actions act = new Actions(driver);
        act.moveToElement(pointMe).moveToElement(laptops).click().build().perform();


        Thread.sleep(3000);
        driver.quit();
    }
}
