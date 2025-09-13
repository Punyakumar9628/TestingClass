package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Partial_locators {
    public static void main(String[] args){
        partialLocators();
    }

    //partial locator example
    public static void partialLocators(){
        ChromeDriver chrome = null;
        try{
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();

            //chrome.get("file:///E:/MorningBatch_Combined/HTML/Webpage/SampleWebPage.html");
            chrome.navigate().to("file:///C:/javaclass/Workspace/Automation/html/form.html");
            //using xpath enter userName and password
            chrome.findElement(By.xpath("//input[starts-with(@id,'frm1_un_i')]\n")).sendKeys("aaaaaaaaaaaaa");
            Thread.sleep(2000);

            chrome.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            chrome = null;
        }
    }
}
