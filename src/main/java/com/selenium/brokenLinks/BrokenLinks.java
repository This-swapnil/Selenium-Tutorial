package com.selenium.brokenLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        int noOfBrokenLinks = 0;
        for (WebElement link : links) {
            String hrefAtt = link.getDomProperty("href");
            if (hrefAtt == null || hrefAtt.isEmpty()) {
                System.out.println(link + " href attribute is null or empty, so not possible to check");
                continue;
            }
            //hit URL to the server
            try {
                URL linkURL = new URL(hrefAtt); //converted href value form string to URL format
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();   //opens the connection to the server
                conn.connect(); //connect to server and send request the server
                if (conn.getResponseCode() >= 400) {
                    System.out.println(hrefAtt + " ==> Broken Link");
                    noOfBrokenLinks++;
                } else {
                    System.out.println(hrefAtt + " ==> is not a Broken");
                }
            } catch (Exception ignored) {

            }
        }
        System.out.println("No of broken links are: " + noOfBrokenLinks);

        Thread.sleep(3000);
        driver.quit();
    }
}
