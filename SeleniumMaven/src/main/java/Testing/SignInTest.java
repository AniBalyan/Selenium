package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class SignInTest extends BaseClass {

    @Test(priority = 1)
    public void EmptyFieldsTest() {

        driver.get(devLoginURL);

        SignInElements emptyFieldsTest = new SignInElements();
        emptyFieldsTest.cookiesOkButtonClick();
        emptyFieldsTest.enterUserEmail("");
        emptyFieldsTest.enterPassword("");

        WebElement webElementSignInButton = driver.findElement(SignInElements.signInButton);
        boolean isSignInButtonEnabled = webElementSignInButton.isEnabled();
        Assert.assertEquals(false, isSignInButtonEnabled);

    }

    @Test(priority = 2)
    public void validSignInWithEmail(){

        SignInElements validSignInTest = new SignInElements();
        validSignInTest.clickUserEmailField();
        validSignInTest.enterUserEmail("forbits1@sololearn.com");
        validSignInTest.enterPassword("123456");
        SignInElements.clickSignIn();

        String expectedProfileUrl = "https://web-dev.sololearn.com/profile/21413224";
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectedProfileUrl));
        String actualProfileUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedProfileUrl, actualProfileUrl);

        SignOutElements signOut = new SignOutElements();
        signOut.userAvatarIconClick();
        signOut.logoutButtonClick();
        SignInElements signInFromHomePage = new SignInElements();
        signInFromHomePage.LoginButtonHomePageClick();

    }

    @Test(priority = 3)
    public void WrongPasswordTest() throws InterruptedException {

        SignInElements wrongPassword = new SignInElements();

        Random randomUsername = new Random();
        int randomNumbers = randomUsername.nextInt();

        wrongPassword.clickUserEmailField();
        wrongPassword.enterUserEmail("test" + randomNumbers + "@sololearn.com");
        wrongPassword.enterPassword("1234567");
        wrongPassword.clickSignIn();

        By ActualWrongPasswordErrorMessage = By.cssSelector("[class='sl-login-error']");
        String ExpectedErrorMessage = "Invalid username or password.";

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(ActualWrongPasswordErrorMessage));
        String ActualErrorMessage = driver.findElement(ActualWrongPasswordErrorMessage).getText();
        Assert.assertEquals(ExpectedErrorMessage, ActualErrorMessage);

    }

    @Test(priority = 4)
    public void forgotPasswordTest() throws InterruptedException {

        ForgotPasswordElements forgotPassword = new ForgotPasswordElements();
        forgotPassword.forgotPasswordButtonClick();

        String ExpectedForgotPasswordURL = "https://web-dev.sololearn.com/User/ForgotPassword/";
        String ActualForgotPasswordURL = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedForgotPasswordURL, ActualForgotPasswordURL);

        forgotPassword.enterEmailForPasswordRecovery("ani.balyan@sololearn.com");
        forgotPassword.recoverButtonClick();

        String ActualMessageEmailSent = driver.findElement(By.cssSelector("div.block p")).getText();
        String ExpectedMessageEmailSent = "We just sent you an email containing further instructions.";
        Assert.assertEquals(ActualMessageEmailSent, ExpectedMessageEmailSent);

        driver.navigate().back();
        driver.navigate().back();

    }

    @Test(priority = 5)
    public void FacebookSignIn() throws InterruptedException {

        FacebookSignInElements signInWithFaceBook = new FacebookSignInElements();
        signInWithFaceBook.FacebookLoginClick();

        for (String GoogleWindow : driver.getWindowHandles()) {
            driver.switchTo().window(GoogleWindow);
        }

        signInWithFaceBook.enterFacebookAccount("marialucia00@mail.ru");
        signInWithFaceBook.facebookSignInPasswordClick();
        signInWithFaceBook.enterFacebookPassword("maria555");
        signInWithFaceBook.FacebookSignInButtonAfterPassword();

        Thread.sleep(4000);

        for (String SololearnWindow : driver.getWindowHandles()) {
            driver.switchTo().window(SololearnWindow);
        }

        String facebookProfileURL = "https://web-dev.sololearn.com/profile/21809193";
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(facebookProfileURL));
        String expectedFacebookUrl = facebookProfileURL;
        String actualFacebookUrl = driver.getCurrentUrl();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(facebookProfileURL));
        Assert.assertEquals(expectedFacebookUrl, actualFacebookUrl);

        SignOutElements signOutFromFBAccount = new SignOutElements();
        signOutFromFBAccount.userAvatarIconClick();
        signOutFromFBAccount.logoutButtonClick();
        SignInElements signInFromHomePage = new SignInElements();
        signInFromHomePage.LoginButtonHomePageClick();
    }
    @Test (priority = 6)
    public void GoogleSignInTest() throws InterruptedException {

        GoogleSignInElements googleSign = new GoogleSignInElements();
        googleSign.googleSignInButtonClick();

        for (String GoogleWindow : driver.getWindowHandles()) {
            driver.switchTo().window(GoogleWindow);
        }

        googleSign.enterGoogleAccount("soliktesting@gmail.com");
        googleSign.NextAfterGoogleAccountClick();
        googleSign.enterGooglePassword("Testsolo1");
        googleSign.NextAfterGooglePasswordClick();

        String expectedGoogleProfileUrl = "https://web-dev.sololearn.com/profile/22810607";

        Thread.sleep(4000);

        for (String SololearnWindow : driver.getWindowHandles()) {
            driver.switchTo().window(SololearnWindow);
        }
        Thread.sleep(4000);

        String actualGoogleProfileUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedGoogleProfileUrl, actualGoogleProfileUrl);

        SignOutElements signOutFromGoogleAccount = new SignOutElements();
        signOutFromGoogleAccount.userAvatarIconClick();
        signOutFromGoogleAccount.logoutButtonClick();
    }

    @Test (priority = 7)

    public void notActivatedUserSignIn() throws InterruptedException{

        SignInElements notActivatedUser = new SignInElements();
        SignInElements signInFromHomePage = new SignInElements();
        signInFromHomePage.LoginButtonHomePageClick();
        notActivatedUser.clickUserEmailField();
        notActivatedUser.enterUserEmail("forbits@sololearn.com");
        notActivatedUser.enterPassword("123456");
        SignInElements.clickSignIn();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("sl-login-error")));

        String expectedMessageNonActivatedUser = "Your account is not activated. Please check your email for activation instructions.";
        String actualMessageNonActivatedUser = driver.findElement(By.className("sl-login-error")).getText();
        Assert.assertEquals(actualMessageNonActivatedUser,expectedMessageNonActivatedUser );
    }
    }