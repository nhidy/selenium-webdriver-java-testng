package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Part03_Topic_09_Custom_Checkbox {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass () {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Ubuntu() {
        driver.get("https://login.ubuntu.com/");
        By ubuntuRadio = By.xpath("//span[text()='I don’t have an Ubuntu One account']/parent::label/preceding-sibling::input");
        By ubuntuCheckbox = By.xpath("//label[contains(text(),'I have read and accept')]/preceding-sibling::input");
        String scriptJS = "arguments[0].click();";
        checkToElementByJS(scriptJS, ubuntuRadio);
        sleepInSeconds(2);
        checkToElementByJS(scriptJS, ubuntuCheckbox);

        // Verify
        Assert.assertTrue(driver.findElement(ubuntuRadio).isSelected());
        Assert.assertTrue(driver.findElement(ubuntuCheckbox).isSelected());
    }

    @Test
    public void TC_02_Google() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        By expectedRadio = By.xpath("//div[@aria-label='Cần Thơ']");

        // Verify uncheck
        Assert.assertEquals(driver.findElement(expectedRadio).getAttribute("aria-checked"), "false");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='false']")).isDisplayed());

        // Click on radio button
        driver.findElement(expectedRadio).click();

        // Verify checked
        Assert.assertEquals(driver.findElement(expectedRadio).getAttribute("aria-checked"), "true");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='true']")).isDisplayed());
    }

    @AfterClass
    public void afterClass () {
        driver.quit();
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

    public void checkToElementByJS(String scriptJS, By byXpath) {
        // Neu nhu element chua dc chon thi moi click chon
        if (!driver.findElement(byXpath).isSelected()) {
            ((JavascriptExecutor)driver).executeScript(scriptJS, driver.findElement(byXpath));
            sleepInSeconds(1);
        }
    }

    public void uncheckToElementByJS(String scriptJS, By byXpath) {
        // Neu nhu element dc chon roi thi vao click lan nua cho no thanh bo chon
        if (driver.findElement(byXpath).isSelected()) {
            ((JavascriptExecutor)driver).executeScript(scriptJS, driver.findElement(byXpath));
            sleepInSeconds(1);
        }
    }
}
