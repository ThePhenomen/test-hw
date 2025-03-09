package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import org.openqa.selenium.WebElement;

@Log4j2
public class LoginPage {

    WebDriver driver;
    String url;

    private static final By LOGIN_PAGE = By.id("login2");
    private static final By LOGIN_FIELD = By.id("loginusername");
    private static final By PASSWD_FIELD = By.id("loginpassword");
    private static final By LOGIN_BUTTON = By.cssSelector("#logInModal > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)");

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

    @Step("Logging positive into account")
    public LoginPage loginPositive (String user, String password) {
        log.info("Logging into account");
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

        return this;
    }

    @Step("Logging negative into account with wrong passwd")
    public LoginPage loginNegativeWithWrongPasswd (String user, String password) {
        log.info("Logging into account");
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        log.info(alertText);
        alert.accept();

        return this;
    }

    @Step("Choosing product")
    public ProductPage pickProduct (String elemCounter) {
        log.info("Choosing product");
        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By linkLocator = By.xpath(String.format("//a[@href='prod.html?idp_=%s']", elemCounter));

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(linkLocator));
        link.click();

        return new ProductPage(driver);
    }

}
