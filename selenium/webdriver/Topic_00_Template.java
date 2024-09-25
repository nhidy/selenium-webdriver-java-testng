package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_00_Template {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    /*
        Selenium 1.x / 2.x / 3.x / 4.x:
        8 kind of locator:
            Id / Class / Name: 1st = same with 3 attribute of HTML
            LinkText / Partial LinkText: HTML link (tag a)
            TagNameL HTML Tag name
            Css / XPath
        Selenium 4.x: GUI (Graphic User Interface)
            Class - Relative Locator
            above / bellow / near / leftOf / rightOf
        UI Testing
        FUI: Functional UI
        GUI: Graphic UI - Visualize Testing
        Font / Size / Color / Position / Location / Resolution / Responsive / ...
    */

    /*
    TestNG: Order testcase theo Alphabet (0-9 A-Z)
    */
    @BeforeClass
    public void beforeClass () {
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("");
    }

    @Test
    public void TC_01_() {

    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {

    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
