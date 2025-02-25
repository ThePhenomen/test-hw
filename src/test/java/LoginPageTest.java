import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.time.Duration;

public class LoginPageTest {
    /*
    1.Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение test
    3. Ввести в поле password значение test
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
      Epic sadface: Username and password do not match any user in this service
     */

    @Test
    public void checkNegativeWrongLoginWrongPassword() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");

        driver.quit();
    }

    /*
    1.Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение ""
    3. Ввести в поле password значение ""
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
      Epic sadface: Username is required
     */

    @Test
    public void checkNegativeLoginNoCreds() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");

        driver.quit();
    }
}
