package com.selenium.mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        Actions act = new Actions(driver);

        WebElement capRome = driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement cntryItaly = driver.findElement(By.xpath("//div[@id='box106']"));

        WebElement capWDC = driver.findElement(By.xpath("//div[@id='box3']"));
        WebElement cntryUSA = driver.findElement(By.xpath("//div[@id='box103']"));

        //dragAndDrop 1
        act.dragAndDrop(capRome, cntryItaly).perform();

        Thread.sleep(2000);

        //dragAndDrop 2
        act.dragAndDrop(capWDC, cntryUSA).perform();


        Thread.sleep(3000);
        driver.quit();
    }
}
