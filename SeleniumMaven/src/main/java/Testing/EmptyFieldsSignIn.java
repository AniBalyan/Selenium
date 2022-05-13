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

import static Testing.SignInElements.signInButton;

public class EmptyFieldsSignIn extends BaseClass{

    @Test
    public void EmptyFieldsTest()  {

        driver.get(prodLoginUrl);

        SignInElements emptyFieldsTest =new SignInElements();
        emptyFieldsTest.cookiesOkButtonClick();
        emptyFieldsTest.enterUserEmail("");
        emptyFieldsTest.enterPassword("");

        WebElement webElementSignInButton = driver.findElement(SignInElements.signInButton);
        boolean isSignInButtonEnabled = webElementSignInButton.isEnabled();
        Assert.assertEquals(false, isSignInButtonEnabled);

    }
}
