package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Part02_Topic_06_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass () {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName")).sendKeys("Keane");
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_TagName() {
        driver.findElements(By.tagName("input"));
    }

    @Test
    public void TC_05_LinkText() {
        // do chinh xac cao = tuyet doi = toan bo text
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Partial_LinkText() {
        // do chinh xac khong cao = tuong doi = mot phan text
        driver.findElement(By.partialLinkText("vendor account"));
    }

    @Test
    public void TC_07_Css() {
        // Css vs ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        // Css vs Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        // Css vs Name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        // Css vs tagname
        driver.findElement(By.cssSelector("input"));

        // Css vs link
        // Note: get attribute with =, not work with text in the link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        // Css vs partial link
        // Note: get partial attribute with *= or ^= or $=, not work with partial text in the link
        // middle
        driver.findElement(By.cssSelector("a[href*='customer']"));
        // begin
        driver.findElement(By.cssSelector("a[href^='/customer']"));
        // last
        driver.findElement(By.cssSelector("a[href$='addresses']"));
    }

    @Test
    public void TC_08_XPath() {
        // XPath vs ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // XPath vs Class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        // XPath vs Name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        // XPath vs tagname
        driver.findElement(By.xpath("//input"));

        // XPath vs link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));

        // XPath vs partial link
        driver.findElement(By.xpath("//a[contains(@href,'/addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}