package com.selenium.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;

public class FDCalculatorTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(
                "https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

        WebElement principle = driver.findElement(By.xpath("//input[@id='principal']"));
        WebElement ROI = driver.findElement(By.xpath("//input[@id='interest']"));
        WebElement period_count = driver.findElement(By.xpath("//input[@id=\"tenure\"]"));
        WebElement period_duration = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
        WebElement frequency = driver.findElement(By.xpath("//select[@id='frequency']"));
        WebElement calculate = driver.findElement(
                By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));
        WebElement clear = driver.findElement(By.xpath("//img[@class='PL5']"));

        //get an Excel file path
        String filePath = System.getProperty("user.dir") + "/TestData/CalData.xlsx";

        int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
        for (int i = 1; i <= rows; i++) {
            // 1 ->read data from Excel
            String pric = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
            String rateOfInterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
            String per1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
            String per2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
            String freq = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);

            String exp_mValue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

            System.out.println(
                    "principle: " + pric + " ROI: " + rateOfInterest + " period:" + per1 + " Duartion: " + per2 + " Frequency: " + freq);

            // 2 ->Pass above data into application
            principle.sendKeys(pric);
            ROI.sendKeys(rateOfInterest);
            period_count.sendKeys(per1);

            Select perDrp = new Select(period_duration);
            perDrp.selectByVisibleText(per2);

            Select frequencyDrp = new Select(frequency);
            frequencyDrp.selectByVisibleText(freq);

            calculate.click();

            // 3 ->validation
            String act_value = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
            if (Double.parseDouble(exp_mValue) == Double.parseDouble(act_value)) {
                System.out.println("Test Passed !!!");
                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
                ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
            } else {
                System.out.println("Test Passed !!!");
                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
                ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
            }

            Thread.sleep(3000);
            clear.click();
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
