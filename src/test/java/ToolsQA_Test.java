import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageElements.ToolsqaFormPage_Elements;
import utils.ExcelUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ToolsQA_Test extends BaseTestCase{

    @Test
    public void initTest()  {
        String testdata_path = "src//test//resources//TestData.xlsx";
        Map<String, String> testdata = ExcelUtils.readData(testdata_path, "FormData");
        System.out.println(testdata);
        enterText(ToolsqaFormPage_Elements.fnameField,testdata.get("FirstName"));
        enterText(ToolsqaFormPage_Elements.lnameField,testdata.get("LastName"));
        enterText(ToolsqaFormPage_Elements.email,testdata.get("Email"));

        if(testdata.get("Gender").equalsIgnoreCase("female")){
            click(ToolsqaFormPage_Elements.gender_f);
        }else if(testdata.get("Gender").equalsIgnoreCase("male")){
            click(ToolsqaFormPage_Elements.gender_m);
        }else click(ToolsqaFormPage_Elements.gender_o);
        enterText(ToolsqaFormPage_Elements.mobile,testdata.get("Mobile"));
        click(ToolsqaFormPage_Elements.hobbies_sports);



        enterText(ToolsqaFormPage_Elements.address,testdata.get("Address"));
        selectByValue(ToolsqaFormPage_Elements.state, testdata.get("State"));
        selectByValue(ToolsqaFormPage_Elements.city, testdata.get("City"));


        click(ToolsqaFormPage_Elements.submit);

        assert(isElementPresent(ToolsqaFormPage_Elements.form_success_msg));






    }
}
