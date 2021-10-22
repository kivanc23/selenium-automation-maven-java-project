import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(Test_Result_Logger.class)
public class BaseTest {

    WebDriver driver;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kivanc\\IdeaProjects\\web-selenium\\CromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Opening web browser
        driver.navigate().to("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().window().maximize();

    }
    @AfterAll
    public void downEngine(){
        driver.quit();
    }
}
