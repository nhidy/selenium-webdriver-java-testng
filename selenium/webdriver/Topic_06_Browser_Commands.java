package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_Browser_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Verify_Url() {
        driver.get("http://live.techpanda.org/");

    }

    @Test
    public void TC_02_Verify_Title() {
        driver.get("");

    }

    @Test
    public void TC_03_Navigate_Function() {
        driver.get("");

    }

    @Test
    public void TC_04_Get_Page_Source_Code() {
        driver.get("");

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
