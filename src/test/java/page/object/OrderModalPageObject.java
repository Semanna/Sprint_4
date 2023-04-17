package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//всплывающее окно подтверждения заказа
public class OrderModalPageObject {
    private final WebDriver driver;

    //заголовок с подтверждением заказа
    private final By header = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderModalPageObject(WebDriver driver) {
        this.driver = driver;
    }

    //метод получения текста из заголовка окна подтверждения заказа
    public String getHeader() {
        return driver.findElement(header).getText();
    }
}
