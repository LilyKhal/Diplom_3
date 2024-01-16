import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ForgotPasswordPage {

        private final WebDriver driver;
        public static final String FPASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
        private final By loginButton3 = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");


        WebElement findElement(By locator){
            return driver.findElement(locator);
        }
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(FPASSWORD_URL);
    }
    public void clickLoginButton3() {
        findElement(loginButton3).click();
    }
    }