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

    By googleLoginButton = By.cssSelector("button[class='sl-login-social-login__item--google sl-login-social-login__item__social-button']");
    By googleAccount =By.cssSelector("input[type='email']");
    By nextButton = By.cssSelector("[id='identifierNext'] [class='VfPpkd-vQzf8d']");
    By googleSignInPassword = By.cssSelector("input[type='password']");
    By NextAfterPassword = By.cssSelector("[id='passwordNext'] [class='VfPpkd-vQzf8d']");

    @Test
    public void WrongPassword() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(cookiesOkButton));
        driver.findElement(cookiesOkButton).click();

        driver.findElement(googleLoginButton).click();

        for(String GoogleWindow : driver.getWindowHandles()){
            driver.switchTo().window(GoogleWindow);
        }

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(googleAccount));
        driver.findElement(googleAccount).sendKeys("soliktest@gmail.com");

        driver.findElement(nextButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(googleSignInPassword));
        driver.findElement(googleSignInPassword).sendKeys("testsolik");

        driver.findElement(NextAfterPassword).click();

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
