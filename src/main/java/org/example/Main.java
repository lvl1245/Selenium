package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Wait;

import java.security.Key;
import java.sql.Driver;
import java.util.Random;

public class Main
{
    public static void main( String[] args ) {
        Random r = new Random();

        System.setProperty("webdriver.chrome.driver","F:\\Selenium\\Chrome\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://vk.com");


       ConnectToVk(driver,"izer090@bk.ru", "zi89UHCw*CkCpgZ[]");




    }
    private  static  void ConnectToVk ( ChromeDriver driver , String Mail, String Pass){
        String originalWindow = driver.getWindowHandle();
        WebElement LoginField = driver.findElement(By.className("VkIdForm__input"));

        LoginField.sendKeys(Mail);
        LoginField.sendKeys(Keys.TAB);
        LoginField.sendKeys(Keys.TAB);
        LoginField.sendKeys(Keys.ENTER);


       // wait.until(numberOfWindowsToBe(2));


        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }


        WebElement PassField = driver.findElement(By.xpath("//input[@class = 'vkc__TextField__input']"));
        PassField.sendKeys(Pass);
        WebElement ButtonLog = driver.findElement(By.className("vkc__EnterPasswordNoUserInfo__buttonWrap"));
        ButtonLog.click();
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
