package com.example.webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StaticWebTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        // 1. Find total no of rows in a table
        int rows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();

        // for single table in webpage
        //int rows = driver.findElements(By.tagName("tr")).size();
        System.out.println("Number of rows: " + rows);

        // 2. Find no of col in a table
        int cols = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th")).size();
        //int cols = driver.findElements(By.tagName("th")).size();
        System.out.println("Number of Columns in a table: " + cols);

        // Read data from specific rows and cols (ex 5th row and 1st col)
        WebElement bookName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[5]//td[1]"));
        System.out.println("Book Name: " + bookName.getText());

        // [7][3]
        String subject = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[7]//td[3]")).getText();
        System.out.println("Subject: " + subject);

        //read all table data from table

        /*
        for (int r = 2; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                String data = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + r + "]//td[" + c + "]"))
                                    .getText();
                System.out.print(data + " | ");
            }
            System.out.println();
        }

         */

        //read data from who's author is "Mukesh"
        for (int r = 2; r <= rows; r++) {
            String authorName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + r + "]//td[2]"))
                                      .getText();
            if (authorName.equals("Mukesh")) {
                String bkName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + r + "]//td[1]"))
                                      .getText();
                System.out.println("Book Name: " + bkName);
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
