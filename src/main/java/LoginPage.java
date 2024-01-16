import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    private final WebDriver driver;
    private final By emailField2 = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private final By passwordField2 = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private final By loginButton2 = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private final By registrationButton2 = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");
    private final By resetPasswordButton = By.cssSelector("#root > div > main > div > div > p:nth-child(2) > a");



      WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(LOGIN_URL);
    }

    public void setEmailField2(String email){
        findElement(emailField2).sendKeys(email);
    }
    public void setPasswordField2(String password){
        findElement(passwordField2).sendKeys(password);
    }
    public void clickLoginButton2() {
        findElement(loginButton2).click();
    }
    public void clickRegistrationButton2() {
        findElement(registrationButton2).click();
    }
    public void clickResetPasswordButton() {
        findElement(resetPasswordButton).click();
    }
}
