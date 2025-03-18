import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    private final By addToCartButton = By.id("add-to-cart-button"); // "Sepete Ekle" butonu
    private final By productTitle = By.id("productTitle"); // Ürün adı
    private final By goToCartButton = By.xpath("//*[@class='a-button a-spacing-top-base a-button-span12 a-button-base celwidget']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(productTitle);
    }

    public CartPage addToCart() {
        click(addToCartButton);
        return new CartPage(driver);
    }

    public CartPage goToCart(){
        click(goToCartButton);
        return new CartPage(driver);
    }
}
