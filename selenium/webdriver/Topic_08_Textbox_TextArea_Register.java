package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_08_Textbox_TextArea_Register {
    WebDriver driver;

    @BeforeClass
    public void beforeClass () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Login_Successful() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.net");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg >ul >li >span")).getText(), "Invalid login or password.");
        // Register

        // Logout

        // Login

        // Verify account

    }


    @Test
    public void TC_02_() {

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
