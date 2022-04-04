package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TermsOfUseAndService {


    @BeforeTest
    public void Begin() {
        System.out.println("testing has been started");
    }

    @Test
    public void SignUp_Page_Title_Validation() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sololearn\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
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

        WebElement GooglePrivacyPolicy = driver.findElement(By.cssSelector
                ("[class = 'recaptcha-info'] [href ='<a href=\"https://policies.google.com/privacy\">Privacy Policy</a>']"));
        GooglePrivacyPolicy.click();



        driver.quit();
    }

    @AfterTest
    public void After_Test() {
        System.out.println("testing finsihed");
    }
}
