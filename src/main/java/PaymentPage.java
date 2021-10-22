import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{

    By quantitiyLocator = By.linkText("+");
    By cartCountLocator = By.id("spanCart");
    By deleteProductLocator = By.xpath("//a[@title='Sil']");
    By cartDelete = By.linkText("Sil");
    By cartEmpty = By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div > div");
    By shoppingCartContent = By.xpath("//*[@id='ShoppingCartContent']/div[1]/div[2]/div[1]/div[5]/div/span[2]");
    By productPrice = By.className("rd-cart-item-price");
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void increaseProduct() throws InterruptedException {



        click(quantitiyLocator);
        Thread.sleep(1000);
    }
    public boolean checkTheValues(){
        String price = find(shoppingCartContent).getText();
        String value2 = find(productPrice).getText();
        if (price.equals(value2)){
            return true;
        }
        else {
            return false;
        }

    }
    public void deleteProduct() throws InterruptedException {
        if (isProductCountUp() == true){
            click(deleteProductLocator);
            click(cartDelete);
            Thread.sleep(1000);
        }
    }
    public boolean isProductCountUp() {
        if (getCartCount() > 1){
            return true;
        }
        else {
            return false;
        }
    }

    private int getCartCount(){
        try {
            String count = find(cartCountLocator).getText();
            return Integer.parseInt(count);
        }catch (Exception ex){
            return 0;
        }

    }
    public boolean isCartEmpty(){
        return isDisplayed(cartEmpty);
    }
}
