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


public class EmptyFieldsSignIn extends BaseClass{

    By signInButton = By.className("sl-login-login-form__action");

    @Test
    public void EmptyFieldsTest()  {

        driver.get(prodLoginUrl);

        signSignUpElements emptyFieldsTest =new signSignUpElements();
        emptyFieldsTest.cookiesOkButtonClick();
        emptyFieldsTest.enterUserEmail("");
        emptyFieldsTest.enterPassword("");

        WebElement webElementSignInButton = driver.findElement(signInButton);
        boolean isSignInButtonEnabled = webElementSignInButton.isEnabled();
        Assert.assertEquals(false, isSignInButtonEnabled);

    }

}
