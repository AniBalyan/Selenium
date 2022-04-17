package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TermsOfUseAndService extends BaseClass {


    @Test
    public void Terms () throws InterruptedException {

        driver.get("https://www.sololearn.com/users/login");
        Thread.sleep(4000L);
        WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
        Ok.click();

        WebElement CreateAnAccount = driver.findElement(By.className("sl-login-switch-link__link"));
        CreateAnAccount.click();
        String actualUrlSignUp = "https://www.sololearn.com/users/signup";
        Thread.sleep(4000L);
        String expectedUrlSignUp = driver.getCurrentUrl();
        Thread.sleep(4000L);
        Assert.assertEquals(expectedUrlSignUp, actualUrlSignUp);

        WebElement GooglePrivacyPolicy = driver.findElement(By.linkText("Privacy Policy"));
        GooglePrivacyPolicy.click();

        String expectedPrivacyPolicyURL = "https://policies.google.com/privacy";
        String actualPrivacyPolicyURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedPrivacyPolicyURL, actualPrivacyPolicyURL);
        Thread.sleep(4000);
        driver.navigate().back();
        Thread.sleep(4000);

        WebElement TermsOfService = driver.findElement(By.linkText("Terms of Service"));
        TermsOfService.click();

        String expectedTermsOfServiceURL = "https://policies.google.com/terms";
        String actualTermsOfServiceURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedTermsOfServiceURL, actualTermsOfServiceURL);
        Thread.sleep(4000);
        driver.navigate().back();
        Thread.sleep(4000);

        WebElement TermsOfUse = driver.findElement(By.linkText("Terms of Use"));
        TermsOfUse.click();

        String expectedTermsOfUseURL = "https://www.sololearn.com/terms-of-use/";
        String actualTermsOfUseURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedTermsOfUseURL, actualTermsOfUseURL);


    }
}
