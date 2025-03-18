import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage{
    private final By productList = By.cssSelector(".s-title-instructions-style");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductListDisplayed() {
        return driver.findElements(productList).size() > 0;
    }

    public ProductPage selectFirstProduct() {
        click(productList);
        return new ProductPage(driver);
    }
    public String getFirstProductName() {
        return getText(productList); // İlk ürünün adını yazdır
    }
}
