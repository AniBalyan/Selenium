package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static java.time.Duration.ofSeconds;


public class SingInTest extends BaseClass {

    @Test
    public void EmptyFields() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");
        Thread.sleep(4000);
        //  WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
        //  Ok.click();

        WebElement username = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.className("sl-login-login-form__action"));

        boolean isLoginEnabled = login.isEnabled();
        Assert.assertEquals(false, isLoginEnabled);
    }

    @Test
    public void SignIn() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");

        Thread.sleep(4000);

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


    @Test

    public void WrongPassword() throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");
        Thread.sleep(4000);
        //WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
       // Ok.click();

        WebElement username = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.className("sl-login-login-form__action"));

        Random randomUsername = new Random();
        int randomNumbers = randomUsername.nextInt();

        username.sendKeys("test" + randomNumbers + "@sololearn.com");
        password.sendKeys("1234567");
        login.click();

        String ExpectedErrorMessage = "Invalid username or password.";
        Thread.sleep(4000);
        String ActualErrorMessage = driver.findElement(By.cssSelector("[class='sl-login-error']")).getText();
        Thread.sleep(4000);

        Assert.assertEquals(ExpectedErrorMessage, ActualErrorMessage);

    }

}


