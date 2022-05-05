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
import java.util.Random;


public class WrongPassword extends BaseClass{


    @Test
       public void WrongPassword() throws InterruptedException {

        By ActualWrongPasswordErrorMessage = By.cssSelector("[class='sl-login-error']");

        driver.get("https://www.sololearn.com/users/login");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(cookiesOkButton));

        driver.findElement(cookiesOkButton).click();

        Random randomUsername = new Random();
        int randomNumbers = randomUsername.nextInt();

        driver.findElement(userEmail).sendKeys(("test" + randomNumbers + "@sololearn.com"));
        driver.findElement(password).sendKeys("1234567");
        driver.findElement(signIn).click();


        String ExpectedErrorMessage = "Invalid username or password.";
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(ActualWrongPasswordErrorMessage));
        String ActualErrorMessage = driver.findElement(ActualWrongPasswordErrorMessage).getText();
        Assert.assertEquals(ExpectedErrorMessage, ActualErrorMessage);

    }

}
