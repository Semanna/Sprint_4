import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.object.MainPageObject;
import page.object.OrderModalPageObject;
import page.object.PersonalInfoPageObject;
import page.object.RentPageObject;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScooterOrderTest {
    private WebDriver driver;

    //тестовые данные для аренды самоката
    private static Stream<Arguments> provideOrders() {
        return Stream.of(
                Arguments.of("Вася", "Иванов", "Нью-Йорк", "+79995643434", "Савёловская", "24.06.2023", "сутки", "чёрный жемчуг", "Не звонить"),
                Arguments.of("Маруся", "Рыкова", "Москва", "+79991112222", "Митино", "04.09.2023", "двое суток", "серая безысходность", "Не стучать")
        );
    }

    public void initDriver() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
    }
    //тест заказа самоката по нажатию верхней кнопки "Заказать"
    @ParameterizedTest
    @MethodSource("provideOrders")
    public void shouldOrderScooterTopButtonClick(
            String firstName,
            String secondName,
            String address,
            String phone,
            String station,
            String date,
            String period,
            String colour,
            String comment) {
        initDriver();

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //закрытие Cookie и нажатие верхней кнопки "Заказать"
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickCookieButton();
        mainPageObject.clickTopOrderButton();

        //заполнение полей формы персональных данных арендатора
        PersonalInfoPageObject personalInfoPageObject = new PersonalInfoPageObject(driver);
        personalInfoPageObject.setFirstName(firstName);
        personalInfoPageObject.setSecondName(secondName);
        personalInfoPageObject.setAddress(address);
        personalInfoPageObject.setPhone(phone);
        personalInfoPageObject.setStation(station);
        personalInfoPageObject.clickNextButton();

        //заполнение полей формы аренды самоката
        RentPageObject rentPageObject = new RentPageObject(driver);
        rentPageObject.setDate(date);
        rentPageObject.setPeriod(period);
        rentPageObject.setColour(colour);
        rentPageObject.setComment(comment);
        rentPageObject.clickOrderButton();
        rentPageObject.clickYesButton();

        //проверка, что появилось всплывающее окно с сообщением об успешном создании заказа
        OrderModalPageObject orderModalPageObject = new OrderModalPageObject(driver);
        assertTrue(orderModalPageObject.getHeader().contains("Заказ оформлен"));
    }

    //тест заказа самоката по нажатию нижней кнопки "Заказать"
    @ParameterizedTest
    @MethodSource("provideOrders")
    public void shouldOrderScooterWhenBottomButtonClick(
            String firstName,
            String secondName,
            String address,
            String phone,
            String station,
            String date,
            String period,
            String colour,
            String comment) {
        initDriver();

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //закрытие Cookie и нажатие нижней кнопки "Заказать"
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickCookieButton();
        mainPageObject.clickBottomOrderButton();

        //заполнение полей формы персональных данных арендатора
        PersonalInfoPageObject personalInfoPageObject = new PersonalInfoPageObject(driver);
        personalInfoPageObject.setFirstName(firstName);
        personalInfoPageObject.setSecondName(secondName);
        personalInfoPageObject.setAddress(address);
        personalInfoPageObject.setPhone(phone);
        personalInfoPageObject.setStation(station);
        personalInfoPageObject.clickNextButton();

        //заполнение полей формы аренды самоката
        RentPageObject rentPageObject = new RentPageObject(driver);
        rentPageObject.setDate(date);
        rentPageObject.setPeriod(period);
        rentPageObject.setColour(colour);
        rentPageObject.setComment(comment);
        rentPageObject.clickOrderButton();
        rentPageObject.clickYesButton();

        //проверка, что появилось всплывающее окно с сообщением об успешном создании заказа
        OrderModalPageObject orderModalPageObject = new OrderModalPageObject(driver);
        assertTrue(orderModalPageObject.getHeader().contains("Заказ оформлен"));
    }

    @AfterEach
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
