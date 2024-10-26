package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_09_Default_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("");
    }

    @Test
    public void TC_01_Register() {

    }

    @Test
    public void TC_02_Login() {

    }

    @Test
    public void TC_03_() {

    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddress (){
        Random rand = new Random();
        return "automation" + rand.nextInt(9999) + "@gmail.net";
    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
