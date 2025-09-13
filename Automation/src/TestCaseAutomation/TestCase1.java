package TestCaseAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase1 {
    public static void main(String[] args){
        testScript();
    }
    //login--> create user--> delete user--> logout
    public static void testScript(){
        WebDriver oBrowser = null;
        try{
            //1. open the browser
            oBrowser = new FirefoxDriver();
            oBrowser.manage().window().maximize();

            //2. navigate the URL
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);

            //3. Login with valid credentials & click on "Login" button
            oBrowser.findElement(By.id("username")).sendKeys("admin");
            oBrowser.findElement(By.name("pwd")).sendKeys("manager");
            oBrowser.findElement(By.id("loginButton")).click();
            Thread.sleep(2000);

            //4. verify login is successful
            String strText = oBrowser.findElement(By.xpath("//td[@class='pagetitle']")).getText();
            if(strText.equalsIgnoreCase("Enter Time-Track")){
                System.out.println("Login to actiTime was successful");
                if(oBrowser.findElements(By.xpath("//div[@style='display: block;']")).size()>0){
                    oBrowser.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
                }
            }else{
                System.out.println("Failed to login to ActiTime");
                return;
            }

            //5. click USERS menu & click on 'Add user' button
            oBrowser.findElement(By.xpath("//div[text()='USERS']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
            Thread.sleep(2000);


            //6. Enter all the required details and click on "Create User" button
            oBrowser.findElement(By.xpath("//input[@name='firstName']")).sendKeys("sush");
            oBrowser.findElement(By.xpath("//input[@name='lastName']")).sendKeys("acharya");
            oBrowser.findElement(By.xpath("//input[@name='email']")).sendKeys("sushacharya@gmail.com");
            oBrowser.findElement(By.xpath("//input[@name='username']")).sendKeys("sushacharya");
            oBrowser.findElement(By.xpath("//input[@name='password']")).sendKeys("sush@123");
            oBrowser.findElement(By.xpath("//input[@name='passwordCopy']")).sendKeys("sush@123");
            oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
            Thread.sleep(2000);


            //7. verify user created successful
            if(oBrowser.findElements(By.xpath("//div[@class='name']/span[text()='Demo, test']")).size()>0){
                System.out.println("The new user is created successful");
            }else{
                System.out.println("Failed to create the new user");
                return;
            }


            //8. open the required user and click on 'Delete user" button
            //9. accept the alert and delete the user
            oBrowser.findElement(By.xpath("//div[@class='name']/span[text()='Demo, test']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
            Thread.sleep(2000);
            oBrowser.switchTo().alert().accept();
            Thread.sleep(2000);


            //10. Verify user deleted succesful
            if(oBrowser.findElements(By.xpath("//div[@class='name']/span[text()='Demo, test']")).size()> 0){
                System.out.println("Failed to delete the user");
            }else{
                System.out.println("The user deleted successful");
            }


            //11. Click on "logout" link and verify logout is successful
            oBrowser.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);
            if(oBrowser.getTitle().equalsIgnoreCase("actiTIME - Login")){
                System.out.println("Logout from actiTime was successful");
            }else{
                System.out.println("Failed to lgout from actiTime");
                return;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            //12. close the browser
            oBrowser.close();
            oBrowser = null;
        }
    }
}