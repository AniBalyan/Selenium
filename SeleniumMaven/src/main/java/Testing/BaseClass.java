package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

 public  WebDriver driver;

    By userEmail = By.id("email");
    By password = By.id("password");
    By signIn = By.className("sl-login-login-form__action");
    By avatarIcon = By.className("sl-user__select__image");
    By logout = By.className("sl-user-settings__profile__logout__icon");
    String devLoginURL = "https://web-dev.sololearn.com/users/login";
    By cookiesOkButton = By.id("CybotCookiebotDialogBodyLevelButtonAccept");
    By CreateAnAccount = By.className("sl-login-switch-link__link");
    By usernameName = By.id("name");
    By SignupButton = By.className("sl-login-signup-form__action");
    By registerButton = By.className("sl-action-btn--primary");


    @BeforeTest
    public void Begin() {
        System.out.println("testing has been started");
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sololearn\\Downloads\\chromedriver100\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }catch (Exception ex){
            //System.out.println(ex.getMessage());
        }


    }

    @AfterTest
    public void After_Test() {
        System.out.println("testing finsihed");
  // driver.quit();

    }
}

