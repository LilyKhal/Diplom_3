import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
     WebDriver driver;
    public static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";

    private final By nameField = By.cssSelector("#root > div > main > div > form > fieldset:nth-child(1) > div > div > input");
    private final By emailField = By.cssSelector("#root > div > main > div > form > fieldset:nth-child(2) > div > div > input");
    private final By passwordField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");
    private final By registrationButton = By. cssSelector("#root > div > main > div > form > button");
    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");
    private final By incorrectPasswordNotification = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");



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
