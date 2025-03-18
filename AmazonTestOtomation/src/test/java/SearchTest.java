import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest{
    private final String testEmail = "testintellijidea1@gmail.com"; // Gerçek bir hesap girilmeli
    private final String testPassword = "testintellijideaQA1"; // Gerçek şifre girilmeli

    @Test
    public void testAddToCart() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        waitForPageLoad();

        // Çerezleri kabul et
        //driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchProduct("laptop");

        assertTrue(searchResultsPage.isProductListDisplayed(), "Ürün listesi boş!");
        System.out.println("İlk Ürün: " + searchResultsPage.getFirstProductName());
    }
}
