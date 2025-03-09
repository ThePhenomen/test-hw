package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@Log4j2
public class ProductPage {

    WebDriver driver;

    private static final By ADD_BUTTON  = By.xpath("//a[@class='btn btn-success btn-lg' and contains(@onclick, 'addToCart(1)')]");
    private static final By CART_PAGE = By.id("cartur");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Add product to shopping cart")
    public ProductPage addToCart() {
        log.info("Adding product to shopping cart");
        driver.findElement(ADD_BUTTON).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        log.info(alertText);
        alert.accept();
        return this;
    }

    @Step("Open cart page")
    public CartPage openCart() {
        log.info("Opening cart page");
        driver.findElement(CART_PAGE).click();

        return new CartPage(driver);
    }
}
