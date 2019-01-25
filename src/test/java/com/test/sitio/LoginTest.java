package com.test.sitio;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.List;


public class LoginTest {
    @Test
    public void testDownloadLinkExists() throws MalformedURLException {

        System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://beta.cfdi.com.mx/login/");

        WebElement cmpUserName = driver.findElement(By.id("CmpUserName"));
        cmpUserName.sendKeys("concosto");

        WebElement password = driver.findElement(By.id("PasswordRegistro"));
        password.sendKeys("Pass1234!");

        WebElement btnEnter = driver.findElement(By.id("ext-gen33"));
        btnEnter.click();

        /*Elemento solo de la pàgina*/
        WebDriverWait wait = new WebDriverWait(driver, 240);
        WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(By.id("MensajeWarning")));
        WebElement btnCerrar =  popup.findElement(By.className("x-btn-text"));
        btnCerrar.click();

        WebElement toolbar = driver.findElement(By.className("x-toolbar-left-row"));
        List<WebElement> menuCategory = toolbar.findElements(By.className("x-toolbar-cell"));
        menuCategory.get(0).click();


        WebElement menu = driver.findElement(By.id("x-menu-el-BotonSupModulo_CrearCFDI3_30"));
        menu.click();

        WebElement txtRfc = driver.findElement(By.id("RFC3_3"));
        txtRfc.sendKeys("AAA010101AAA");
        txtRfc.sendKeys("\t");
    }

}
