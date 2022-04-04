package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FacebookSignIn {


    @BeforeTest
    public void Begin() {
        System.out.println("testing has been started");
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

        WebElement FacebookLogin =
                driver.findElement(By.cssSelector("button[class='sl-login-social-login__item--facebook sl-login-social-login__item__social-button']"));
        FacebookLogin.click();

        for(String GoogleWindow : driver.getWindowHandles()){
            driver.switchTo().window(GoogleWindow);
        }
        WebElement FacebookAccount = driver.findElement(By.id("email"));
        FacebookAccount.sendKeys("marialucia00@mail.ru");
        WebElement FacebookSignInPassword = driver.findElement(By.id("pass"));
        Thread.sleep(5000);
        FacebookSignInPassword.sendKeys("maria555");
        Thread.sleep(5000);
        WebElement LoginAfterPassword = driver.findElement((By.cssSelector("[id='loginbutton'] [type='submit']")));
        Thread.sleep(5000);
        LoginAfterPassword.click();

        String expectedGoogleUrl = "https://www.sololearn.com/profile/21809193";

        Thread.sleep(6000);

        for(String SololearnWindow : driver.getWindowHandles()){
            driver.switchTo().window(SololearnWindow);
        }

        String actualGoogleUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedGoogleUrl, actualGoogleUrl);

    }

    @AfterTest
    public void After_Test () {
        System.out.println("testing finsihed");
    }

}