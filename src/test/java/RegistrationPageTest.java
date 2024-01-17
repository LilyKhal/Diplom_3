import api.UserClient;
import api.UserCred;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModel.LoginPage;
import pageObjectModel.MainPage;
import pageObjectModel.RegistrationPage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import static utils.Utils.randomString;

public class RegistrationPageTest {
    private WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        RestAssured.baseURI = MainPage.MAIN_URL;
    }

    @Test
    public void shortPasswordTest(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.setNameField("Genry");
        registrationPage.setEmailField("testUser@mail.ru");
        registrationPage.setPasswordField("2300");
        registrationPage.clickRegistrationButton();
        assertTrue(registrationPage.incorrectPasswordNotificationIsDisplayed());
    }
    @Test
    public void registrationTest() {
        RegistrationPage registrationPage= new RegistrationPage(driver);
        registrationPage.open();

        String name = randomString(7);
        registrationPage.setNameField(name);
        String email = String.format("%s@yandex.ru",randomString(8));
        registrationPage.setEmailField(email);
        String password = randomString(11);
        registrationPage.setPasswordField(password);
        registrationPage.clickRegistrationButton();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(LoginPage.LOGIN_URL));

        UserClient userClient = new UserClient();
        Response response = userClient.login(new UserCred(email, password));
        assertEquals(200, response.statusCode());
        assertEquals(true, response.path("success"));

        String accessToken = response.path("accessToken");
        userClient.delete(accessToken);
    }
    @Test
    public void loginButtonOnRegistrationPageTest(){
        RegistrationPage registrationPage= new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.clickLoginButton();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(LoginPage.LOGIN_URL));

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
