package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Форма заполнения персональных данных арендатора
public class PersonalInfoPageObject {
    private final WebDriver driver;

    //поле "Имя"
    private final By firstName = By.xpath("//input[@placeholder='* Имя']");
    //поле "Фамилия"
    private final By secondName = By.xpath("//input[@placeholder='* Фамилия']");
    //поле "Адрес"
    private final By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле "Телефон"
    private final By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //поле "Станция метро"
    private final By station = By.xpath("//input[@placeholder='* Станция метро']");
    //кнопка "Далее"
    private final By nextButton = By.xpath("//button[text()='Далее']");


    public PersonalInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    //метод заполнения поля "Имя"
    public void setFirstName(String value) {
        WebElement element = driver.findElement(firstName);
        element.sendKeys(value);
    }

    //метод заполнения поля "Фамилия"
    public void setSecondName(String value) {
        WebElement element = driver.findElement(secondName);
        element.sendKeys(value);
    }

    //метод заполнения поля "Адрес"
    public void setAddress(String value) {
        WebElement element = driver.findElement(address);
        element.sendKeys(value);
    }

    //метод заполнения поля "Телефон"
    public void setPhone(String value) {
        WebElement element = driver.findElement(phone);
        element.sendKeys(value);
    }

    //метод заполнения поля "Станция метро"
    public void setStation(String value) {
        WebElement element = driver.findElement(station);
        element.sendKeys(value);
        driver.findElement(By.xpath("//div[text()='" + value + "']")).click();
    }

    //метод нажатия на кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}
