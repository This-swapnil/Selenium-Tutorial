package com.selenium.checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckBoxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        // 1 -> select specific checkboxes
        //driver.findElement(By.xpath("//input[@id='sunday']")).click();

        // 2 -> select all the checkboxes
        List<WebElement> checkBoxes = driver.findElements(
                By.xpath("//input[@class=\"form-check-input\" and @type=\"checkbox\"]"));

        /*
        for (WebElement checkBox : checkBoxes) {
            checkBox.click();
        }
        */

        // 3 -> select last 3 checkboxes
        /*
        for (int i = 4; i < checkBoxes.size(); i++) {
            checkBoxes.get(i).click();
        }
         */

        // 4 -> select first 3 checkboxes
        /*
        for (int i = 0; i < checkBoxes.size() - 4; i++) {
            checkBoxes.get(i).click();
        }
         */

        // 5 -> unselect checkboxes if they are selected
        for (int i = 0; i < checkBoxes.size() - 4; i++) {
            checkBoxes.get(i).click();
        }

        Thread.sleep(3000);

        for (int i = 0; i < checkBoxes.size() - 4; i++) {
            if (checkBoxes.get(i).isSelected()) {
                checkBoxes.get(i).click();
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
