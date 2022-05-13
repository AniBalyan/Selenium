package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class OnboardingElements extends BaseClass {

    By registerButton = By.className("sl-action-btn--primary");
    By usernameName = By.id("name");
    By SignupButton = By.className("sl-login-signup-form__action");


    public void registerButtonClick () {
        driver.findElement(registerButton).click();
    }

    public void enterUsername (String yourUsername) {
        driver.findElement(usernameName).sendKeys(yourUsername);
    }

    public void signUpButtonClick () {
        driver.findElement(SignupButton).click();
    }
}
