package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_Element_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("");
    }

    @Test
    public void TC_01_Check_Is_Displayed() {

    }

    @Test
    public void TC_02_Check_Enabled_Disabled() {

    }

    @Test
    public void TC_03_Check_Selected() {

    }

    @Test
    public void TC_04_Register_Function_At_MailChimp() {

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
