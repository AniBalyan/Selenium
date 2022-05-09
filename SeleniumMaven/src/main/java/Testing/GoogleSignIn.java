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
    public void GoogleSignInTest() throws InterruptedException {

        driver.get(prodLoginUrl);

        signSignUpElements googleSign = new signSignUpElements();
        googleSign.cookiesOkButtonClick();
        googleSign.googleSignInButtonClick();


        for(String GoogleWindow : driver.getWindowHandles()){
            driver.switchTo().window(GoogleWindow);
        }

        googleSign.enterGoogleAccount("soliktest@gmail.com");
        googleSign.NextAfterGoogleAccountClick();
        googleSign.enterGooglePassword("testsolik");
        googleSign.NextAfterGooglePasswordClick();


        String expectedGoogleUrl = "https://www.sololearn.com/profile/25649014";

        Thread.sleep(4000);

        for(String SololearnWindow : driver.getWindowHandles()){
            driver.switchTo().window(SololearnWindow);
        }
        Thread.sleep(4000);

        String actualGoogleUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedGoogleUrl, actualGoogleUrl);

    }

}
