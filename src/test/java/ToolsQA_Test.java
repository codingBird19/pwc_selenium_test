import org.openqa.selenium.JavascriptExecutor;
import pageElements.ToolsqaFormPage_Elements;
import utils.ExcelUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ToolsQA_Test extends BaseTestCase{

    @Override
    public void initTest()  {
        driver.get("https://demoqa.com/automation-practice-form/");
        String testdata_path = "src//test//resources//TestData.xlsx";
        Map<String, String> testdata = ExcelUtils.readData(testdata_path, "FormData");
        System.out.println(testdata);
        driver.findElement(ToolsqaFormPage_Elements.fnameField).sendKeys(testdata.get("FirstName"));
        driver.findElement(ToolsqaFormPage_Elements.lnameField).sendKeys(testdata.get("LastName"));
        driver.findElement(ToolsqaFormPage_Elements.email).sendKeys(testdata.get("Email"));
        driver.findElement(ToolsqaFormPage_Elements.mobile).sendKeys(testdata.get("Mobile"));
        driver.findElement(ToolsqaFormPage_Elements.gender_f).click();
        driver.findElement(ToolsqaFormPage_Elements.address).sendKeys(testdata.get("Address"));

        driver.findElement(ToolsqaFormPage_Elements.hobbies_music).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");

        driver.findElement(ToolsqaFormPage_Elements.submit).click();






    }
}
