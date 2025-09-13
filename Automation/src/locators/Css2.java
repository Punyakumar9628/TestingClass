package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Css2 {
    public static void main(String[] args) {
        xpathLocator();
    }

    public static void xpathLocator() {
        ChromeDriver chrome = null;
        try {
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();

            //chrome.get("file:///C:/javaclass/Workspace/Automation/html/frames/main.html");
            chrome.navigate().to("file:///C:/javaclass/Workspace/Automation/html/frames/main.html");

            //using cssSelector enter userName and password
            chrome.findElement(By.cssSelector("form[id='frm1']>:first-child")).sendKeys("aaaaaaaaa");
            Thread.sleep(2000);

            chrome.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            chrome = null;
        }
    }
}
