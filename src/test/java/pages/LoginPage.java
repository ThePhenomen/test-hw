package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;
import tests.BasicTest;


@Log4j2
public class LoginPage {

    WebDriver driver;
    String url;

    private static final By LOGIN_PAGE = By.id("login2");
    private static final By LOGIN_FIELD = By.id("loginusername");
    private static final By PASSWD_FIELD = By.id("loginpassword");
    private static final By LOGIN_BUTTON = By.className("btn btn-primary");

    public LoginPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    @Step("Open initial page")
    public LoginPage open() {
        log.info("Opening initial page");
        driver.get(this.url);
        return this;
    }

    @Step("Open login page")
    public LoginPage openLogin() {
        log.info("Opening login page");
        driver.findElement(LOGIN_PAGE).click();
        return this;
    }

    @Step("Logging into account")
    public LoginPage loginPositive (String user, String password) {
        log.info("Logging into account");
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            log.info(alertText);
            alert.accept(); // Принимаем alert (нажимаем OK)
        } catch (NoAlertPresentException e) {
            // Если alert не появился, продолжаем выполнение
            log.info("No alert present");
        }

        return this;
    }
}
