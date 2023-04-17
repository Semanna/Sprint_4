package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Главная страница
public class MainPageObject {
    private final WebDriver driver;
    //кнопка "Заказать" вверху страницы
    private final By topOrderButton = By.xpath("//div[@class='Header_Nav__AGCXC']//button[text()='Заказать']");
    //кнопка "Заказать" внизу страницы
    private final By bottomOrderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");
    //кнопка закрытия Cookie
    private final By cookieButton = By.xpath("//button[@class='App_CookieButton__3cvqF']");

    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    //метод раскрытия элементов списка в "Вопросах о важном"
    public void clickAccordionButton(String title) {
        By accordionButton = By.xpath("//div[@class='accordion__button' and text()='" + title + "']");
        driver.findElement(accordionButton).click();
    }

    //метод получения текста из раскрытого элемента в "Вопросах о важном"
    public String getAccordionPanelText(String title) {
        By accordionButton = By.xpath("//div[@class='accordion__button' and text()='" + title + "']/parent::div/parent::div/div[@class='accordion__panel']");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accordionButton)).getText();
    }

    //метод нажати на кнопку "Заказать" вверху страницы
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    //метод нажати на кнопку "Заказать" внизу страницы
    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    //метод закрытия Cookie
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieButton));
    }
}
