package src.com.sitio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.security.Key;
import java.util.List;

public class CreditoTest {

    @Test
    public void selectMenu() {

        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

        //Estando en la página de selección de reportes
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost/thai/eCredisystem.htm");

        Assertions.assertEquals("eCredisystem", driver.getTitle());

        //Esperamos a que el iframe de los menús de reportes esté visible para obtener referencia al iframe
        WebDriverWait waitMenu = new WebDriverWait(driver, 240);
        WebElement frameMenu = waitMenu.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("frMenu"))));

        //Cambiamos el driver al iframe de los menús
        driver.switchTo().frame(frameMenu);

        //Esperamos a que esté disponible la información
        WebDriverWait wait = new WebDriverWait(driver, 240);
        WebElement form = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("frmjsMenuCO"))));

        //Seleccionamos la tabla de menus
        WebElement menuContainer = form.findElement(By.className("esTableTrMenu"));
        List<WebElement> menus = menuContainer.findElements(By.className("esTableTdMenu"));

        //Seleccionamos reportes
        int reportesIndex = 3;
        WebElement reportesMenu = menus.get(reportesIndex);

        //Seleccionamos el select de los reportes
        Select select = new Select(reportesMenu.findElement(By.id("s5")));
        select.selectByVisibleText("Download Reports");
        //Se debe generar el reporta aquí :)
    }

    @Test
    public void multiplesTabs(){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

        //Estando en la página de selección de reportes
        ChromeDriver driverMain = new ChromeDriver();
        driverMain.get("http://localhost/eCredisystem/cm6_a_Documentos.htm");

        WebElement fieldSet = driverMain.findElement(By.tagName("fieldset"));
        WebElement row = fieldSet.findElement(By.className("tbody"));
        WebElement td = row.findElements(By.tagName("td")).get(0);
        String link = td.findElement(By.tagName("a")).getAttribute("href");
        Assertions.assertNotEquals("", link);

        ChromeDriver tabDriver1 = new ChromeDriver();
        tabDriver1.get(link);

        ChromeDriver tabDriver2 = new ChromeDriver();
        tabDriver2.get(link);

        ChromeDriver tabDriver3 = new ChromeDriver();
        tabDriver3.get(link);
    }

    @Test
    public void multiplesTabsWithCtrl(){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

        //Estando en la página de selección de reportes
        ChromeDriver driverMain = new ChromeDriver();
        driverMain.get("http://localhost/eCredisystem/cm6_a_Documentos.htm");

        WebElement fieldSet = driverMain.findElement(By.tagName("fieldset"));
        WebElement row = fieldSet.findElement(By.className("tbody"));
        WebElement td = row.findElements(By.tagName("td")).get(0);
        WebElement linkElement = td.findElement(By.tagName("a"));

        int numeroTabs = 10;
        for (int i = 0; i < numeroTabs; i++){
            linkElement.sendKeys(Keys.CONTROL + "" + Keys.ENTER);
        }
    }
}
