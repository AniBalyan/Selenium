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

public class TermsOfUseAndService extends BaseClass {


    @Test
    public void Terms () throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated((By.id("CybotCookiebotDialogBodyLevelButtonAccept"))));

        WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
        Ok.click();

        WebElement CreateAnAccount = driver.findElement(By.className("sl-login-switch-link__link"));
        CreateAnAccount.click();
        String actualUrlSignUp = "https://www.sololearn.com/users/signup";
        String expectedUrlSignUp = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrlSignUp, actualUrlSignUp);

        WebElement GooglePrivacyPolicy = driver.findElement(By.linkText("Privacy Policy"));
        GooglePrivacyPolicy.click();

        String expectedPrivacyPolicyURL = "https://policies.google.com/privacy";
        String actualPrivacyPolicyURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedPrivacyPolicyURL, actualPrivacyPolicyURL);
        driver.navigate().back();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe("https://www.sololearn.com/users/signup"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Terms of Service")));

        WebElement TermsOfService = driver.findElement(By.linkText("Terms of Service"));
        TermsOfService.click();

        String expectedTermsOfServiceURL = "https://policies.google.com/terms";
        String actualTermsOfServiceURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedTermsOfServiceURL, actualTermsOfServiceURL);
        driver.navigate().back();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe("https://www.sololearn.com/users/signup"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Terms of Use")));
        WebElement TermsOfUse = driver.findElement(By.linkText("Terms of Use"));
        TermsOfUse.click();

        String expectedTermsOfUseURL = "https://www.sololearn.com/terms-of-use/";
        String actualTermsOfUseURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedTermsOfUseURL, actualTermsOfUseURL);
        driver.navigate().back();


    }
}
