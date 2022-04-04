package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class SingIn {


    @BeforeTest
    public void Begin(){
        System.out.println( "testing has been started");
    }

    @Test
    public void SignIn_Page_Title_Validation() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sololearn\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.sololearn.com/users/login");
        Thread.sleep(4000);
        WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
        Ok.click();

        WebElement username = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.className("sl-login-login-form__action"));

        username.sendKeys("ani@sololearn.com");
        password.sendKeys("123456");
        login.click();

        String expectedUrl="https://www.sololearn.com/profile/20265645";
        Thread.sleep(4000);
        String actualUrl= driver.getCurrentUrl();
        Thread.sleep(4000);
        driver.quit();
        Assert.assertEquals(expectedUrl, actualUrl);


    }

    @AfterTest
    public void After_Test(){
        System.out.println( "testing finsihed");
    }

}


