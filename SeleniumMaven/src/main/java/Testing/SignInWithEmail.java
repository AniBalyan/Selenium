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
        signSignUpElements validSignInTest = new signSignUpElements();
        validSignInTest.cookiesOkButtonClick();
        validSignInTest.enterUserEmail("forbits1@sololearn.com");
        validSignInTest.enterPassword("123456");
        validSignInTest.clickSignIn();

        String expectedProfileUrl = "https://web-dev.sololearn.com/profile/21413224";
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectedProfileUrl));
        String actualProfileUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedProfileUrl, actualProfileUrl);
    }


    }

