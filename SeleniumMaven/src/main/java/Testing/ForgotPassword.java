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


public class ForgotPassword extends BaseClass{

    By forgotPassword = By.className("sl-login-login-form__forgot-pass");
    By ForgotPasswordEmail = By.id("Email");
    By RecoverButton = By.cssSelector("[class = 'formActions'] [class = 'materialButton primary elevated']");

    @Test
    public void WrongPassword() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(cookiesOkButton));

        driver.findElement(cookiesOkButton).click();
        driver.findElement(forgotPassword).click();

        String ExpectedForgotPasswordURL = "https://www.sololearn.com/User/ForgotPassword/";
        String ActualForgotPasswordURL = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedForgotPasswordURL, ActualForgotPasswordURL);

        driver.findElement(ForgotPasswordEmail).sendKeys("ani.balyan@sololearn.com");
        driver.findElement(RecoverButton).click();

        String ActualMessageEmailSent = driver.findElement(By.cssSelector("div.block p")).getText();
        String ExpectedMessageEmailSent = "We just sent you an email containing further instructions.";
        Assert.assertEquals(ActualMessageEmailSent, ExpectedMessageEmailSent );
    }
}