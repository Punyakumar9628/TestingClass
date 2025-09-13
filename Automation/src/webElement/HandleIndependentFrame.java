package webElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class HandleIndependentFrame {
    public static void main(String[] args){
        handleFrameTestcase1();
    }
    public static void handleFrameTestcase1(){
        WebDriver oBrowser = null;
        try {
            //1. open the sample nested frame application
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("https://docs.oracle.com/javase/8/docs/api/");

            //2. Read the main page header
            System.out.println("Main Page Header: " + oBrowser.findElement(By.tagName("h1")).getText());

            //3. Switch to Page1 frame (parent frame) by index and select all checkboxes
            oBrowser.switchTo().frame(0);
            List<WebElement> chkBoxes = oBrowser.findElements(By.xpath("//input[@type='checkbox']"));
            for(WebElement box : chkBoxes) {
                if(!box.isSelected()) {
                    box.click();
                }
            }

            //4. Switch to Page2 frame (Child frame) using name/id
            oBrowser.switchTo().frame("page2");

            //5. Enter username and password
            oBrowser.findElement(By.id("frm1_un_id")).sendKeys("sgadmin");
            oBrowser.findElement(By.id("frm1_pwd_id")).sendKeys("sgadmin");

            //6. Go back to parent frame Page1 using parentFrame
            oBrowser.switchTo().parentFrame();

            //7. Uncheck all the checkboxes
            chkBoxes = oBrowser.findElements(By.xpath("//input[@type='checkbox']"));
            for(WebElement box : chkBoxes) {
                if(box.isSelected()) {
                    box.click();
                }
            }

            //8. Go back to main page
            oBrowser.switchTo().defaultContent();

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //9. Close the browser
            if(oBrowser != null) {
                oBrowser.quit(); // better than close()
            }
        }
    }
}
