package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/register");

        // isDisplayed()
        boolean logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
        System.out.println(logo);

        // isEnabled()
        boolean firstName = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
        System.out.println(firstName);

        // isSelected
        WebElement male_rb = driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement female_rb = driver.findElement(By.xpath("//input[@id='gender-female']"));

        System.out.println("Before selection" + ".".repeat(20));
        System.out.println(male_rb.isSelected());
        System.out.println(female_rb.isSelected());

        System.out.println("After selecting male" + ".".repeat(20));
        male_rb.click();
        System.out.println(male_rb.isSelected());
        System.out.println(female_rb.isSelected());

        System.out.println("After selecting fe-male" + ".".repeat(20));
        female_rb.click();
        System.out.println(male_rb.isSelected());
        System.out.println(female_rb.isSelected());

        Thread.sleep(3000);

        driver.quit();
    }
}
