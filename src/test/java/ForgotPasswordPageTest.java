import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModel.ForgotPasswordPage;
import pageObjectModel.LoginPage;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordPageTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void loginThroughLoginButton3Test() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.open();
        forgotPasswordPage.clickLoginButton3();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(LoginPage.LOGIN_URL));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
