package com.selenium.keyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SliderDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        Actions act = new Actions(driver);

        // Min-Slider
        /*
        WebElement minSlider = driver.findElement(By.xpath("//body[1]/div[2]/div[2]/span[1]"));
        System.out.println("Location of the min Slider before moving: " + minSlider.getLocation());   //(59, 257)

        act.dragAndDropBy(minSlider, 100, 257).perform();

        System.out.println("Location of the min Slider after moving: " + minSlider.getLocation());  //(159, 257)
         */

        //Max-slider
        WebElement maxSlider = driver.findElement(By.xpath("//body[1]/div[2]/div[2]/span[2]"));
        System.out.println("Location of the max Slider before moving: " + maxSlider.getLocation()); //(613, 250)

        act.dragAndDropBy(maxSlider, -100, 250).perform();

        System.out.println("Location of the max Slider after moving: " + maxSlider.getLocation());  //(513, 250)

        Thread.sleep(3000);
        driver.quit();
    }
}
