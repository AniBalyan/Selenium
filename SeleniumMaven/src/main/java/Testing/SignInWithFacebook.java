package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class SignInWithFacebook extends BaseClass {



    @Test
    public void FacebookSignIn() throws InterruptedException {

        By cookiesOkButton = By.id("CybotCookiebotDialogBodyLevelButtonAccept");

        driver.get(prodLoginUrl);

        signSignUpElements signInWithFaceBook = new signSignUpElements();

        signInWithFaceBook.cookiesOkButtonClick();
        signInWithFaceBook.FacebookLoginClick();
        String facebookProfileURL = "https://www.sololearn.com/profile/21809193";

        WebElement cookieOkButtonWebElement = driver.findElement(cookiesOkButton);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(cookieOkButtonWebElement));


        for(String GoogleWindow : driver.getWindowHandles()){
            driver.switchTo().window(GoogleWindow);
        }

        Thread.sleep(4000);

        signInWithFaceBook.enterFacebookAccount("marialucia00@mail.ru");
        signInWithFaceBook.facebookSignInPasswordClick();
        signInWithFaceBook.enterFacebookPassword("maria555");
        signInWithFaceBook.FacebookSignInButtonAfterPassword();


        Thread.sleep(4000);

        for(String SololearnWindow : driver.getWindowHandles()){
            driver.switchTo().window(SololearnWindow);
        }

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(facebookProfileURL));
        String expectedFacebookUrl = facebookProfileURL;
        String actualFacebookUrl = driver.getCurrentUrl();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(facebookProfileURL));
        Assert.assertEquals(expectedFacebookUrl, actualFacebookUrl);

    }

}

