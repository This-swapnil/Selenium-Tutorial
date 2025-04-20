package com.example.chromeFeatures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HeadlessTesting {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); //setting for headless mode of execution

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.google.com/");

        String actTitle = driver.getTitle();
        System.out.println(actTitle);
        if (actTitle.equals("Google")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
