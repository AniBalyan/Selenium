package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SignIn extends BaseClass {

    @Test
    public void SignIn() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");

        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated((By.id("CybotCookiebotDialogBodyLevelButtonAccept"))));

        WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
        Ok.click();

        WebElement username = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.className("sl-login-login-form__action"));

        username.sendKeys("ani@sololearn.com");
        password.sendKeys("123456");
        login.click();


        String expectedUrl="https://www.sololearn.com/profile/20265645";
        Thread.sleep(4000);
        String actualUrl= driver.getCurrentUrl();
        Thread.sleep(4000);

        Assert.assertEquals(expectedUrl, actualUrl);
        WebElement Logout = driver.findElement(By.className("sl-user__select__image"));
        Logout.click();
        WebElement LogoutButton = driver.findElement(By.className("sl-user-settings__profile__logout__icon"));
        LogoutButton.click();
    }
}
