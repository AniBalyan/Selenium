package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class GoogleSignIn extends BaseClass{

    @Test
    public void WrongPassword() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");

        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated((By.id("CybotCookiebotDialogBodyLevelButtonAccept"))));

        WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
        Ok.click();

       WebElement GoogleLogin =
               driver.findElement(By.cssSelector("button[class='sl-login-social-login__item--google sl-login-social-login__item__social-button']"));
       GoogleLogin.click();

        for(String GoogleWindow : driver.getWindowHandles()){
            driver.switchTo().window(GoogleWindow);
        }
        Thread.sleep(3000);
        WebElement googleAccount = driver.findElement(By.cssSelector("input[type='email']"));
        googleAccount.sendKeys("soliktest@gmail.com");
        WebElement Next = driver.findElement(By.cssSelector("[id='identifierNext'] [class='VfPpkd-vQzf8d']"));
        Next.click();
        Thread.sleep(3000);
        WebElement googleSignInPassword = driver.findElement(By.cssSelector("input[type='password']"));
        Thread.sleep(3000);
        googleSignInPassword.sendKeys("testsolik");
        Thread.sleep(3000);
        WebElement NextAfterPassword = driver.findElement(By.cssSelector("[id='passwordNext'] [class='VfPpkd-vQzf8d']"));
        Thread.sleep(3000);
        NextAfterPassword.click();

        String expectedGoogleUrl = "https://www.sololearn.com/profile/25649014";

        Thread.sleep(5000);

        for(String SololearnWindow : driver.getWindowHandles()){
            driver.switchTo().window(SololearnWindow);
        }

        String actualGoogleUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedGoogleUrl, actualGoogleUrl);

    }

}
