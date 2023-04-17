package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Форма заполнения данных об аренде самоката
public class RentPageObject {
    private final WebDriver driver;

    //поле "Когда привезти самокат"
    private final By date = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //выбранная дата в календаре
    private final By dateSelected = By.className("react-datepicker__day--selected");
    //поле "Срок аренды"
    private final By period = By.className("Dropdown-control");
    //поле "Комментарий для курьера"
    private final By comment = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //кнопка "Заказать"
    private final By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    //кнопка подтверждения заказа "Да"
    private final By yesButton = By.xpath("//button[text()='Да']");

    public RentPageObject(WebDriver driver) {
        this.driver = driver;
    }

    //метод установки даты аренды
    public void setDate(String value) {
        driver.findElement(date).sendKeys(value);
        driver.findElement(dateSelected).click();
    }

    //метод установки срока аренды
    public void setPeriod(String value) {
        driver.findElement(period).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-option' and text()='" + value + "']")).click();
    }

    //метод выбора цвета самоката
    public void setColour(String value) {
        driver.findElement(By.xpath("//label[text()='" + value + "']")).click();
    }

    //метод заполнения комментария
    public void setComment(String value) {
        driver.findElement(comment).sendKeys(value);
    }

    //метод нажатия на кнопку "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //метод нажатия на кнопку подтверждения заказа "Да"
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
}
