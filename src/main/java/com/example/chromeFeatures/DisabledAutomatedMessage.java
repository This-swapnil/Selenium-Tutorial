package com.example.chromeFeatures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


// Disable "Chrome is being controlled by automated test software"
public class DisabledAutomatedMessage {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.google.com/");

        String actTitle = driver.getTitle();
        System.out.println(actTitle);
        Thread.sleep(3000);
        driver.quit();
    }
}
