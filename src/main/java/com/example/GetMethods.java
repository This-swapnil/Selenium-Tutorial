package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getPageSource());

        System.out.println(driver.getWindowHandle());

        System.out.println(driver.getWindowHandles());

        Thread.sleep(3000);
        driver.close();
    }
}
