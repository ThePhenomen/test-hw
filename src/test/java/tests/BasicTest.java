package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import pages.*;

public class BasicTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setupBrauser() {

        //WebDriverManager.edgedriver().setup();
        //WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        //options.addArguments("--edge-skip-compat-layer-relaunch");
        //options.addArguments("--user-data-dir=C:\\temp\\edge-user-data-" + System.currentTimeMillis());
        //options.addArguments("--disable-notification");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, "https://www.demoblaze.com/#");
    }

    @AfterMethod
    public void quitBrauser() {
        driver.quit();
    }

}
