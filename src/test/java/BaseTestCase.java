import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTestCase {
    static WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","E:\\bin\\chromedriver_v92\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void initTest(){

    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
