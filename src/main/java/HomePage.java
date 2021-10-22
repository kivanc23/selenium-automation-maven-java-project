import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage{
    String tagname = "";

    //By loginLocator = By.cssSelector("#header__container > div > div.mh__middle > div > div.main__right > div > div:nth-child(1) > a > span");
    By dropdownLoginLocator = By.cssSelector("#header__container > div > header > div.header-middle > div > div.header-right > div:nth-child(2) > div:nth-child(1) > a > svg");
    By signInLocator = By.cssSelector("#header__container > div > header > div.header-middle > div > div.header-right > div:nth-child(2) > div:nth-child(1) > a > svg");
    By logoLocator = By.cssSelector("#header__container > div > header > div.header-middle > div > div.header-left > a > img");
    By loginLocator = By.linkText("Giriş Yap");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void toLogin() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(find(dropdownLoginLocator));
        Thread.sleep(2000);

        action.moveToElement(find(signInLocator));
        action.click();
        action.perform();
        Thread.sleep(3000);

        click(loginLocator);
    }

    public boolean isOnHomePage() {
        return isDisplayed(logoLocator);
    }
}
