import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;
    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    private final By burgerIngredientsBlock = By.className("BurgerIngredients_ingredients__1N8v2");
    private final By personalCabinetButton = By.className("AppHeader_header__link__3D_hX");
    private final By loginToAccountButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg");

    private final By bunsTab = By.xpath(".//span[text()='Булки']");
    private final By saucesTab = By.xpath(".//span[text()='Соусы']");
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']");
    private final By bunsSection = By.xpath(".//h2[text()='Булки']");
    private final By saucesSection = By.xpath(".//h2[text()='Соусы']");
    private final By fillingsSection = By.xpath(".//h2[text()='Начинки']");





    private WebElement findElement(By locator) {
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
    public void scrollToBunsSection(){
        WebElement element = findElement(bunsSection);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
//    public void scrollToSaucesSection(){
//        WebElement element = findElement(saucesSection);
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
//    public void scrollToFillingsSection(){
//        WebElement element = findElement(fillingsSection);
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
}
