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

    @Test
    public void EmptyFields() throws InterruptedException {

        driver.get(devLoginURL);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(cookiesOkButton));
        driver.findElement(cookiesOkButton).click();

        WebElement signIn2 = driver.findElement(signIn);
        boolean isLoginEnabled = signIn2.isEnabled();
        Assert.assertEquals(false, isLoginEnabled);

    }

}
