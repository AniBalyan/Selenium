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
import java.util.concurrent.TimeUnit;


public class FacebookSignIn extends BaseClass {

    @Test
    public void FacebookSignIn() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated((By.id("CybotCookiebotDialogBodyLevelButtonAccept"))));
        WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
        Ok.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(Ok));

        WebElement FacebookLogin =
                driver.findElement(By.cssSelector("button[class='sl-login-social-login__item--facebook sl-login-social-login__item__social-button']"));
        FacebookLogin.click();

      //  Thread.sleep(4000);

        for(String GoogleWindow : driver.getWindowHandles()){
            driver.switchTo().window(GoogleWindow);
        }

        WebElement FacebookAccount = driver.findElement(By.id("email"));
        WebElement FacebookSignInPassword = driver.findElement(By.id("pass"));


        FacebookAccount.sendKeys("marialucia00@mail.ru");
        //click pass field
        //wait
        FacebookSignInPassword.sendKeys("maria555");

        WebElement LoginAfterPassword = driver.findElement((By.cssSelector("[id='loginbutton'] [type='submit']")));
        LoginAfterPassword.click();


        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfWindowsToBe(1));
        for(String SololearnWindow : driver.getWindowHandles()){
            driver.switchTo().window(SololearnWindow);
        }

        Thread.sleep(4000);

        String expectedFacebookUrl = "https://www.sololearn.com/profile/21809193";
        String actualFacebookUrl = driver.getCurrentUrl();

        Thread.sleep(3000);
        Assert.assertEquals(expectedFacebookUrl, actualFacebookUrl);

    }

}
