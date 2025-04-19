package com.example.mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsVsAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement rytBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions act = new Actions(driver);

        Action myAction = act.contextClick(rytBtn).build(); //creating and storing into a variable

        myAction.perform(); //performing or completing an action

        driver.quit();
    }
}
