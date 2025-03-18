import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest{
    private final String testEmail = "testintellijidea1@gmail.com"; // Gerçek bir hesap girilmeli
    private final String testPassword = "test123123"; // Bilerek yanlış şifre giriyoruz

    @Test
    public void testUserLogin() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        waitForPageLoad(); // Sayfanın tamamen yüklenmesini bekle

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.hoverAndClickSignIn(); // Mouse hover ile giriş yap butonuna bas

        loginPage.enterEmail(testEmail);
        loginPage.enterPasswordAndLogin(testPassword);

        if (loginPage.isLoginSuccessful()) {
            System.out.println("Giriş Başarılı!");
        } else {
            System.out.println("Giriş Başarısız! (Yanlış e-posta veya şifre)");
        }
    }
}
