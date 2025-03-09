package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import dto.*;

@Log4j2
public class E2eTest extends BasicTest {

    /*
    Пользователь
     */

    BasicUser user = BasicUser.builder()
            .login("test")
            .password("test")
            .creditCard("123")
            .build();

    /*
    1. Открыть страницу https://www.demoblaze.com/#
    2. Открыть поле логина
    3. Ввести в поле username значение test
    4. Ввести в поле password значение test
    5. Нажать кнопку Login
    6. Нажать на товар
    7. Добавить его в корзину
    8. Перейти в корзину
    9. Нажать кнопку place order
    10. Ввести в поле name значение test
    11. Ввести в поле card значение 123
    12. Нажать кнопку ok
    13. Проверить, что мы видим окно с подтверждением об успешном заказе
     */

    @Test
    public void createOrder() {
        loginPage.open()
                .openLogin()
                .loginPositive(user.getLogin(), user.getPassword())
                .pickProduct("1")
                .addToCart()
                .openCart()
                .placeOrder()
                .fillOrderWindow("test", "123")
                .justifySuccessOrder();
    }

}