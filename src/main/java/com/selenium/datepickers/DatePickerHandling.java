package com.selenium.datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickerHandling {

    public static void selectFutureDate(WebDriver driver, String month, String year, String day) {
        //select month and year
        while (true) {
            String currMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (currYear.equals(year) && currMonth.equals(month)) {
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //next
        }

        //select the date
        List<WebElement> dates = driver.findElements(
                By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr/td//a"));
        for (WebElement date : dates) {
            if (date.getText().equals(day)) {
                date.click();
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");

        // Switch to frame
        driver.switchTo().frame(0);

        // Method 1-> using sendkeys()
        /*
        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.sendKeys("04/15/2025"); // "mm//dd//yyyy"

         */

        // Method 2 -> using date-picker

        //Expected data
        String year = "2026";
        String month = "May";
        String day = "14";

        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();

        //select month and year
        selectFutureDate(driver, month, year, day);


        Thread.sleep(3000);
        driver.quit();
    }
}
