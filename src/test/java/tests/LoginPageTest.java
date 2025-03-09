package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import dto.*;

@Log4j2
public class LoginPageTest extends BasicTest {

    /*
    Пользователь для положительного логина
     */

    BasicUser positiveUser = BasicUser.builder()
            .login("test")
            .password("test")
            .build();

    /*
    Пользователь для негативного логина
     */

    BasicUser negativeUser = BasicUser.builder()
            .login("test")
            .password("123")
            .build();

    /*
    1. Открыть страницу https://www.demoblaze.com/#
    2. Открыть поле логина
    3. Ввести в поле username значение test
    4. Ввести в поле password значение test
    5. Нажать кнопку Login
     */

    @Test
    public void checkPositiveLogin() {
        loginPage.open()
                .openLogin()
                .loginPositive(positiveUser.getLogin(), positiveUser.getPassword());
    }

    /*
    1. Открыть страницу https://www.demoblaze.com/#
    2. Открыть поле логина
    3. Ввести в поле username значение test
    4. Ввести в поле password значение test
    5. Нажать кнопку Login
    6. Проверить, что открывается окно браузера с предупреждением о том, что пароль неверный
     */

    @Test
    public void checkNegativeLogin() {
        loginPage.open().
                openLogin().
                loginNegativeWithWrongPasswd(negativeUser.getLogin(), negativeUser.getPassword());
    }

}
