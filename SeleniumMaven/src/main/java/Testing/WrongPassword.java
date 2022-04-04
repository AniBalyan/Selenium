package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class WrongPassword {


    @BeforeTest
    public void Begin(){
        System.out.println( "testing has been started");
    }

    @Test
    public void WrongPassword() throws InterruptedException {
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
        password.sendKeys("1234567");
        login.click();

        String ExpectedErrorMessage = "Invalid username or password.";
        Thread.sleep(4000);
        String ActualErrorMessage = driver.findElement(By.cssSelector("[class='sl-login-error']")).getText();
        Thread.sleep(4000);

        Assert.assertEquals(ExpectedErrorMessage, ActualErrorMessage);
        driver.quit();
    }

    @AfterTest
    public void After_Test(){
        System.out.println( "testing finsihed");
    }

}
