import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage{

    By searchLocator = By.cssSelector("#search_input");
    By searchInputLocator = By.cssSelector("#search_input");
    By searchClick = By.cssSelector("#header__container > div > header > div.header-middle > div > div.header-center > div > div > div.searchContainer.active > div.box2 > button");
    By searchMore = By.cssSelector("#divModels > div:nth-child(10) > div > div.paging-process > a > p");
    By productItem = By.className("picture-box");
//    By allProductLocator = By.xpath("//*[@id='divModels']/div[7]/div/div[1]");
//    By tagLocator = By.tagName("a");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct() throws InterruptedException {
        click(searchLocator);
        type(searchInputLocator, "pantolan");
        Thread.sleep(1000);
        click(searchClick);
        Thread.sleep(3000);
    }

    public void dropdownProduct() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
    }


    public void searchMoreProduct() throws InterruptedException {
        Random r = new Random();
        int i = r.nextInt(30);

        click(searchMore);
        Thread.sleep(3000);

        getAllProducts().get(i).click();

        Thread.sleep(1000);
    }
    private List<WebElement> getAllProducts(){
        return findAll(productItem);
    }

}
