import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private final By emailField = By.id("ap_email"); // E-posta giriş kutusu
    private final By continueButton = By.id("continue"); // Devam Et butonu
    private final By passwordField = By.id("ap_password"); // Şifre giriş kutusu
    private final By signInButton = By.id("signInSubmit"); // Giriş Yap butonu
    private final By accountText = By.id("nav-link-accountList-nav-line-1"); // Giriş sonrası kontrol

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
        click(continueButton);
    }

    public void enterPasswordAndLogin(String password) {
        sendKeys(passwordField, password);
        click(signInButton);
    }

    public boolean isLoginSuccessful() {
        try {
            return getText(accountText).contains("Hesabım") || !getText(accountText).isEmpty(); // Hesap bilgisi yazıyorsa giriş başarılıdır
        } catch (Exception e) {
            return false; // Eğer element bulunamazsa giriş başarısız kabul edilir
        }
    }
}
