package org.example;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest
{
    @Test
    public void testTitle() throws Exception
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://refactoring.guru/ru/design-patterns/singleton");
        WebElement message = driver.findElement(By.xpath("//h1[@class=\"title\"]"));
        Assertions.assertEquals("Одиночка",message.getText());
        Assertions.assertEquals("h1", message.getAttribute("localName"));
        driver.quit();
    }
}
