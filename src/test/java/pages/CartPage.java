package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

@Log4j2
public class CartPage {

    WebDriver driver;

    private static final By PLACE_BUTTON = By.cssSelector("button.btn.btn-success[data-target='#orderModal']");
    private static final By NAME_FIELD = By.id("name");
    private static final By CARD_FIELD = By.id("card");
    private static final By OK_BUTTON = By.cssSelector("button.btn.btn-primary[onclick='purchaseOrder()']");
    private static final By SUCCES_BUTTON = By.xpath("//button[text()='OK']");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Place order")
    public CartPage placeOrder() {
        log.info("Placing order");
        driver.findElement(PLACE_BUTTON).click();

        return this;
    }

    @Step("Fill order window")
    public CartPage fillOrderWindow(String name, String card) {
        log.info("Filling order window");
        driver.findElement(NAME_FIELD).sendKeys(name);
        driver.findElement(CARD_FIELD).sendKeys(card);
        driver.findElement(OK_BUTTON).click();

        return this;
    }

    @Step("Justify success order")
    public void justifySuccessOrder() {
        log.info("Checking if order success");
        driver.findElement(SUCCES_BUTTON).click();
        log.info("Successfully ordered a product!");
    }
}
