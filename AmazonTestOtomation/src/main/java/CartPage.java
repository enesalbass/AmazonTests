import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    private final By cartItem = By.xpath("//span[contains(@class, 'sc-product-title')]"); // Sepetteki ürün başlığı
    private final By cartPageLoaded = By.id("sc-active-cart"); // Sepet sayfasının yüklendiğini gösteren element

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductInCart(String expectedProductName) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageLoaded)); // Sepet tamamen yüklenene kadar bekle
            String actualProductName = getText(cartItem).trim(); // Sepetteki ürün adını al ve boşlukları temizle
            expectedProductName = expectedProductName.trim(); // Beklenen ürün adını da temizle

            // Özel karakterleri ve fazla boşlukları kaldırarak normalize et
            actualProductName = actualProductName.replaceAll("[^\\p{L}\\p{N} ]", "").replaceAll("\\s+", " ").trim();
            expectedProductName = expectedProductName.replaceAll("[^\\p{L}\\p{N} ]", "").replaceAll("\\s+", " ").trim();

            System.out.println("Beklenen ürün: " + expectedProductName);
            System.out.println("Sepette bulunan ürün: " + actualProductName);

            // Eğer Amazon ürünü kısaltmışsa, sepette görünen kısmı kontrol et
            if (expectedProductName.startsWith(actualProductName)) {
                System.out.println("Ürün başarıyla sepete eklendi!");
                return true;
            } else {
                System.out.println("Sepette ürün var ancak beklenenle eşleşmiyor!");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Sepet sayfası yüklenemedi veya ürün bulunamadı.");
            return false;
        }
    }
}
