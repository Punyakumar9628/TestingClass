package webElement;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleIndependent {
    public static void main(String[] args) {
        handleFrameTestcase1();
    }

    public static void handleFrameTestcase1() {
        WebDriver oBrowser = null;
        try {
            // 1. Open the Java 8 API documentation application
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("https://docs.oracle.com/javase/8/docs/api/");

            // 2. Read the main page title and URL
            System.out.println("Main Page Title: " + oBrowser.getTitle());
            System.out.println("Main Page URL  : " + oBrowser.getCurrentUrl());

            // 3. Using index switch to 'Packages' frame and click on "java.awt" link
            oBrowser.switchTo().frame(0); // first frame (packages list)
            oBrowser.findElement(By.linkText("java.awt")).click();
            Thread.sleep(2000);

            // 4. Go back to main page
            oBrowser.switchTo().defaultContent();

            // 5. Using name/id attribute switch to 'Interfaces' frame
            oBrowser.switchTo().frame("packageFrame");

            // 6. Click on the "ActiveEvent" link
            oBrowser.findElement(By.linkText("ActiveEvent")).click();
            Thread.sleep(2000);

            // 7. Go back to main page
            oBrowser.switchTo().defaultContent();

            // 8. Using WebElement switch to 'Interface ActiveEvent' frame
            WebElement classFrame = oBrowser.findElement(By.name("classFrame"));
            oBrowser.switchTo().frame(classFrame);

            // 9. Read the page header "Interface ActiveEvent"
            String header = oBrowser.findElement(By.cssSelector("h2.title")).getText();
            System.out.println("Page Header: " + header);

            // 10. Go back to main page
            oBrowser.switchTo().defaultContent();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 11. Close the main page
            if (oBrowser != null) {
                oBrowser.quit();
            }
        }
    }
}
