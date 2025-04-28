package com.selenium.dropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com");

        //search-box
        driver.findElement(By.name("q")).sendKeys("selenium");

        Thread.sleep(5000);

        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
        System.out.println(list.size());

        for (WebElement li : list) {
            System.out.println(li.getText());
            if (li.getText().equals("selenium")) {
                li.click();
                break;
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
