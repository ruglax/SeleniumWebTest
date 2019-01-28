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

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost/thai/eCredisystem_archivos/jsMenuCO.htm");

        WebDriverWait wait = new WebDriverWait(driver, 240);
        WebElement form = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("frmjsMenuCO"))));
        //WebElement form = driver.findElement(By.id("frmjsMenuCO"));

        WebElement menuContainer = form.findElement(By.className("esTableTrMenu"));
        List<WebElement> menus = menuContainer.findElements(By.className("esTableTdMenu"));

        int reportesIndex = 3;
        WebElement reportesMenu = menus.get(reportesIndex);

        WebElement selectWebElement = reportesMenu.findElement(By.id("s5"));
        selectWebElement.click();

        List<WebElement> options = selectWebElement.findElements(By.tagName("option"));
        int opcionIndex = 3;
        options.get(opcionIndex).click();
    }
}
