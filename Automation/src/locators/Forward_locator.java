package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forward_locator {
    public static void main(String[] args){
        Forward_locator();
    }
    public static void Forward_locator(){
        ChromeDriver chrome = null;
        try{
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();

            //chrome.get("file:///E:/MorningBatch_Combined/HTML/Webpage/SampleWebPage.html");
            chrome.navigate().to("file:///C:/javaclass/Workspace/Automation/html/Sample.html");
            //using xpath enter userName and password
            chrome.findElement(By.xpath("//input[@id='frm1_un_id']/following-sibling::input[1]\n")).getText();
            Thread.sleep(2000);


        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            chrome = null;
        }
    }
}
