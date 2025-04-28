package com.selenium.mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleClickEx {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.w3schools.com/TAgs/tryit.asp?filename=tryhtml5_ev_ondblclick3");

        driver.switchTo().frame("iframeResult");
        WebElement txtBox1 = driver.findElement(By.xpath("//input[@id='field1']"));
        WebElement txtBox2 = driver.findElement(By.xpath("//input[@id='field2']"));
        WebElement btn = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));

        txtBox1.clear();
        txtBox1.sendKeys("Hello Swapnil !");

        //Double-click
        Actions act = new Actions(driver);
        act.doubleClick(btn).perform();


        //validation
        if (txtBox2.getDomProperty("value").equals(txtBox1.getDomProperty("value"))) {
            System.out.println("Text copied successfully!");
        } else {
            System.out.println("Operation unsuccessful");
        }


        Thread.sleep(3000);
        driver.quit();
    }
}
