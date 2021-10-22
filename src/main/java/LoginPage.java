import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By loginMailLocator = By.id("LoginEmail");
    By loginPasswordLocator = By.id("Password");
    By loginLink = By.id("loginLink");
    By myAccountLocator = By.cssSelector("#header__container > div > header > div.header-middle > div > div.header-left > a > img");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() throws InterruptedException {
        type(loginMailLocator, "kivancberke23@gmail.com");
        Thread.sleep(3000);
        type(loginPasswordLocator, "123456lcw");
        click(loginLink);
        Thread.sleep(3000);
    }

    public boolean isLoginSuccesful() {
        return isDisplayed(myAccountLocator);
    }
}
