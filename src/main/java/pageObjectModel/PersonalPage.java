package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalPage {
    WebDriver driver;
    public static final String PERSONAL_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By constructorButton = By.cssSelector(".AppHeader_header__list__3oKJj > li:nth-child(1) > a:nth-child(1)");
    private final By logoutButton = By.cssSelector(".Account_button__14Yp3");
    private final By bannerButton = By.cssSelector(".AppHeader_header__logo__2D0X2");

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
    public void clickBannerButton(){
        findElement(bannerButton).click();
    }

}
