package Testing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OnboardingPass {
    public OnboardingPass() {
    }

    @BeforeTest
    public void Begin() {
        System.out.println("testing has been started");
    }

    @Test
    public void Onboarding() throws InterruptedException {
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
        Email.sendKeys(new CharSequence[]{"gkngyghihijkkkjij@sololearn.com"});
        Name.sendKeys(new CharSequence[]{"test"});
        Password.sendKeys(new CharSequence[]{"123456"});
        Signup.click();
        String expectedUrlOnboardingSurvey="https://www.sololearn.com/onboarding/onboardingSurveyCourses";
        Thread.sleep(4000);
        String actualUrlOnboardingSurvey= driver.getCurrentUrl();
        Thread.sleep(4000);
        Assert.assertEquals(actualUrlOnboardingSurvey, expectedUrlOnboardingSurvey);

        WebElement OnboardingSurveyCourse = driver.findElement(By.className("sl-onbrd-select-button"));
        OnboardingSurveyCourse.click();
        String ExpectedUrlCourseSelection = "https://www.sololearn.com/onboarding/courseSelection";
        String ActualUrlCourseSelection = driver.getCurrentUrl();
        Thread.sleep(4000);
        Assert.assertEquals(ExpectedUrlCourseSelection, ActualUrlCourseSelection);

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
        Assert.assertEquals(ExpectedUrlQuestionPace, ActualUrlQuestionPace );

        WebElement Relaxed = driver.findElement(By.className("sl-onbrd-select-button"));
        Relaxed.click();
        String ExpectedUrlQuestionAge = "https://www.sololearn.com/onboarding/questionAge";
        String ActualUrlQuestionAge  = driver.getCurrentUrl();
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
        Assert.assertEquals(ExpectedUrlLearningPlan,ActualUrlLearningPlan );

        WebElement continueLearningPlan = driver.findElement(By.className("sl-onbrd-learn-plan__action-btn"));
        continueLearningPlan.click();
        String ExpectedUrlPayment = "https://www.sololearn.com/onboarding/payment";
        String ActualUrlPayment = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlPayment, ActualUrlPayment);


       WebElement NoThanksIllTryProLater = driver.findElement(By.className("sl-onbrd-psycho-pro__skip"));
       NoThanksIllTryProLater.click();
       String ExpectedUrlCourseId = "https://www.sololearn.com/learning/1172";
       String ActualUrlCourseId = driver.getCurrentUrl();
       Assert.assertEquals(ExpectedUrlCourseId, ActualUrlCourseId);


    }

    @AfterTest
    public void After_Test() {
        System.out.println("testing finsihed");
    }
}
