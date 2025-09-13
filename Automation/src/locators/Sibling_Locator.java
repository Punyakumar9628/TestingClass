package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sibling_Locator {
    public static void main(String[] args){
        SiblingLocator();
    }
    public static void SiblingLocator(){
        ChromeDriver chrome = null;
        try{
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();

            //chrome.get("file:///E:/MorningBatch_Combined/HTML/Webpage/SampleWebPage.html");
            chrome.navigate().to("file:///C:/javaclass/Workspace/Automation/html/Sample.html");
            //using xpath enter userName and password
            chrome.findElement(By.xpath("//td[text()='Abdul Kalam']/following-sibling::td[1]")).getText();
            Thread.sleep(2000);


        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            chrome = null;
        }
    }
}
