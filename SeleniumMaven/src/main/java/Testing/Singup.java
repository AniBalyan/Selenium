package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Singup {
    public Singup() {
    }

    @BeforeTest
    public void Begin() {
        System.out.println("testing has been started");
    }

    @Test
    public void SignUp_Page_Title_Validation() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sololearn\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sololearn.com/home");
        Thread.sleep(4000L);
        WebElement Register = driver.findElement(By.className("sl-action-btn--primary"));
        Register.click();
        String actualUrl = "https://www.sololearn.com/onboarding/auth/signup";
        Thread.sleep(4000L);
        String expectedUrl = driver.getCurrentUrl();
        Thread.sleep(4000L);
        Assert.assertEquals(expectedUrl, actualUrl);
        WebElement Ok = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
        Ok.click();
        WebElement Email = driver.findElement(By.id("email"));
        WebElement Name = driver.findElement(By.id("name"));
        WebElement Password = driver.findElement(By.id("password"));
        WebElement Signup = driver.findElement(By.className("sl-login-signup-form__action"));
        Email.sendKeys(new CharSequence[]{"jhvkfjhjjnjh@sololearn.com"});
        Name.sendKeys(new CharSequence[]{"test"});
        Password.sendKeys(new CharSequence[]{"123456"});
        Signup.click();
        String expectedUrlOnboardingSurvey="https://www.sololearn.com/onboarding/onboardingSurveyCourses";
        Thread.sleep(4000);
        String actualUrlOnboardingSurvey= driver.getCurrentUrl();
        Thread.sleep(4000);
        Assert.assertEquals(actualUrlOnboardingSurvey, expectedUrlOnboardingSurvey);
        driver.quit();
    }

    @AfterTest
    public void After_Test() {
        System.out.println("testing finsihed");
    }
}
