package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Part04_Topic_06_Register {
    WebDriver driver;

    @BeforeClass
    public void beforeClass () {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Login_Successful() {
        driver.get("http://live.techpanda.org");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(2);
        //Click "Create an account"
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        sleepInSeconds(2);
        // Register
        String email = getEmailAddress();
        System.out.println("Email: " + email);
        String password = "12345678";
        String firstName = "Automation";
        String lastName = "FC";
        String fullName = firstName + " " + lastName;
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(email);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("button[title='Register']")).click();
//        sleepInSeconds(2);
//        Alert alert = driver.switchTo().alert(); // switch to alert
//        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
//        System.out.println("Alert message: " + alertMessage);
//        sleepInSeconds(2);
//        alert.accept();
//        driver.switchTo().alert().accept();
        sleepInSeconds(5);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='hello']/strong")).getText(), "Hello, "+ fullName +"!");
        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(email));
        // Logout
        driver.findElement(By.cssSelector("a.skip-account")).click();
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        sleepInSeconds(6);
        // Login
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("input#email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#pass")).sendKeys(password);
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("button#send2")).click();
        sleepInSeconds(6);
//        driver.switchTo().alert().accept();
//        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(), "Hello, "+ fullName +"!");
        contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(email));
        // Verify account
        driver.findElement(By.xpath("//a[text()='Account Information']")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getAttribute("value"), email);
        // Review product
        driver.findElement(By.xpath("//li/a[text()='Mobile']")).click();
        sleepInSeconds(5);
        driver.findElement(By.xpath("//h2/a[text()='Samsung Galaxy']")).click();
        sleepInSeconds(6);
        driver.findElement(By.xpath("//p/a[text()='Add Your Review']")).click();
        sleepInSeconds(5);
        driver.findElement(By.xpath("//label/input[@id='Quality 1_5']")).click();
        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys("Pretty easy to navigate.");
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("Best Phone");
        sleepInSeconds(1);
        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();
        sleepInSeconds(5);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Your review has been accepted for moderation.");
        // Logout
        driver.findElement(By.cssSelector("a.skip-account")).click();
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        sleepInSeconds(5);
        Assert.assertEquals(driver.getTitle(), "Magento Commerce");
        sleepInSeconds(10);
        // Verify home page
        Assert.assertEquals(driver.getTitle(), "Home page");
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
