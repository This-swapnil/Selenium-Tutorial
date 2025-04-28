package com.selenium.chromeFeatures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class EnableExtensions {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        File file = new File("/home/swapnil/Downloads/AdBlock.crx");
        options.addExtensions(file);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://text-compare.com/");

        String actTitle = driver.getTitle();
        System.out.println(actTitle);


        Thread.sleep(10000);
        driver.quit();
    }
}
