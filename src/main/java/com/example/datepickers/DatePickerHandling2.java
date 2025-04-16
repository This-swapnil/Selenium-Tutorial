package com.example.datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DatePickerHandling2 {

    public static void selectDate(WebDriver driver, String exDay) {
        //select Month
        WebElement drpMonth = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select selMonth = new Select(drpMonth);
        selMonth.selectByVisibleText("Sep");

        //select Month
        WebElement drpYear = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
        Select selYear = new Select(drpYear);
        selYear.selectByVisibleText("2026");

        // Date selection
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));
        for (WebElement date : dates) {
            if (date.getText().equals(exDay)) {
                date.click();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        //Expected data
        String exYear = "2026";
        String exMonth = "May";
        String exDay = "6";

        driver.findElement(By.xpath("//input[@id='txtDate']")).click();

        selectDate(driver, exDay);

        Thread.sleep(3000);
        driver.quit();
    }
}
