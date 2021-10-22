import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Opening_Main_Page extends BaseTest{

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductsDetailPage productsDetailPage;
    PaymentPage paymentPage;
    @Test
    @Order(1)
    public void home_page() throws InterruptedException {
        homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isOnHomePage() , "Not on home page");
        homePage.toLogin();
    }

    @Test
    @Order(2)
    //@Disabled("Disabled because of bug...")
    public void login_page() throws InterruptedException {
        loginPage= new LoginPage(driver);
        loginPage.login();
        Assertions.assertTrue(loginPage.isLoginSuccesful(), "Login was not succesfull!");
    }
    @Test
    @Order(3)
    public void product_page() throws InterruptedException {
        productsPage= new ProductsPage(driver);
        productsPage.searchProduct();
        productsPage.dropdownProduct();
        productsPage.searchMoreProduct();
    }
    @Test
    @Order(4)
    public void product_detail_page() throws InterruptedException {
        productsDetailPage= new ProductsDetailPage(driver);
        productsDetailPage.buyProduct();
        productsDetailPage.addToChart();
    }

    @Test
    @Order(5)
    public void payment_page() throws InterruptedException {
        paymentPage = new PaymentPage(driver);
        Assertions.assertTrue(paymentPage.checkTheValues(), "The product values are not same!");
        paymentPage.increaseProduct();
        Assertions.assertTrue(paymentPage.isProductCountUp(), "Product count did not increase!");
        paymentPage.deleteProduct();
        Assertions.assertTrue(paymentPage.isCartEmpty(), "Cart is empty!");
    }

}
