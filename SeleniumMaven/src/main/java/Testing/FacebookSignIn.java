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

    By facebookLogin = By.cssSelector("button[class='sl-login-social-login__item--facebook sl-login-social-login__item__social-button']");
    By FacebookAccount = By.id("email");
    By FacebookSignInPassword = By.id("pass");
    By LoginAfterPassword= By.cssSelector("[id='loginbutton'] [type='submit']");

    @Test
    public void FacebookSignIn() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(cookiesOkButton));
        driver.findElement(cookiesOkButton).click();

        WebElement cookieOkButtonWebElement = driver.findElement(cookiesOkButton);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(cookieOkButtonWebElement));

        driver.findElement(facebookLogin).click();

        for(String GoogleWindow : driver.getWindowHandles()){
            driver.switchTo().window(GoogleWindow);
        }

        driver.findElement(FacebookAccount).sendKeys("marialucia00@mail.ru");
        driver.findElement(FacebookSignInPassword).click();
        driver.findElement(FacebookSignInPassword).sendKeys("maria555");
        driver.findElement(LoginAfterPassword).click();

        Thread.sleep(4000);

        for(String SololearnWindow : driver.getWindowHandles()){
            driver.switchTo().window(SololearnWindow);
        }

        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.urlToBe("https://www.sololearn.com/profile/21809193"));
        String expectedFacebookUrl = "https://www.sololearn.com/profile/21809193";
        String actualFacebookUrl = driver.getCurrentUrl();

        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.urlToBe("https://www.sololearn.com/profile/21809193"));
        Assert.assertEquals(expectedFacebookUrl, actualFacebookUrl);

    }

}
