package src.com.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import src.com.pages.MenuPage;

public class MenuTest {

    MenuPage menuPage;

    @BeforeAll
    public static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost/thai/eCredisystem.htm");

        this.menuPage = new MenuPage(driver);
        this.menuPage.Entrar();
    }

    @AfterEach public void afterEach(){
        this.menuPage.Salir();
    }

    @Test
    public  void ReporteMenuTest(){
        this.menuPage.seleccionarMenuReports("Download Reports");
    }


}
