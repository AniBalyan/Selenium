package Testing;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Singup extends BaseClass {
    public Singup() {
    }


    @Test
    public void SignUp_Page_Title_Validation() throws InterruptedException {

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

        Random randomUsername = new Random();
        int randomNumbers = randomUsername.nextInt();

        Email.sendKeys("test" + randomNumbers + "@sololearn.com");

        Name.sendKeys("test");
        Password.sendKeys("123456");
        Signup.click();
        Thread.sleep(5000);
        WebElement OnboardingSurveyCourse = driver.findElement(By.xpath("//*[contains(text(),'Yes, I know what course I want.')]"));
        OnboardingSurveyCourse.click();

        String ExpectedCourseSelectionTitle = "Select your first course";
        String ActualCourseSelectionTitle = driver.findElement(By.className("sl-onbrd-courses__cont__title")).getText();

        Assert.assertEquals(ExpectedCourseSelectionTitle, ActualCourseSelectionTitle);

        String ExpectedCourseSelcetionText = "Don’t worry, you can add as many courses as you want later.";
        String ActualCourseSelectionText = driver.findElement(By.className("sl-onbrd-courses__cont__text")).getText();
        Assert.assertEquals(ExpectedCourseSelcetionText, ActualCourseSelectionText);

        List<WebElement> CoursesCount = driver.findElements(By.className("sl-course-item"));
        int ExpectedCoursesCount = CoursesCount.size();
        int ActualCoursesCount = 29;
        Assert.assertEquals(ExpectedCoursesCount, ActualCoursesCount);


        List<WebElement> AllCourses = driver.findElements(By.cssSelector("div.sl-course-item__info p.sl-course-item__info__title"));

        for (int course = 0; course < AllCourses.size()-1; course++) {
        }

           String HTML = AllCourses.get(0).getText();
           String ExpectedHTML = "HTML";
           Assert.assertEquals(HTML, ExpectedHTML);

           String PythonForBeginners = AllCourses.get(1).getText();
           String ExpectedPythonForBeginners = "Python for Beginners";
           Assert.assertEquals(PythonForBeginners, ExpectedPythonForBeginners);

           String CodingForMarketers = AllCourses.get(2).getText();
           String ExpectedCodingForMarketers = "Coding for Marketers";
           Assert.assertEquals(CodingForMarketers, ExpectedCodingForMarketers);

           String PythonCore = AllCourses.get(3).getText();
           String ExpectedPythonCore = "Python Core";
           Assert.assertEquals(PythonCore, ExpectedPythonCore);

           String CPP = AllCourses.get(4).getText();
           String ExpectedCPP = "C++";
           Assert.assertEquals(CPP, ExpectedCPP);

           String Java = AllCourses.get(5).getText();
           String ExpectedJava = "Java";
           Assert.assertEquals(Java, ExpectedJava);

           String JavaScript = AllCourses.get(6).getText();
           String ExpectedJavascript = "JavaScript";
           Assert.assertEquals(JavaScript, ExpectedJavascript);

           String IntermediatePython = AllCourses.get(7).getText();
           String ExpextedIntermediatePython = "Intermediate Python";
           Assert.assertEquals(IntermediatePython, ExpextedIntermediatePython);

           String PythonDataStructures = AllCourses.get(8).getText();
           String ExpectedPythonDataStructures = "Python Data Structures";
           Assert.assertEquals(PythonDataStructures, ExpectedPythonDataStructures);

           String PythonForDataScience = AllCourses.get(9).getText();
           String ExpectedPythonForDataScience = "Python for Data Science";
           Assert.assertEquals(PythonForDataScience, ExpectedPythonForDataScience);

           String AngularNestJS = AllCourses.get(10).getText();
           String ExpectedAngularNestJS = "Angular + NestJS";
           Assert.assertEquals(AngularNestJS, ExpectedAngularNestJS);

           String C = AllCourses.get(11).getText();
           String ExpectedC = "C";
           Assert.assertEquals(C, ExpectedC);

           String CSharp = AllCourses.get(12).getText();
           String ExpectedCSharp = "C#";
           Assert.assertEquals(CSharp, ExpectedCSharp);

           String WebDevelopmentFundamentals = AllCourses.get(13).getText();
           String ExpectedWebDevelopmentFundamentals = "Web Development Fundamentals";
           Assert.assertEquals(WebDevelopmentFundamentals, ExpectedWebDevelopmentFundamentals);

           String CSS = AllCourses.get(14).getText();
           String ExpectedCSS = "CSS";
           Assert.assertEquals(CSS, ExpectedCSS);

           String GameDevelopmentWithJS = AllCourses.get(15).getText();
           String ExpectedGameDevelopmentWithJS = "Game Development with JS";
           Assert.assertEquals(GameDevelopmentWithJS, ExpectedGameDevelopmentWithJS);

           String DataScience = AllCourses.get(16).getText();
           String ExpectedDataScience = "Data Science";
           Assert.assertEquals(DataScience, ExpectedDataScience);

           String jQuery = AllCourses.get(17).getText();
           String ExpectedJQuery = "jQuery";
           Assert.assertEquals(jQuery, ExpectedJQuery);

           String Kotlin = AllCourses.get(18).getText();
           String ExpectedKotlin = "Kotlin";
           Assert.assertEquals(Kotlin, ExpectedKotlin);

           String MachineLearning = AllCourses.get(19).getText();
           String ExpectedMachineLearning = "Machine Learning";
           Assert.assertEquals(MachineLearning, ExpectedMachineLearning);

           String PHP = AllCourses.get(20).getText();
           String ExpectedPHP = "PHP";
           Assert.assertEquals(PHP, ExpectedPHP);

           String ReactRedux = AllCourses.get(21).getText();
           String ExpectedReactRedux = "React + Redux";
           Assert.assertEquals(ReactRedux, ExpectedReactRedux);

           String ResponsiveWebDesign = AllCourses.get(22).getText();
           String ExpectedResponsiveWebDesign = "Responsive Web Design";
           Assert.assertEquals(ResponsiveWebDesign, ExpectedResponsiveWebDesign);

           String Ruby = AllCourses.get(23).getText();
           String ExpectedRuby = "Ruby";
           Assert.assertEquals(Ruby, ExpectedRuby);

           String SQL = AllCourses.get(24).getText();
           String ExpectedSQL = "SQL";
           Assert.assertEquals(SQL, ExpectedSQL);

           String Swift4 = AllCourses.get(25).getText();
           String ExpectedSwift4 = "Swift 4";
           Assert.assertEquals(Swift4, ExpectedSwift4);

           String Go = AllCourses.get(26).getText();
           String ExpectedGo = "Go";
           Assert.assertEquals(Go, ExpectedGo);

           String R = AllCourses.get(27).getText();
           String ExpectedR = "R";
           Assert.assertEquals(R, ExpectedR);

           String PythonForFinance = AllCourses.get(28).getText();
           String ExpectedPythonForFinance = "Python for Finance";
           Assert.assertEquals(PythonForFinance, ExpectedPythonForFinance);


        }
    }





