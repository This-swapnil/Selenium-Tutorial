package com.selenium.dropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BootstrapDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

        // 1. select single option
        //driver.findElement(By.xpath("//input[@value='Java']")).click();

        // 22. capture all the options and find out size
        List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
        //System.out.println("Number of options: " + options.size());

        // 3. Printing options from dropdown
        /*
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

         */

        // 4. select multiple options
        for (WebElement op : options) {
            String option = op.getText();
            if (option.equals("Java") || option.equals("Python") || option.equals("MySQL")) {
                op.click();
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
