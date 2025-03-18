import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage{
    private final By accountMenu = By.id("nav-link-accountList"); // "Hesap ve Listeler" butonu
    private final By searchBox = By.id("twotabsearchtextbox");  // Arama kutusunun ID'si
    private final By signInButton = By.xpath("//*[@class='nav-action-inner']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage hoverAndClickSignIn() {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(accountMenu)).perform(); // Mouse'u üzerine getir
        click(signInButton); // Açılan menüde "Giriş Yap" butonuna tıkla
        return new LoginPage(driver);
    }

    public SearchResultsPage searchProduct(String productName) {
        sendKeys(searchBox, productName + Keys.ENTER); // Ürün ismini yaz ve ENTER'a bas
        return new SearchResultsPage(driver);
    }
}
