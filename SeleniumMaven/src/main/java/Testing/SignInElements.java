package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class SignInElements extends BaseClass{

    By userEmail = By.id("email");
    By password = By.id("password");
    static By signInButton = By.className("sl-login-login-form__action");
    By cookiesOkButton = By.id("CybotCookiebotDialogBodyLevelButtonAccept");

    public void cookiesOkButtonClick() {

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(cookiesOkButton));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(cookiesOkButton));
        driver.findElement(cookiesOkButton).click();

    }

    public void enterUserEmail(String yourEmail)
    {
        driver.findElement(userEmail).sendKeys(yourEmail);
    }

    public void enterPassword(String yourPassword) {
        driver.findElement(password).sendKeys(yourPassword);
    }

    public static void clickSignIn() {
        driver.findElement(signInButton).click();
    }

}
