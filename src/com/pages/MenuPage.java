package src.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MenuPage {

    WebDriver driver;
    List<WebElement> menus;

    private int customersIndex = 0;
    private int supervisionIndex = 1;
    private int reportesIndex = 3;

    public MenuPage(WebDriver driver){
        this.driver = driver;
    }


    public void Entrar(){
        //Seleccionamos iframe
        WebDriverWait waitMenu = new WebDriverWait(driver, 240);
        WebElement frameMenu = waitMenu.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("frMenu"))));

        //Realizamos switcf
        driver.switchTo().frame(frameMenu);

        //Esperamos que sea visible la tabla de menús
        WebDriverWait wait = new WebDriverWait(driver, 240);
        WebElement form = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("frmjsMenuCO"))));

        //Cargamos temporalmente el menú
        WebElement menuContainer = form.findElement(By.className("esTableTrMenu"));
        menus = menuContainer.findElements(By.className("esTableTdMenu"));
    }

    public  void Salir(){
        this.driver.switchTo().parentFrame();
    }

    public void seleccionarMenuCustomer(String menu){
        WebElement menuElement = menus.get(customersIndex);
        selectMenu(menuElement, "s1", menu);
    }

    public void seleccionarMenuReports(String menu){
        WebElement menuElement = menus.get(reportesIndex);
        selectMenu(menuElement, "s5", menu);
    }

    public void seleccionarMenuSupervision(String menu){
        WebElement menuElement = menus.get(supervisionIndex);
        selectMenu(menuElement, "s3", menu);
    }

    private  void selectMenu(WebElement menuElement, String id, String menu){
        Select select = new Select(menuElement.findElement(By.id(id)));
        select.selectByVisibleText(menu);
    }
}
