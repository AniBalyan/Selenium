package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static Testing.BaseClass.driver;

public class SignOutElements extends BaseClass {

        By userAvatarIcon = By.cssSelector("[class='sl-user__desktop'] [class='sl-user__select__image']");
        By logoutButton = By.className("sl-user-settings__profile__logout__icon");

        public void userAvatarIconClick () {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
            driver.findElement(userAvatarIcon).click();
        }

        public void logoutButtonClick () {
            driver.findElement(logoutButton).click();
        }

    }

