import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModel.LoginPage;
import pageObjectModel.MainPage;

import java.util.concurrent.TimeUnit;
public class MainPageTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void throughTheFillingsSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsTab();
        mainPage.waitForLoadFillingsSection();
    }
    @Test
    public void throughTheSaucesSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesTab();
        mainPage.waitForLoadSaucesSection();
    }
    @Test
    public void throughTheBunsSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        // на старте страницы секция Buns не кликабельна, поэтому необходимо сначала перейти на другую секцию
        mainPage.clickFillingsTab();
        mainPage.waitForLoadFillingsSection();
        mainPage.clickBunsTab();
        mainPage.waitForLoadBunsSection();
    }

    @Test
    public void loginThroughAccountButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginToAccountButton();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(LoginPage.LOGIN_URL));
    }
    @Test
    public void loginThroughPersonalCabinetButtonTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickPersonalCabinetButton();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe(LoginPage.LOGIN_URL));    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
