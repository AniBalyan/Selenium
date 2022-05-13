package Testing;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignInWithEmail extends BaseClass{

    @Test
    public void validSignInTest() {

        driver.get(prodLoginUrl);
        SignInElements validSignInTest = new SignInElements();
        validSignInTest.cookiesOkButtonClick();
        validSignInTest.enterUserEmail("forbits1@sololearn.com");
        validSignInTest.enterPassword("123456");

        SignInElements.clickSignIn();

        String expectedProfileUrl = "https://www.sololearn.com/profile/21413224";
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectedProfileUrl));
        String actualProfileUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedProfileUrl, actualProfileUrl);
    }


    }

