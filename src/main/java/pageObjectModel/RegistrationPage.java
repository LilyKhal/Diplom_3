package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
     WebDriver driver;
    public static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";

    private final By nameField = By.cssSelector("fieldset.Auth_fieldset__1QzWN:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)");

    private final By emailField = By.cssSelector("fieldset.Auth_fieldset__1QzWN:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)");
    private final By passwordField = By.cssSelector(".input_type_password > input:nth-child(2)");

    private final By registrationButton = By. cssSelector(".button_button__33qZ0");

    private final By loginButton = By.cssSelector(".Auth_link__1fOlj");
    private final By incorrectPasswordNotification = By.cssSelector(".input__error");



    WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(REGISTRATION_URL);
    }
    public void setNameField(String name) {
        findElement(nameField).sendKeys(name);
    }
    public void setEmailField(String email){
        findElement(emailField).sendKeys(email);
    }
    public void setPasswordField(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickRegistrationButton() {
        findElement(registrationButton).click();
    }
    public void clickLoginButton() {
        findElement(loginButton).click();
    }
    public boolean incorrectPasswordNotificationIsDisplayed(){
        return findElement(incorrectPasswordNotification).isDisplayed();
    }
}
