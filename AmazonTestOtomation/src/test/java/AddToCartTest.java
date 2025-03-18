import org.junit.jupiter.api.Test;

public class AddToCartTest extends BaseTest{
    private final String testEmail = "testintellijidea1@gmail.com"; // Gerçek bir hesap girilmeli
    private final String testPassword = "testintellijideaQA1"; // Gerçek şifre girilmeli

    @Test
    public void testAddToCart() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        waitForPageLoad();

        // Giriş Yap
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.hoverAndClickSignIn();
        loginPage.enterEmail(testEmail);
        loginPage.enterPasswordAndLogin(testPassword);

        // Ürün Ara
        SearchResultsPage searchResultsPage = homePage.searchProduct("laptop");
        assert searchResultsPage.isProductListDisplayed() : "Ürün listesi boş!";

        // İlk Ürünü Seç
        ProductPage productPage = searchResultsPage.selectFirstProduct();
        String productName = productPage.getProductName().trim(); // Ürünün adını boşluklardan temizle

        // Normalize ederek karşılaştırmayı daha güvenli hale getiriyoruz
        productName = productName.replaceAll("[^\\p{L}\\p{N} ]", "").replaceAll("\\s+", " ").trim();

        // Sepete Ekle ve Sepete Git
        productPage.addToCart();
        CartPage cartPage = productPage.goToCart(); // "Sepete Git" butonuna tıkla

        // Sepete Gidip Ürünün Eklendiğini Kontrol Et
        boolean isInCart = cartPage.isProductInCart(productName);

        if (isInCart) {
            System.out.println("TEST BAŞARILI: Ürün sepete başarıyla eklendi.");
        } else {
            System.out.println("TEST BAŞARISIZ: Ürün sepete eklenmedi!");
        }
    }
}
