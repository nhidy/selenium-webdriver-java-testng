package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Part03_Topic_07_Default_Dropdown {
    WebDriver driver;
    String email = getEmailAddress();
    String password = "12345678";
    String firstName = "Automation";
    String lastName = "FC";
    String companyName = "Company FC";
    String fullName = firstName + " " + lastName;
    String day = "1", month = "May", year = "1980";

    @BeforeClass
    public void beforeClass () {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Register() {
        driver.get("https://demo.nopcommerce.com/");
        sleepInSeconds(10);
        driver.findElement(By.cssSelector("a.ico-register")).click();
        sleepInSeconds(2);
        // Register
        driver.findElement(By.cssSelector("input#gender-female")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
        // select date of birth
        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        day.selectByVisibleText(this.day);
        Assert.assertFalse(day.isMultiple());
        Assert.assertEquals(day.getOptions().size(), 32);
        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByVisibleText(this.month);
        Assert.assertFalse(month.isMultiple());
        Assert.assertEquals(month.getOptions().size(), 13);
        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByVisibleText(this.year);
        Assert.assertFalse(year.isMultiple());
        Assert.assertEquals(year.getOptions().size(), 112);
        System.out.println("Email: " + email);
        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#Company")).sendKeys(companyName);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("button#register-button")).click();
        sleepInSeconds(5);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
    }

    @Test
    public void TC_02_Login() {
        driver.get("https://demo.nopcommerce.com/");
        sleepInSeconds(10);
        driver.findElement(By.cssSelector("a.ico-login")).click();
        sleepInSeconds(5);
        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSeconds(5);
        driver.findElement(By.cssSelector("a.ico-account")).click();
        sleepInSeconds(5);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getText(), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getText(), lastName);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), year);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getText(), email);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getText(), companyName);
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
