package com.example.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class ClosingBrowserWindow {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        Set<String> windowIDs = driver.getWindowHandles();

        for(String winId : windowIDs) {
            String title = driver.switchTo().window(winId).getTitle();
            System.out.println(title);

            if(title.equals("Human Resources Management Software | OrangeHRM HR Software")) {
                driver.close();
            }
        }
    }
}
