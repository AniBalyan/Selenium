package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleSignInElements extends BaseClass{

    By googleLoginButton = By.cssSelector("button[class='sl-login-social-login__item--google sl-login-social-login__item__social-button']");
    By googleAccount =By.cssSelector("input[type='email']");
    By nextButtonAfterGoogleAccount = By.cssSelector("[id='identifierNext'] [class='VfPpkd-vQzf8d']");
    By googleSignInPassword = By.cssSelector("input[type='password']");
    By NextButtonAfterGooglePassword = By.cssSelector("[id='passwordNext'] [class='VfPpkd-vQzf8d']");

    public void googleSignInButtonClick() {
        driver.findElement(googleLoginButton).click();
    }

    public void enterGoogleAccount (String yourGoogleAccount) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(googleAccount));
        driver.findElement(googleAccount).sendKeys(yourGoogleAccount);
    }

    public void NextAfterGoogleAccountClick(){
        driver.findElement(nextButtonAfterGoogleAccount).click();
    }

    public void enterGooglePassword(String yourGooglePassword) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(googleSignInPassword));
        driver.findElement(googleSignInPassword).sendKeys(yourGooglePassword);
    }

    public void NextAfterGooglePasswordClick(){
        driver.findElement(NextButtonAfterGooglePassword).click();
    }
}
