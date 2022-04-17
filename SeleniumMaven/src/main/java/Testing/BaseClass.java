package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

 public  WebDriver driver;

    @BeforeTest
    public void Begin() {
        System.out.println("testing has been started");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sololearn\\Downloads\\chromedriver100\\chromedriver.exe");
         driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @AfterTest
    public void After_Test() {
        System.out.println("testing finsihed");
   //driver.quit();

    }
}