import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTestCase {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static Properties config = new Properties();
    public static FileInputStream fis;
    public static String browser;
    public static long timeout;


    @BeforeTest
    public void setup() {
        if (driver == null) {

            try {
                fis = new FileInputStream("src//test//resources//config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
                System.out.println("Config properties loaded!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            browser = config.getProperty("browser");
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", config.getProperty("chromedriver_path"));
                driver = new ChromeDriver();
                System.out.println("Chrome driver initialized!");
            } else if (browser.equalsIgnoreCase("firefox")) {

            } else if (browser.equalsIgnoreCase("ie")) {

            }

            timeout = Long.parseLong(config.getProperty("timeouts"));
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            webDriverWait = new WebDriverWait(driver, 30);
            driver.get(config.getProperty("test_url"));
        }


    }

    public boolean isElementPresent(By locator){
        try{
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.findElement(locator);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean click(By locator){
        try{
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.findElement(locator).click();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void enterText(By locator, String value){
        try{
            driver.findElement(locator).sendKeys(value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void dropdownSelectByValue(By locator, String value){
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }
    public void selectByValue(By locator, String value){
        click(locator);
       driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
    }




    @AfterTest
    public void teardown(){
        if(driver != null)
            driver.quit();
    }
}
