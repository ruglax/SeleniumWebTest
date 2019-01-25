package com.test.sitio;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;

public class BestDayTest {
    @Test
    public void useSelect() throws MalformedURLException {

        System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.bestday.com.mx/");

        WebElement popup = driver.findElement(By.id("modal-windows"));
        popup.findElement(By.id("id-icon-header-login-close")).click();

        WebElement selectCuartosElement = driver.findElement(By.name("num_cuartos"));
        Select selectCuartos = new Select(selectCuartosElement);
        selectCuartos.selectByVisibleText("5");

    }
}
