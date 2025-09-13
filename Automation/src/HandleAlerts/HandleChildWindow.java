package HandleAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandleChildWindow {
    public static void main (String[] args){
        handleChildWindow();
    }
    public static void handleChildWindow(){
        WebDriver oBrowser = null;
        String sParent = null;
        Set<String> oChild = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();

            oBrowser.navigate().to("file:///C:/javaclass/Workspace/Automation/html/link.html");
            Thread.sleep(2000);
            sParent = oBrowser.getWindowHandle();
            System.out.println("Parent Window ID: "+sParent);

            oBrowser.findElement(By.linkText("Linkdin")).click();
            oBrowser.findElement(By.xpath("//*[@id=\"organic-div\"]/div[2]/button/span")).click();
            Thread.sleep(2000);
            //oBrowser.switchTo().frame(oBrowser.findElement(By.xpath("//iframe[@*='Sign in with AppleButton']")));
            oChild = oBrowser.getWindowHandles();
            for(String childWnd : oChild){
                if (!childWnd.equals(sParent)) {
                    oBrowser.switchTo().window(childWnd);
                    System.out.println(oBrowser.getTitle());
                    System.out.println(oBrowser.getCurrentUrl());
                    Thread.sleep(2000);
                    oBrowser.close();
                    break;
                }
            }

            oBrowser.switchTo().window(sParent);

            Thread.sleep(2000);
            oBrowser.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser = null;
        }
    }
}

