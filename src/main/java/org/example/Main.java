package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

import java.security.Key;
import java.sql.Driver;
import java.util.Random;

public class Main
{
    public static void main( String[] args ) {
        Random r = new Random();

        System.setProperty("webdriver.chrome.driver","F:\\Selenium\\Chrome\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://localhost:44346");

        WebElement mes = driver.findElement(By.xpath("//li[@class='LeftMenuItem-module__container--v2Q9c'][3]"));
        mes.click();

        WebElement input = driver.findElement(By.xpath("//a[text()='Chest_API']"));
        input.click();
        AddChest(driver, 20,r);




    }
    private  static  void ConnectToVk (ChromeDriver driver, String Mail){
        driver.get("https://vk.com/kekesik228");
        WebElement Enter = driver.findElement(By.xpath("//button[text() = 'Войти'][1]"));
        Enter.click();
        WebElement Box = driver.findElement(By.xpath("//input[@class = 'VkIdForm__input']"));
        Box.sendKeys(Mail);
        Box.sendKeys(Keys.TAB);
        Box.sendKeys(Keys.TAB);
        Box.sendKeys(Keys.ENTER);
    }
    private static void AddChest( ChromeDriver driver, int CreateNumber, Random r){
        for (int i = 0; i < CreateNumber; i++) {


            WebElement chest = driver.findElement(By.xpath("//a[@class='nav-link text-dark'][1]"));
            chest.click();

            WebElement addChest = driver.findElement(By.xpath("//a[text()='Добавить сундук']"));
            addChest.click();

            WebElement InputChestName = driver.findElement(By.xpath("//input[@type ='text']"));
            InputChestName.sendKeys("AutoChest" + r.nextInt(0, 123), Keys.TAB);
            WebElement InputChestSize = driver.findElement(By.xpath("//input[@type ='number']"));
            InputChestSize.sendKeys(String.valueOf(r.nextInt(20, 100)));
            InputChestSize.sendKeys(Keys.TAB);
            InputChestSize.sendKeys(Keys.ENTER);
        }
    }
}
