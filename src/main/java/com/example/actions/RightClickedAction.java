package com.example.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RightClickedAction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement rightBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        WebElement copyBtn = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']"));

        Actions act = new Actions(driver);

        //Right Click Action
        act.contextClick(rightBtn).perform();

        //Click on copy
        copyBtn.click();

        /* switch to Alert (accept pop-up) */
        driver.switchTo().alert().accept();

        //switch to default page
        driver.switchTo().defaultContent();


        Thread.sleep(3000);
        driver.quit();
    }
}
