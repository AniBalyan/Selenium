package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

 public  static WebDriver driver;

    String devLoginURL = "https://web-dev.sololearn.com/users/login";
    String prePreprodLoginURL= "https://preprod.sololearn.com/users/login";
    String prodLoginUrl = "https://sololearn.com/users/login";
    String prodHomepageURL = "https://www.sololearn.com/home";


    @BeforeTest
    public void Begin() {
        System.out.println("testing has been started");
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sololearn\\Downloads\\chromedriver100\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @AfterTest
    public void After_Test() {
        System.out.println("testing finsihed");
        driver.quit();

    }
}

