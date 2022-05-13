package Testing;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ForgotPassword extends BaseClass{


    @Test
    public void forgotPasswordTest() {

        driver.get(prodLoginUrl);

        ForgotPasswordElements forgotPassword = new ForgotPasswordElements();
        SignInElements cookieButtoninFacebookSignIn = new SignInElements();
        cookieButtoninFacebookSignIn.cookiesOkButtonClick();
        forgotPassword.forgotPasswordButtonClick();

        String ExpectedForgotPasswordURL = "https://www.sololearn.com/User/ForgotPassword/";
        String ActualForgotPasswordURL = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedForgotPasswordURL, ActualForgotPasswordURL);

        forgotPassword.enterEmailForPasswordRecovery("ani.balyan@sololearn.com");
        forgotPassword.recoverButtonClick();

        String ActualMessageEmailSent = driver.findElement(By.cssSelector("div.block p")).getText();
        String ExpectedMessageEmailSent = "We just sent you an email containing further instructions.";
        Assert.assertEquals(ActualMessageEmailSent, ExpectedMessageEmailSent );
    }
}
