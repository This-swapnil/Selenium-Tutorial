package com.example.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleFrames {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://ui.vision/demo/webtest/frames/");

        // WebElement
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);

        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome!");

        //go back to default(home) page
        driver.switchTo().defaultContent();

        //frame 2
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
        driver.switchTo().frame(frame2);

        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("World!");

        //go back to default(home) page
        driver.switchTo().defaultContent();

        //frame 3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Selenium");

        //frame 4 -> iFrame
        // ==> 1st switch to outer frame and then switch into inner frame <==
        // As we are inside the frame3 we directly switch to inside iframe
        driver.switchTo().frame(0); //switching using index
        driver.findElement(By.xpath("//div[@id='i6']//div[@class='AB7Lab Id5V1']")).click();

        //go back to default(home) page
        driver.switchTo().defaultContent();

        Thread.sleep(3000);
        driver.quit();
    }
}
