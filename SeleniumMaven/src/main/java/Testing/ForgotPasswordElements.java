package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ForgotPasswordElements extends BaseClass {

    By forgotPasswordButton = By.className("sl-login-login-form__forgot-pass");
    By ForgotPasswordEmail = By.id("Email");
    By RecoverButton = By.cssSelector("[class = 'formActions'] [class = 'materialButton primary elevated']");

    public void forgotPasswordButtonClick() {
        driver.findElement(forgotPasswordButton).click();
    }

    public void enterEmailForPasswordRecovery(String emailForPasswordRecovery) {
        driver.findElement(ForgotPasswordEmail).sendKeys(emailForPasswordRecovery);
    }

    public void recoverButtonClick() {
        driver.findElement(RecoverButton).click();
    }
}
