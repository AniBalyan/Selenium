package Testing;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
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
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated((By.id("CybotCookiebotDialogBodyLevelButtonAccept"))));
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

        String ExpectedCourseSelectionText = "Don’t worry, you can add as many courses as you want later.";
        String ActualCourseSelectionText = driver.findElement(By.className("sl-onbrd-courses__cont__text")).getText();
        Assert.assertEquals(ExpectedCourseSelectionText, ActualCourseSelectionText);


        //Check courses count, ordering and names
        List<WebElement> CoursesCount = driver.findElements(By.cssSelector("p.sl-course-item__info__title"));

        int ActualCoursesCount = CoursesCount.size();
        Assert.assertEquals(ActualCoursesCount, 29);

        String[] expectedCoursesName = {
                "HTML","Python for Beginners","Coding for Marketers","Python Core","C++","Java","JavaScript","Intermediate Python","Python Data Structures","Python for Data Science","Angular + NestJS","C","C#","Web Development Fundamentals","CSS","Game Development with JS","Data Science","jQuery","Kotlin","Machine Learning","PHP","React + Redux","Responsive Web Design","Ruby","SQL","Swift 4","Go","R","Python for Finance"
        };

        for (int course = 0; course <  ActualCoursesCount-1; course++) {
            String HTML = CoursesCount.get(course).getText();
            Assert.assertEquals(HTML, expectedCoursesName[course]);
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


