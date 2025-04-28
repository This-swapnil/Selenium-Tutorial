package com.selenium.keyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyboardActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://text-compare.com/");

        Actions act = new Actions(driver);
        driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome");

        //Ctrl+A    Select the text
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        //Ctrl+C    -> copy the text into clipboard
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        //TAB   -> shift to 2nd Box
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        //Ctrl+V    ->paste the text to 2nd Box
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        Thread.sleep(3000);
        driver.quit();
    }
}