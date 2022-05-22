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

public class OnboardingTest extends BaseClass {


    @Test
    public void onboardingTest() throws InterruptedException {
        //Sign up with Email

        driver.get(prodHomepageURL);

        OnboardingElements onboardingSteps = new OnboardingElements();
        SignInElements forUserEmail = new SignInElements();

        //Click Cookies Ok button and Register button in homePage
        SignInElements cookiesButton = new SignInElements();
        cookiesButton.cookiesOkButtonClick();
        onboardingSteps.registerButtonClick();

        //check that landed into signup url
        String expectedAuthSignUpPageURL = "https://www.sololearn.com/onboarding/auth/signup";
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectedAuthSignUpPageURL));
        String actualAuthSignUpPageURL = driver.getCurrentUrl();
        Assert.assertEquals(actualAuthSignUpPageURL, expectedAuthSignUpPageURL);

        //Signup with email
        Random randomUsername = new Random();
        int randomNumbers = randomUsername.nextInt();

        forUserEmail.enterUserEmail("test" + randomNumbers + "@sololearn.com");
        onboardingSteps.enterUsername("test");
        forUserEmail.enterPassword("123456");
        onboardingSteps.signUpButtonClick();

        //check Survey courses url
        String ExpectedOnboardingSurveyURL = "https://www.sololearn.com/onboarding/onboardingSurveyCourses";
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.urlToBe(ExpectedOnboardingSurveyURL));
        String actualUrlOnboardingSurvey = driver.getCurrentUrl();
        Assert.assertEquals(actualUrlOnboardingSurvey, ExpectedOnboardingSurveyURL);

        //Check the text of Survey, count of buttons
        String ActualSurveyCoursesTitle = driver.findElement(By.className("sl-obrd-survey-page__cont__title")).getText();
        String ExpectedSurveyCoursesTitle = "Do you already know which course you want to take?";
        Assert.assertEquals(ActualSurveyCoursesTitle, ExpectedSurveyCoursesTitle);

        List<WebElement> surveyCoursesOptions = driver.findElements(By.cssSelector("[type='button']"));
        int ActualSurveyCoursesOptions = surveyCoursesOptions.size();
        Assert.assertEquals(ActualSurveyCoursesOptions, 2);

        WebElement NoPleaseRecommendMeOneButton = driver.findElement(By.xpath("//*[contains(text(),'No, please recommend me one.')]"));

        NoPleaseRecommendMeOneButton.click();

        String ExpectedCategoryPageTitle = "What would you like to create?";
        String ActualCategoryPageTitle = driver.findElement(By.className("sl-obrd-course-recommendation__title")).getText();
        Assert.assertEquals(ActualCategoryPageTitle, ExpectedCategoryPageTitle);

        String ExpectedCategoryPageText = "We’ll recommend the best programming languages for beginners.";
        String ActualCategoryPageText = driver.findElement(By.className("sl-obrd-course-recommendation__desc")).getText();
        Assert.assertEquals(ActualCategoryPageText, ExpectedCategoryPageText);

        List<WebElement> CoursesCategories = driver.findElements(By.className("sl-onbrd-select-button"));
        int countOfCategories = CoursesCategories.size();
        Assert.assertEquals(countOfCategories, 6);

        String[] expectedCategoriesNames = {"\uD83D\uDCF1\n" + "Mobile apps", "\uD83D\uDDA5️\n" + "Websites",
                "\uD83D\uDC7E\n" + "Games for mobile and web",
                "⚙️\n" + "Backend systems", "\uD83D\uDCCA\n" + "Data science"};

        for (int actualCoursesNames = 0; actualCoursesNames <countOfCategories-1; actualCoursesNames++) {
            String actualName = CoursesCategories.get(actualCoursesNames).getText();
            Assert.assertEquals(actualName, expectedCategoriesNames[actualCoursesNames]);
        }

        //go back and click "Yes I Know what I want" button
        driver.navigate().back();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(ExpectedOnboardingSurveyURL));
        WebElement YesIKnowWhatIWantButton = driver.findElement(By.xpath("//*[contains(text(),'Yes, I know what course I want.')]"));
        YesIKnowWhatIWantButton.click();

        //check course selection url
        String ExpectedUrlCourseSelection = "https://www.sololearn.com/onboarding/courseSelection";
        String ActualUrlCourseSelection = driver.getCurrentUrl();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(ExpectedUrlCourseSelection));
        Assert.assertEquals(ActualUrlCourseSelection, ExpectedUrlCourseSelection);

       //check the title and text
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
                "HTML","Python for Beginners","Coding for Marketers","Python Core","C++",
                "Java","JavaScript","Intermediate Python","Python Data Structures",
                "Python for Data Science","Angular + NestJS","C","C#",
                "Web Development Fundamentals","CSS","Game Development with JS",
                "Data Science","jQuery","Kotlin","Machine Learning","PHP","React + Redux",
                "Responsive Web Design","Ruby","SQL","Swift 4","Go","R","Python for Finance"
        };

        for (int course = 0; course <=  ActualCoursesCount-1; course++) {
            String courseName = CoursesCount.get(course).getText();
            Assert.assertEquals(courseName, expectedCoursesName[course]);
        }

        //click the secong (PFB) course
        CoursesCount.get(1).click();

        //check motivational page url
        String ExpectedUrlMotivational = "https://www.sololearn.com/onboarding/motivational";
        String ActualUrlMotivational = driver.getCurrentUrl();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(ExpectedUrlMotivational));
        Assert.assertEquals(ExpectedUrlMotivational, ActualUrlMotivational);

        //check if PFB icon exits
        By actualIconPFB = By.cssSelector("[class='sl-motivational--v1__cont__icon'] [src = 'https://sololearnuploads.azureedge.net/uploads/courses/1172.png']");
        boolean actualIconPFBExists = driver.findElements(actualIconPFB).size() ==1;
        Assert.assertEquals(true, actualIconPFBExists, "Course Icon");

        //check PFB motivational title
        String expectedMotivationalPageTitle = "Python for Beginners is a great choice!";
        String actualMotivationalPageTitle = driver.findElement(By.className("sl-motivational--v1__cont__title")).getText();
        Assert.assertEquals(expectedMotivationalPageTitle, actualMotivationalPageTitle);

        //check PFB motivational texts
        String expectedMotivationalPageText =
                "Remember, learning is often challenging, but some of the most worthwhile things in life are. Sololearn is here to help you every step of your journey.";
        String actualMotivationalPageText = driver.findElement(By.className("sl-motivational--v1__cont__desc")).getText();
        Assert.assertEquals(expectedMotivationalPageText, actualMotivationalPageText);

        String expectedMotivationalBottomText = "Consistency takes our users to their chosen careers";
        String actualMotivationalBottomText = driver.findElement(By.className("sl-motivational--v1__cont__mot")).getText();
        Assert.assertEquals(expectedMotivationalBottomText, actualMotivationalBottomText);

        //click Continue button
        WebElement motivationalContinue = driver.findElement(By.className("sl-onbrd-action-btn--primary"));
        motivationalContinue.click();
        String ExpectedUrlQuestionExperience = "https://www.sololearn.com/onboarding/questionExperience";
        String ActualUrlQuestionExperience = driver.getCurrentUrl();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(ExpectedUrlQuestionExperience));
        Assert.assertEquals(ExpectedUrlQuestionExperience, ActualUrlQuestionExperience);

        //check experience buttons count and names
        List <WebElement> experienceButtonsNumbers =
                driver.findElements(By.cssSelector("[class*='sl-obrd-exp__cont__items'] [type = 'button']"));
        int actualexperienceButtonsNumbers = experienceButtonsNumbers.size();
        Assert.assertEquals(actualexperienceButtonsNumbers, 3);

        String [] expectedExperienceButtonsNames =
                {"I'm totally new to coding", "I know a little about coding", "I know a lot about coding"};

        for (int experienceButtonName=0; experienceButtonName<=actualexperienceButtonsNumbers-1; experienceButtonName++){
            String actualExperienceButtonName = experienceButtonsNumbers.get(experienceButtonName).getText();
            Assert.assertEquals(expectedExperienceButtonsNames[experienceButtonName], actualExperienceButtonName);
        }

        //click I know a lot about coding
        WebElement IKnowALotAboutCoding = driver.findElement(By.className("sl-onbrd-select-button"));
        IKnowALotAboutCoding.click();

        //check URL and title in Describe yourself
        String ExpectedUrlQuestionAvailability = "https://www.sololearn.com/onboarding/questionAvailability";
        String ActualUrlQuestionAvailability = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlQuestionAvailability, ActualUrlQuestionAvailability);
        String expectedQuestionAvailabilityTitle = "How would you describe yourself?";
        String actualQuestionAvailabilityTitle = driver.findElement(By.className("sl-obrd-surv__cont__title")).getText();
        Assert.assertEquals(expectedQuestionAvailabilityTitle, actualQuestionAvailabilityTitle);

        //check describe yourself buttons count and names
        List <WebElement> describeYourselfQuestions= driver.findElements(By.xpath("//button/p"));

        int numberOfDescribeYourselfQuestions = describeYourselfQuestions.size();
        Assert.assertEquals(numberOfDescribeYourselfQuestions, 5);


        String [] describeYourselfQuestionNames = {"Technical Professional (I work with code as a dev or data scientist)",
                "Student (With plenty of time to learn)", "Hobbyist (This is just a hobby for me, not my whole life)",
                "Business Person (I have technical aspects to my job)"};

        for (String describeYourselfQuestionName : describeYourselfQuestionNames) {
            Assert.assertTrue(driver.findElements( By.xpath("//button/p[.='"+describeYourselfQuestionName+"']") ).size() == 1);
        }

        Assert.assertTrue(driver.
                findElements( By.xpath("//button/p[.=\"Non-technical Newbie (I'm looking to reskill myself)\"]") ).size() == 1);


        //click Non-technical newbiew button
        WebElement nonTechnicalNewbie = driver.findElement(( By.xpath("//button/p[.=\"Non-technical Newbie (I'm looking to reskill myself)\"]") ));
        nonTechnicalNewbie.click();

        //check daily goal URL, title and body texts
        String ExpectedUrlQuestionPace = "https://www.sololearn.com/onboarding/questionPace";
        String ActualUrlQuestionPace = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlQuestionPace, ActualUrlQuestionPace);

        String actualQuestionPaceTitle = driver.findElement(By.className("sl-obrd-set-a-goal__cont__title")).getText();
        String expectedQuestionPaceTitle = "Set a daily learning goal and we’ll keep you on track!";
        Assert.assertEquals(actualQuestionPaceTitle, expectedQuestionPaceTitle);

        String actualQuestionPaceText = driver.findElement(By.className("sl-obrd-set-a-goal__cont__desc")).getText();
        String expectedQuestionPaceText = "Usually 1 lesson takes around 5 minutes.";
        Assert.assertEquals(actualQuestionPaceText, expectedQuestionPaceText);

        //check daily goal buttons count and names
        List <WebElement> ListOfGoalButtons = driver.findElements(By.cssSelector("[type='button']"));
        int goalButtonsCount = ListOfGoalButtons.size();
        Assert.assertEquals(goalButtonsCount, 3);

        String[] expectedGoalButtonsNames = {"\uD83D\uDE43 Relaxed - 1 lesson a day", "😇 Regular - 2 lessons a day",  "\uD83E\uDDD0 Serious - 3 lessons a day"};

        for (int goalButtonsName =0; goalButtonsName<=goalButtonsCount-1; goalButtonsName++ ) {
            String actualGoalButtonsName= ListOfGoalButtons.get(goalButtonsName).getText();
            Assert.assertEquals(actualGoalButtonsName, expectedGoalButtonsNames[goalButtonsName]);
        }

        //click the first goal (Relaxed - 1 lesson a day)
        ListOfGoalButtons.get(0).click();

        //check age page url and title text
        String ExpectedUrlQuestionAge = "https://www.sololearn.com/onboarding/questionAge";
        String ActualUrlQuestionAge = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlQuestionAge, ActualUrlQuestionAge);

        String actualQuestionAgeTitle = driver.findElement(By.className("sl-obrd-age__cont__title")).getText();
        String expectedQuestionAgeTitle = "What's your age?";
        Assert.assertEquals(actualQuestionAgeTitle,expectedQuestionAgeTitle );

        //check age buttons count and names
        List <WebElement> ListOfAges= driver.findElements(By.cssSelector("[class='sl-obrd-age__cont__items'] [type='button']"));
        int ListOfAgesCount = ListOfAges.size();
        Assert.assertEquals(ListOfAgesCount, 5);

        String[] expectedAges = {"13 - 18", "19 – 24", "25 – 34", "35 – 44", "More than 45"};
        for(int userAge =0; userAge<=ListOfAgesCount-1; userAge++){
            String actualUserAge = ListOfAges.get(userAge).getText();
            Assert.assertEquals(actualUserAge, expectedAges[userAge]);
        }

        //click "19-24" button
        ListOfAges.get(1).click();

        //check loading screen url and texts
        String ExpectedUrlLoadingScreen = "https://www.sololearn.com/onboarding/loadingScreen";
        String ActualUrlLoadingScreen = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlLoadingScreen, ActualUrlLoadingScreen);

        WebElement continueLoadingScreen = driver.findElement(By.className("sl-onbrd__action-btn"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(continueLoadingScreen));

        String actualLoadingScreenTitle = driver.findElement(By.className("sl-onbrd-psycho-loading__title")).getText();
        String expectedLoadingScreenTitle1= "Hang tight! We’re developing your learning plan";
        String expectedLoadingScreenTitle2= "Hang tight!";

        Assert.assertTrue(actualLoadingScreenTitle.equals(expectedLoadingScreenTitle1)
                || actualLoadingScreenTitle.equals(expectedLoadingScreenTitle2),"Actual Loading Screen Title is wrong");

        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='sl-progress-bar__completed-text']")));

        String actualLearningPlanReadyText = driver.findElement((By.cssSelector("[class='sl-progress-bar__completed-text']"))).getText();
        String expectedLearningPlanReadyText1 = "Your learning plan is ready, test!";
        String expectedLearningPlanReadyText2 = "That's all, test";
        Assert.assertTrue((actualLearningPlanReadyText.equals(expectedLearningPlanReadyText1) ||
                actualLearningPlanReadyText.equals(expectedLearningPlanReadyText2)));

        String actualProgressBarCompletedText = driver.findElement(By.className("sl-progress-bar__completed-text")).getText();
        String expectedProgressBarCompletedText1 = "Your learning plan is ready, test!";
        String expectedProgressBarCompletedText2 = "That's all, test";
        String expectedLoadingDescription = "Hold on for a few seconds while we're developing your custom learning plan.";
        Assert.assertTrue(actualProgressBarCompletedText.equals(expectedProgressBarCompletedText1) ||
                        actualProgressBarCompletedText.equals(expectedProgressBarCompletedText2),
                "Progress Bar Completed text or Loading description is wrong");

        //"Continue" or "Thanks" button
        continueLoadingScreen.click();

        //check learning plan url
        String ExpectedUrlLearningPlan = "https://www.sololearn.com/onboarding/learningPlan";
        String ActualUrlLearningPlan = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlLearningPlan, ActualUrlLearningPlan);

        //click Continue button
        WebElement continueLearningPlan = driver.findElement(By.className("sl-onbrd-learn-plan__action-btn"));
        continueLearningPlan.click();

        //check Onboarding payment url
        String ExpectedUrlOnboardingPROpage = "https://www.sololearn.com/onboarding/payment";
        String ActualUrlOnboardingPROpage = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlOnboardingPROpage, ActualUrlOnboardingPROpage);

        //click "Start my 14-day free trial"
        WebElement startMy14_DayFreeTrial = driver.findElement(By.className("sl-trial-page__timeline__button"));
        startMy14_DayFreeTrial.click();

        //check payment page url and go back
        String expectedPaymentPage= "https://www.sololearn.com/onboarding/checkout/7?returnUrl=/learning/1172&source=psycho";
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectedPaymentPage));
        String actualPaymentPage= driver.getCurrentUrl();
        Assert.assertEquals(actualPaymentPage, expectedPaymentPage);
        driver.navigate().back();

        //close pro page
        By NoThanksIllTryProLater = By.className("sl-trial-page__close-icon");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(NoThanksIllTryProLater));
        driver.findElement(NoThanksIllTryProLater).click();

        //check that landed into PFB course
        String ExpectedUrlCourseId = "https://www.sololearn.com/learning/1172";
        String ActualUrlCourseId = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrlCourseId, ActualUrlCourseId);

    }
}



