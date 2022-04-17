package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FacebookSignIn extends BaseClass {

    @Test
    public void WrongPassword() throws InterruptedException {

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

        String expectedFacebookUrl = "https://www.sololearn.com/profile/21809193";

        Thread.sleep(6000);

        for(String SololearnWindow : driver.getWindowHandles()){
            driver.switchTo().window(SololearnWindow);
        }

        String actualFacebookUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedFacebookUrl, actualFacebookUrl);

    }

}
