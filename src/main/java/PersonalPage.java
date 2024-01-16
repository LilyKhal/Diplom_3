import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalPage {
    WebDriver driver;
    public static final String PERSONAL_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By constructorButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");

    private final By logoutButton = By.xpath("#root > div > main > div > nav > ul > li:nth-child(3) > button");


    WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public PersonalPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(PERSONAL_URL);
    }
    public void clickConstructorButton() {
        findElement(constructorButton).click();
    }
    public void clickLogoutButton() {
        findElement(logoutButton).click();
    }


}
