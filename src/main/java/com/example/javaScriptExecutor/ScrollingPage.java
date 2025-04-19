package com.example.javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollingPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");

//        Thread.sleep(10000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1-> Scroll down page by pixel number
        /*
        js.executeScript("window.scrollBy(0,2000)", "");
        System.out.println(js.executeScript("return window.pageYOffset;", ""));

         */

        // 2-> scroll and access element
        /*
        WebElement text = driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
        js.executeScript("arguments[0].scrollIntoView();", text);
        System.out.println("Text: " + text.getText());
        System.out.println("Pixels to: " + js.executeScript("return window.pageYOffset;", ""));

         */

        // 3-> scroll page till the end

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println("Pixels to: " + js.executeScript("return window.pageYOffset;", ""));

        Thread.sleep(3000);

        // 4 ->
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        System.out.println("Pixels to: " + js.executeScript("return window.pageYOffset;", ""));

        Thread.sleep(3000);
        driver.quit();
    }
}
