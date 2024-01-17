package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage {
    private final WebDriver driver;
    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
   // private final By burgerIngredientsBlock = By.className("BurgerIngredients_ingredients__1N8v2");
    private final By personalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By loginToAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By createOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By bunsTab = By.xpath(".//span[text()='Булки']");
    private final By saucesTab = By.xpath(".//span[text()='Соусы']");
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']");
   // private final By bunsSection = By.xpath(".//h2[text()='Булки']");
   // private final By saucesSection = By.xpath(".//h2[text()='Соусы']");
   // private final By fillingsSection = By.xpath(".//h2[text()='Начинки']");





     WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(MAIN_URL);
    }

    public void clickPersonalCabinetButton() {
        findElement(personalCabinetButton).click();
    }
    public void clickLoginToAccountButton() {
        findElement(loginToAccountButton).click();
    }
    public void clickBunsTab() {
        findElement(bunsTab).click();
    }
    public void clickSaucesTab() {
        findElement(saucesTab).click();
    }
    public void clickFillingsTab() {
        findElement(fillingsTab).click();
    }

    public void waitForLoadFillingsSection() throws InterruptedException {
        Thread.sleep(1000);
    }
    public void waitForLoadSaucesSection() throws InterruptedException {
        Thread.sleep(1000);
    }
    public void waitForLoadBunsSection() throws InterruptedException {
        Thread.sleep(1000);
    }
    public  boolean  createOrderButtonIsDisplayed(){
         return findElement(createOrderButton).isDisplayed();
    }
}
