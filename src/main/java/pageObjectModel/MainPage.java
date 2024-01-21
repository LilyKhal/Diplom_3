package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    private final By personalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By loginToAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By bunsTab = By.cssSelector("div.tab_tab__1SPyG:nth-child(1)");
    private final By saucesTab = By.cssSelector("div.tab_tab__1SPyG:nth-child(2)");
    private final By fillingsTab = By.cssSelector("div.tab_tab__1SPyG:nth-child(3)");

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

    public void waitForLoadFillingsSection() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeContains(findElement(fillingsTab), "class", "current"));
    }
    public void waitForLoadSaucesSection()  {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeContains(findElement(saucesTab), "class", "current"));
    }
    public void waitForLoadBunsSection()  {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeContains(findElement(bunsTab), "class", "current"));
    }
}
