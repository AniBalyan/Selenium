package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;


public class WrongPassword extends BaseClass{

      @Test
       public void WrongPasswordTest() {

       driver.get(prodLoginUrl);
        SignInElements wrongPassword = new SignInElements();
        wrongPassword.cookiesOkButtonClick();

        Random randomUsername = new Random();
        int randomNumbers = randomUsername.nextInt();

        wrongPassword.enterUserEmail("test" + randomNumbers + "@sololearn.com");
        wrongPassword.enterPassword("1234567");
        wrongPassword.clickSignIn();

        By ActualWrongPasswordErrorMessage = By.cssSelector("[class='sl-login-error']");
        String ExpectedErrorMessage = "Invalid username or password.";

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(ActualWrongPasswordErrorMessage));
        String ActualErrorMessage = driver.findElement(ActualWrongPasswordErrorMessage).getText();
        Assert.assertEquals(ExpectedErrorMessage, ActualErrorMessage);

    }

}
