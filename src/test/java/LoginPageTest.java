import api.User;
import api.UserClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Utils.randomString;

public class LoginPageTest {
    private WebDriver driver;
     private User user;
     private UserClient userClient;
     private String token;
    @Before
    public void setUp(){
        RestAssured.baseURI = MainPage.MAIN_URL;
        user = new User(String.format("%s@yandex.ru",randomString(8)), Utils.randomString(9), Utils.randomString(11));
        userClient = new UserClient();
        Response createResponse = userClient.create(user);
        token = createResponse.path("accessToken");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void LoginPageTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setEmailField2(user.getEmail());
        loginPage.setPasswordField2(user.getPassword());
        loginPage.clickLoginButton2();
        assertEquals(driver.getCurrentUrl(),MainPage.MAIN_URL);
    }
    @After
    public void tearDown(){
        driver.quit();
        userClient.delete(token);
    }
}
