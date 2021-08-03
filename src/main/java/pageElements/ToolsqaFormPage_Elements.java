package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolsqaFormPage_Elements {

    public static By fnameField = By.id("firstName");
    public static By lnameField = By.id("lastName");
    public static By email = (By.id("userEmail"));
    public static By mobile = (By.id("userNumber"));
    public static By dob = (By.id("dateOfBirthInput"));
    public static By gender_f = (By.xpath("//input[@name='gender' and @value='Female']"));
    public static By gender_m = (By.xpath("//input[@name='gender' and @value='Male']"));
    public static By gender_o = (By.xpath("//input[@name='gender' and @value='Other']"));
    public static By subject = (By.id("subjectsContainer"));
    public static By hobbies_sports = (By.id("hobbies-checkbox-1"));
    public static By hobbies_reading = (By.id("hobbies-checkbox-2"));
    public static By hobbies_music = (By.id("hobbies-checkbox-3"));
    public static By address = (By.id("currentAddress"));
    public static By state = (By.id("state"));
    public static By city = (By.id("city"));
    public static By submit = (By.id("submit"));

}
