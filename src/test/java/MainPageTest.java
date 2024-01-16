import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPageTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void throughTheSectionsTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        mainPage.clickFillingsTab();
        mainPage.waitForLoadFillingsSection();
        mainPage.clickSaucesTab();
        mainPage.waitForLoadSaucesSection();
        mainPage.clickBunsTab();
        mainPage.waitForLoadBunsSection();
    }

    @Test
    public void loginThroughAccountButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginToAccountButton();
        assertEquals(driver.getCurrentUrl(), LoginPage.LOGIN_URL);
    }
    @Test
    public void loginThroughPersonalCabinetButton(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickPersonalCabinetButton();
        assertEquals(driver.getCurrentUrl(), LoginPage.LOGIN_URL);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
