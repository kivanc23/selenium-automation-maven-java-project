import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsDetailPage extends BasePage{
    By bodyLocator = By.xpath("//*[@id='option-size']");
    By addChartLocator = By.xpath("//*[@id='rightInfoBar']/div[1]/div/div[4]/div[3]/div/div/div/div[2]");
    By goToChartLocator = By.xpath("/html/body/div[5]/div[2]/div[1]/div[4]/div/div[4]/a/div");
    public ProductsDetailPage(WebDriver driver) {
        super(driver);
    }

    public void buyProduct() throws InterruptedException {
        List<WebElement> l2 = find(bodyLocator).findElements(By.tagName("a"));

        l2.get(2).click();
        Thread.sleep(1000);
    }
    public void addToChart() throws InterruptedException {
        click(addChartLocator);
        Thread.sleep(2000);
        click(goToChartLocator);
        Thread.sleep(1000);

    }
}
