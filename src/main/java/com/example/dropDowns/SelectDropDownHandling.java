package com.example.dropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectDropDownHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement dropCountryEle = driver.findElement(By.xpath("//select[@id='country']"));
        Select dropCountry = new Select(dropCountryEle);

        /*
        //select options form the dropdown
        dropCountry.selectByVisibleText("India");   //select By Visible Text

        Thread.sleep(3000);
        dropCountry.selectByValue("canada");    //select By Value

        Thread.sleep(3000);
        dropCountry.selectByIndex(5);   //select By Index

         */

        //capture the options from the dropdown
        List<WebElement> options = dropCountry.getOptions();
        System.out.println("Number of options in dropdown: " + options.size());

        //printing the options
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
