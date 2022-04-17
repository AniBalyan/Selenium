package Testing;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

import static java.time.Duration.ofSeconds;

public class OnboardingPass extends BaseClass {

    @Test
    public void SignUp() throws InterruptedException {
        //Sign up with Email

        driver.get("https://www.sololearn.com/home");
        Thread.sleep(5000);

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
        String expectedUrlOnboardingSurvey = "https://www.sololearn.com/onboarding/onboardingSurveyCourses";
        Thread.sleep(4000);
        String actualUrlOnboardingSurvey = driver.getCurrentUrl();
        Thread.sleep(4000);
        Assert.assertEquals(actualUrlOnboardingSurvey, expectedUrlOnboardingSurvey);
    }

    @Test
    public void SurveyCourses() throws InterruptedException {
        //Check the text of Survey, count of buttons and click "Yes, I know what I want".

        String ActualSurveyCoursesTitle = driver.findElement(By.className("sl-obrd-survey-page__cont__title")).getText();
        String ExpectedSurveyCoursesTitle = "Do you already know which course you want to take?";
        Assert.assertEquals(ActualSurveyCoursesTitle, ExpectedSurveyCoursesTitle);

        List<WebElement> surveyCoursesOptions = driver.findElements(By.cssSelector("[type='button']"));

        int ActualSurveyCoursesOptions = surveyCoursesOptions.size();
        int ExpectedSurveyCoursesOptions = 2;
        Assert.assertEquals(ActualSurveyCoursesOptions, ExpectedSurveyCoursesOptions);

        WebElement OnboardingSurveyCourse = driver.findElement(By.xpath("//*[contains(text(),'Yes, I know what course I want.')]"));
        OnboardingSurveyCourse.click(); //Yes, I know what course I want.
        String ExpectedUrlCourseSelection = "https://www.sololearn.com/onboarding/courseSelection";
        String ActualUrlCourseSelection = driver.getCurrentUrl();
        Thread.sleep(4000);
        Assert.assertEquals(ExpectedUrlCourseSelection, ActualUrlCourseSelection);
    }
    @Test
    //When landed into Courses Section, check the title and text
    public void coursesPageTexts() throws InterruptedException {
        String ExpectedCourseSelectionTitle = "Select your first course";
        String ActualCourseSelectionTitle = driver.findElement(By.className("sl-onbrd-courses__cont__title")).getText();
        Assert.assertEquals(ExpectedCourseSelectionTitle, ActualCourseSelectionTitle);

        String ExpectedCourseSelcetionText = "Don’t worry, you can add as many courses as you want later.";
        String ActualCourseSelectionText = driver.findElement(By.className("sl-onbrd-courses__cont__text")).getText();
        Assert.assertEquals(ExpectedCourseSelcetionText, ActualCourseSelectionText);
    }

    @Test
            public void CheckCourses() throws InterruptedException {
        //Check courses count, ordering and names

        List<WebElement> AllCourses = driver.findElements(By.cssSelector("div.sl-course-item__info p.sl-course-item__info__title"));

        for (int course = 0; course <  AllCourses.size() -1; course++) {

            List<WebElement> CoursesCount = driver.findElements(By.className("sl-course-item"));
            int ExpectedCoursesCount = CoursesCount.size();
            int ActualCoursesCount = 29;
            Assert.assertEquals(ExpectedCoursesCount, ActualCoursesCount);


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
    @Test
            public void otherTests() throws InterruptedException {
        WebElement SelectCourse =
                driver.findElement(By.cssSelector("[class*='sl-course-item']>[src='https://sololearnuploads.azureedge.net/uploads/courses/1172.png']"));
        SelectCourse.click();
        String ExpectedUrlMotivational = "https://www.sololearn.com/onboarding/motivational";
        String ActualUrlMotivational = driver.getCurrentUrl();
        Thread.sleep(4000);
        Assert.assertEquals(ExpectedUrlMotivational, ActualUrlMotivational);

        WebElement motivationalContinue = driver.findElement(By.className("sl-onbrd-action-btn--primary"));
        motivationalContinue.click();
        String ExpectedUrlQuestionExperience = "https://www.sololearn.com/onboarding/questionExperience";
        String ActualUrlQuestionExperience = driver.getCurrentUrl();
        Thread.sleep(4000);
        Assert.assertEquals(ExpectedUrlQuestionExperience, ActualUrlQuestionExperience);

        WebElement IKnowALotAboutCoding = driver.findElement(By.className("sl-onbrd-select-button"));
        IKnowALotAboutCoding.click();
        String ExpectedUrlQuestionAvailability = "https://www.sololearn.com/onboarding/questionAvailability";
        String ActualUrlQuestionAvailability = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlQuestionAvailability, ActualUrlQuestionAvailability);

        WebElement Student = driver.findElement(By.className("sl-onbrd-select-button"));
        Student.click();
        String ExpectedUrlQuestionPace = "https://www.sololearn.com/onboarding/questionPace";
        String ActualUrlQuestionPace = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlQuestionPace, ActualUrlQuestionPace);

        WebElement Relaxed = driver.findElement(By.className("sl-onbrd-select-button"));
        Relaxed.click();
        String ExpectedUrlQuestionAge = "https://www.sololearn.com/onboarding/questionAge";
        String ActualUrlQuestionAge = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlQuestionAge, ActualUrlQuestionAge);

        WebElement moreThan45 = driver.findElement(By.className("sl-onbrd-select-button"));
        moreThan45.click();
        String ExpectedUrlLoadingScreen = "https://www.sololearn.com/onboarding/loadingScreen";
        String ActualUrlLoadingScreen = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlLoadingScreen, ActualUrlLoadingScreen);

        WebElement continueLoadingScreen = driver.findElement(By.className("sl-onbrd__action-btn"));
        Thread.sleep(6000);
        continueLoadingScreen.click();
        String ExpectedUrlLearningPlan = "https://www.sololearn.com/onboarding/learningPlan";
        String ActualUrlLearningPlan = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlLearningPlan, ActualUrlLearningPlan);

        WebElement continueLearningPlan = driver.findElement(By.className("sl-onbrd-learn-plan__action-btn"));
        continueLearningPlan.click();

        // experiments

      /*  String ExpectedUrlPayment = "https://www.sololearn.com/onboarding/payment";
        String ActualUrlPayment = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlPayment, ActualUrlPayment);


        WebElement NoThanksIllTryProLater = driver.findElement(By.className("sl-onbrd-psycho-pro__skip"));
        NoThanksIllTryProLater.click();
        String ExpectedUrlCourseId = "https://www.sololearn.com/learning/1172";
        String ActualUrlCourseId = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlCourseId, ActualUrlCourseId); */

    }
}


