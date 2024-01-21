package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    private final WebDriver driver;
    private final By emailField = By.cssSelector(".input_type_text > input:nth-child(2)");

    private final By passwordField = By.cssSelector(".input_type_password > input:nth-child(2)");
    private final By loginButton = By.xpath("//button[text()='Войти']");

    WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(LOGIN_URL);
    }

    public void setEmailField(String email){
        findElement(emailField).sendKeys(email);
    }
    public void setPasswordField(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton() {
        findElement(loginButton).click();
    }
}
