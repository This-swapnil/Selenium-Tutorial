package com.selenium.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class HandleBrowserWindow {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        Set<String> windowIDs = driver.getWindowHandles();

        //Approach->1
        /*
        List<String> windowList = new ArrayList<>(windowIDs);

        String parentID = windowList.get(0);
        String childID = windowList.get(1);

        //switch to child window
        driver.switchTo().window(childID);
        System.out.println(driver.getTitle());

        //switch to parent window
        driver.switchTo().window(parentID);
        System.out.println(driver.getTitle());
         */

        //Approach->2 looping

        for (String winId : windowIDs) {
            String title = driver.switchTo().window(winId).getTitle();

            if (title.equals("OrangeHRM")) {
                System.out.println(driver.getCurrentUrl());
            }
        }


        driver.quit();
    }
}
