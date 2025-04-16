package com.example.alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopUp {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //driver.get("https://the-internet.herokuapp.com/basic_auth");

        //To handle Authenticate popup we need to append username:password after https://
        //Syntax -> https://username:password@URL
        //eg. -> https://admin:admin@URL

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        Thread.sleep(3000);
        driver.quit();
    }
}
