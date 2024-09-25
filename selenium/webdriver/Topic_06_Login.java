package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_Login {
    WebDriver driver;

    @BeforeClass
    public void beforeClass () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("");
    }

    @Test
    public void TC_01_Login_With_Empty_Email_And_Password() {

    }

    @Test
    public void TC_02_Login_With_Invalid_Email() {

    }

    @Test
    public void TC_03_Login_With_Password_Invalid() {

    }

    @Test
    public void TC_04_Login_With_Incorrect_Email_Password() {

    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
