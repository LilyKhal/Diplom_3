import api.User;
import api.UserClient;
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
import pageObjectModel.PersonalPage;
import utils.Utils;
import java.util.concurrent.TimeUnit;
import static utils.Utils.randomString;

public class PersonalPageTest {
    private WebDriver driver;
    MainPage mainPage;
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

        mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickLoginButton();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(MainPage.MAIN_URL));
    }
    @Test
    public void openPersonalPageTest() {
        mainPage.clickPersonalCabinetButton();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(PersonalPage.PERSONAL_URL));
    }

    @Test
    public void constructorButtonOnPersonalPageTest(){
        PersonalPage personalPage= new PersonalPage(driver);
        mainPage.clickPersonalCabinetButton();
        personalPage.clickConstructorButton();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(MainPage.MAIN_URL));    }
    @Test
    public void bannerButtonOnPersonalPageTest(){
        PersonalPage personalPage= new PersonalPage(driver);
        mainPage.clickPersonalCabinetButton();
        personalPage.clickBannerButton();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(MainPage.MAIN_URL));
    }
    @Test
    public void logoutButtonOnPersonalPageTest(){
        PersonalPage personalPage= new PersonalPage(driver);
        mainPage.clickPersonalCabinetButton();
        personalPage.clickLogoutButton();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(LoginPage.LOGIN_URL));
    }

    @After
    public void tearDown(){
        driver.quit();
        userClient.delete(token);
    }
}
