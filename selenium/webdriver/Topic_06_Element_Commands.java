package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_Element_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Check_Is_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement email, ageUnder18, edu, nameUser5;
        // Email
        email = driver.findElement(By.cssSelector("input#mail"));
        Assert.assertTrue(email.isDisplayed());
        if (email.isDisplayed()) {
            email.sendKeys("Automation Testing");
            System.out.println("Element 'Email' is displayed");
        } else {
            System.out.println("Element 'Email' is not displayed");
        }
        // Age under 18
        ageUnder18 = driver.findElement(By.cssSelector("input#under_18"));
        Assert.assertTrue(ageUnder18.isDisplayed());
        if (ageUnder18.isDisplayed()) {
            ageUnder18.click();
            System.out.println("Element 'Under 18' is displayed");
        } else {
            System.out.println("Element 'Under 18' is not displayed");
        }
        // Education
        edu = driver.findElement(By.cssSelector("textarea#edu"));
        Assert.assertTrue(edu.isDisplayed());
        if (edu.isDisplayed()) {
            edu.sendKeys("Automation Testing");
            System.out.println("Element 'Education' is displayed");
        } else {
            System.out.println("Element 'Education' is not displayed");
        }
        // Name: User5
        nameUser5 = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
        Assert.assertFalse(nameUser5.isDisplayed());
        if (nameUser5.isDisplayed()) {
            System.out.println("Element 'Name: User5' is displayed");
        } else {
            System.out.println("Element 'Name: User5' is not displayed");
        }
    }

    @Test
    public void TC_02_Check_Enabled_Disabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement email, ageUnder18, edu, job01, job02, interestsDev, slider01, password, ageDisabled, biography, job03, interestsCheckbox, slider02;
        // Enabled - Email
        email = driver.findElement(By.cssSelector("input#mail"));
        Assert.assertTrue(email.isEnabled());
        if (email.isEnabled()) {
            System.out.println("Element 'Email' is enabled");
        } else {
            System.out.println("Element 'Email' is disabled");
        }
        // Enabled - Age Under 18
        ageUnder18 = driver.findElement(By.cssSelector("input#under_18"));
        Assert.assertTrue(ageUnder18.isEnabled());
        if (ageUnder18.isEnabled()) {
            System.out.println("Element 'Age Under 18' is enabled");
        } else {
            System.out.println("Element 'Age Under 18' is disabled");
        }
        // Enabled - edu
        edu = driver.findElement(By.cssSelector("textarea#edu"));
        Assert.assertTrue(edu.isEnabled());
        if (edu.isEnabled()) {
            System.out.println("Element 'Education' is enabled");
        } else {
            System.out.println("Element 'Education' is disabled");
        }
        // Enabled - job01
        job01 = driver.findElement(By.cssSelector("select#job1"));
        Assert.assertTrue(job01.isEnabled());
        if (job01.isEnabled()) {
            System.out.println("Element 'Job 01' is enabled");
        } else {
            System.out.println("Element 'Job 01' is disabled");
        }
        // Enabled - job02
        job02 = driver.findElement(By.cssSelector("select#job2"));
        Assert.assertTrue(job02.isEnabled());
        if (job02.isEnabled()) {
            System.out.println("Element 'Job 02' is enabled");
        } else {
            System.out.println("Element 'Job 02' is disabled");
        }
        // Enabled - interestsDev
        interestsDev = driver.findElement(By.cssSelector("input#development"));
        Assert.assertTrue(interestsDev.isEnabled());
        if (interestsDev.isEnabled()) {
            System.out.println("Element 'Interests -  Development' is enabled");
        } else {
            System.out.println("Element 'Interests -  Development' is disabled");
        }
        // Enabled - slider01
        slider01 = driver.findElement(By.cssSelector("input#slider-1"));
        Assert.assertTrue(slider01.isEnabled());
        if (slider01.isEnabled()) {
            System.out.println("Element 'Slider 01' is enabled");
        } else {
            System.out.println("Element 'Slider 01' is disabled");
        }
        // Disabled - password
        password = driver.findElement(By.cssSelector("input#disable_password"));
        Assert.assertFalse(password.isEnabled());
        if (password.isEnabled()) {
            System.out.println("Element 'Password' is enabled");
        } else {
            System.out.println("Element 'Slider 01' is disabled");
        }
        // Disabled - ageDisabled
        ageDisabled = driver.findElement(By.cssSelector("input#radio-disabled"));
        Assert.assertFalse(ageDisabled.isEnabled());
        if (ageDisabled.isEnabled()) {
            System.out.println("Element 'Age disabled' is enabled");
        } else {
            System.out.println("Element 'Age disabled' is disabled");
        }
        // Disabled - biography
        biography = driver.findElement(By.cssSelector("textarea#bio"));
        Assert.assertFalse(biography.isEnabled());
        if (biography.isEnabled()) {
            System.out.println("Element 'Biography' is enabled");
        } else {
            System.out.println("Element 'Biography' is disabled");
        }
        // Disabled - job03
        job03 = driver.findElement(By.cssSelector("select#job3"));
        Assert.assertFalse(job03.isEnabled());
        if (job03.isEnabled()) {
            System.out.println("Element 'Job 03' is enabled");
        } else {
            System.out.println("Element 'Job 03' is disabled");
        }
        // Disabled - interestsCheckbox
        interestsCheckbox = driver.findElement(By.cssSelector("input#check-disbaled"));
        Assert.assertFalse(interestsCheckbox.isEnabled());
        if (interestsCheckbox.isEnabled()) {
            System.out.println("Element 'Interests checkbox' is enabled");
        } else {
            System.out.println("Element 'Interests checkbox' is disabled");
        }
        // Disabled - slider02
        slider02 = driver.findElement(By.cssSelector("input#slider-2"));
        Assert.assertFalse(slider02.isEnabled());
        if (slider02.isEnabled()) {
            System.out.println("Element 'Slider 02' is enabled");
        } else {
            System.out.println("Element 'Slider 02' is disabled");
        }
    }

    @Test
    public void TC_03_Check_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement ageUnder18, langJava;
        ageUnder18 = driver.findElement(By.cssSelector("input#under_18"));
        langJava = driver.findElement(By.cssSelector("input#java"));
        // Select - Age Under 18 and Languages Java
        ageUnder18.click();
        langJava.click();
        if (ageUnder18.isSelected()) {
            System.out.println("Element 'Age under 18' is selected");
        } else {
            System.out.println("Element 'Age under 18' is de-selected");
        }
        if (langJava.isSelected()) {
            System.out.println("Element 'Languages Java' is selected");
        } else {
            System.out.println("Element 'Languages Java' is de-selected");
        }
        // De-select Languages Java
        langJava.click();
        if (langJava.isSelected()) {
            System.out.println("Element 'Languages Java' is selected");
        } else {
            System.out.println("Element 'Languages Java' is de-selected");
        }
    }

    @Test
    public void TC_04_Register_Function_At_MailChimp() {
        driver.get("https://login.mailchimp.com/signup/");
        WebElement email, password, signUp;
        email = driver.findElement(By.cssSelector("input#email"));
        password = driver.findElement(By.cssSelector("input#new_password"));
        signUp = driver.findElement(By.cssSelector("button#create-account-enabled"));
        // Case 1: 6 conditions invalid
        email.sendKeys("autotest@gmail.com");
        password.sendKeys("");
        signUp.click();
        // Not completed
        WebElement oneLowercaseNotCompleted, oneUppercaseNotCompleted, oneNumberNotCompleted, oneSpecialCharacterNotCompleted, CharactersMinimumNotCompleted, notContainUsernameNotCompleted;
        oneLowercaseNotCompleted = driver.findElement(By.cssSelector("li.lowercase-char.not-completed"));
        oneUppercaseNotCompleted = driver.findElement(By.cssSelector("li.uppercase-char.not-completed"));
        oneNumberNotCompleted = driver.findElement(By.cssSelector("li.number-char.not-completed"));
        oneSpecialCharacterNotCompleted = driver.findElement(By.cssSelector("li.special-char.not-completed"));
        CharactersMinimumNotCompleted = driver.findElement(By.cssSelector("li[class='8-char not-completed']"));
        notContainUsernameNotCompleted = driver.findElement(By.cssSelector("li.username-check.not-completed"));
        Assert.assertTrue(oneLowercaseNotCompleted.isDisplayed());
        Assert.assertTrue(oneUppercaseNotCompleted.isDisplayed());
        Assert.assertTrue(oneNumberNotCompleted.isDisplayed());
        Assert.assertTrue(oneSpecialCharacterNotCompleted.isDisplayed());
        Assert.assertTrue(CharactersMinimumNotCompleted.isDisplayed());
        Assert.assertTrue(notContainUsernameNotCompleted.isDisplayed());
        // Completed
        WebElement oneLowercaseCompleted, oneUppercaseCompleted, oneNumberCompleted, oneSpecialCharacterCompleted, CharactersMinimumCompleted, notContainUsernameCompleted;
        oneLowercaseCompleted = driver.findElement(By.cssSelector("li.lowercase-char.completed"));
        oneUppercaseCompleted = driver.findElement(By.cssSelector("li.uppercase-char.completed"));
        oneNumberCompleted = driver.findElement(By.cssSelector("li.number-char.completed"));
        oneSpecialCharacterCompleted = driver.findElement(By.cssSelector("li.special-char.completed"));
        CharactersMinimumCompleted = driver.findElement(By.cssSelector("li[class='8-char completed']"));
        notContainUsernameCompleted = driver.findElement(By.cssSelector("li.username-check.completed"));

        // Case 2: one lowercase completed

        // Case 3: one uppercase completed

        // Case 4: one number completed

        // Case 5: one special character completed

        // Case 6: characters minimum completed

        // Case 7: not contain username completed

        // Case 8: 6 conditions valid





    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
