package src.com.sitio;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreditoTest {

    @Test
    public void selectMenu() {

        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

        //Estando en la página de selección de reportes
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost/thai/eCredisystem.htm");

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
        WebElement selectWebElement = reportesMenu.findElement(By.id("s5"));
        selectWebElement.click();

        //Seleccioamos el tercer reporte de la lista desplegable
        List<WebElement> options = selectWebElement.findElements(By.tagName("option"));
        int opcionIndex = 3;
        options.get(opcionIndex).click();
    }
}
