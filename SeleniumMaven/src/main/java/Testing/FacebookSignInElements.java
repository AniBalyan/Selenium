package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FacebookSignInElements extends BaseClass{
    By facebookLoginButton = By.cssSelector("button[class='sl-login-social-login__item--facebook sl-login-social-login__item__social-button']");
    By FacebookAccount = By.id("email");
    By FacebookSignInPassword = By.id("pass");
    By LoginAfterPassword= By.cssSelector("[id='loginbutton'] [type='submit']");


    public void FacebookLoginClick () {
        driver.findElement(facebookLoginButton).click();
    }


    public void enterFacebookAccount(String yourFaceBookAccount){
        driver.findElement(FacebookAccount).sendKeys(yourFaceBookAccount);
    }

    public void facebookSignInPasswordClick(){
        driver.findElement(FacebookSignInPassword).click();
    }

    public void enterFacebookPassword(String yourFacebookPassword) {
        driver.findElement(FacebookSignInPassword).sendKeys(yourFacebookPassword);
    }

    public void FacebookSignInButtonAfterPassword () {
        driver.findElement(LoginAfterPassword).click();
    }
}
