package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialLink_Text {
    //partialLinkText locator example
    public static void partialLinkTextLocator(){
        ChromeDriver chrome = null;
        try{
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();

            //chrome.get("file:///C:/javaclass/Workspace/Automation/html/frames/nestedmain.html");
            chrome.navigate().to("file:///C:/javaclass/Workspace/Automation/html/frames/nestedmain.html");

            //using linkText enter userName and password
            chrome.findElement(By.partialLinkText("gle In")).click();
            Thread.sleep(2000);

            //Click on back navigation
            chrome.navigate().back();

            chrome.findElement(By.partialLinkText("Facebook")).click();
            Thread.sleep(2000);

            //Click on back navigation
            chrome.navigate().back();


            chrome.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            chrome = null;
        }
    }

}
