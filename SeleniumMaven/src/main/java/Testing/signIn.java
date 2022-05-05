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

public class signIn extends BaseClass {

    @Test
    public void SignInWithEmail()  {

        driver.get(devLoginURL);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(cookiesOkButton));
        driver.findElement(cookiesOkButton).click();

        driver.findElement(userEmail).sendKeys("forbits1@sololearn.com");
        driver.findElement(password).sendKeys("123456");
        driver.findElement(signIn).click();

        String expectedProfileUrl="https://web-dev.sololearn.com/profile/21413224";
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectedProfileUrl));
        String actualProfileUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedProfileUrl, actualProfileUrl);
    }

}