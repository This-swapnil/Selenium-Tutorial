package com.selenium.keyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OpenTheLinkInNewTab {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");

        WebElement regLink = driver.findElement(By.xpath("//a[@class='ico-register']"));

        Actions act = new Actions(driver);

        act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();

        //switch to registration page
        List<String> ids = new ArrayList<>(driver.getWindowHandles());

        //Switch to Registration Page
        driver.switchTo().window(ids.get(1));

        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("User Name");

        //Switch back to home page
        driver.switchTo().window(ids.get(0));

        Thread.sleep(3000);
        driver.quit();
    }
}
