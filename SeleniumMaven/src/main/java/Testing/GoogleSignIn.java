package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GoogleSignIn extends BaseClass{

    @Test
    public void WrongPassword() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");
        Thread.sleep(4000);
        WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
        Ok.click();

       WebElement GoogleLogin =
               driver.findElement(By.cssSelector("button[class='sl-login-social-login__item--google sl-login-social-login__item__social-button']"));
       GoogleLogin.click();

        for(String GoogleWindow : driver.getWindowHandles()){
            driver.switchTo().window(GoogleWindow);
        }
        WebElement googleAccount = driver.findElement(By.cssSelector("input[type='email']"));
        googleAccount.sendKeys("qa@sololearn.com");
        WebElement Next = driver.findElement(By.cssSelector("[id='identifierNext'] [class='VfPpkd-vQzf8d']"));
        Next.click();
        Thread.sleep(5000);
        WebElement googleSignInPassword = driver.findElement(By.cssSelector("input[type='password']"));
        Thread.sleep(5000);
        googleSignInPassword.sendKeys("qatest12#");
        Thread.sleep(5000);
        WebElement NextAfterPassword = driver.findElement(By.cssSelector("[id='passwordNext'] [class='VfPpkd-vQzf8d']"));
        Thread.sleep(5000);
        NextAfterPassword.click();

        String expectedGoogleUrl = "https://www.sololearn.com/profile/24067841";

        Thread.sleep(6000);

        for(String SololearnWindow : driver.getWindowHandles()){
            driver.switchTo().window(SololearnWindow);
        }

        String actualGoogleUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedGoogleUrl, actualGoogleUrl);

    }

}
