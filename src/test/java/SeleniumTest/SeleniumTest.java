package SeleniumTest;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    WebDriver driver;

    //SetUp Code which will run before any other class runs
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Proyectos\\SeleniumProject\\SeleniumTestingProject\\src\\main\\resources\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    //AfterClass annotation acts like a post-condition
    @AfterClass
    public  void tearDown(){
        //driver.quit(); //Closes every window and quits the driver
        //driver.close(); //Only closes the current window
    }

    /*Test annotation identifies a test method
      For every test it is vital to identify a web element and then, perform an action with that element */
    @Test
    public void testLogginIntoApp () throws InterruptedException {
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.className("orangehrm-login-button")).click();
        Thread.sleep(2000);
        String actualResult = driver.findElement(By.tagName("h6")).getText();
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult);


    }
}
