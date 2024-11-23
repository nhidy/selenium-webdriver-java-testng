package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Part03_Topic_09_Default_Checkbox {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Default_Checkbox_Telerik() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        acceptCookies("//button[text()='Accept Cookies']");
        sleepInSeconds(3);
        By rearSideCheckbox = By.xpath("//label[text()='Rear side airbags']/preceding-sibling::span/input");
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        // Case 1: Neu nhu app nay mo ra ma checkbox da dc chon
        /*if (!driver.findElement(rearSideCheckbox).isSelected()) {
            driver.findElement(rearSideCheckbox).click();
            sleepInSeconds(2);
        }*/
        checkToElement(rearSideCheckbox);

        // Case 2: Neu nhu app nay mo ra ma checkbox chua dc chon
        /*if (!driver.findElement(dualZoneCheckbox).isSelected()) {
            driver.findElement(dualZoneCheckbox).click();
            sleepInSeconds(2);
        }*/
        checkToElement(dualZoneCheckbox);

        // Verify checkbox
        Assert.assertTrue(driver.findElement(rearSideCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());
    }

    @Test
    public void TC_02_Default_Radio_Button_Telerik() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        acceptCookies("//button[text()='Accept Cookies']");
        sleepInSeconds(3);
        By twoPetrolRadio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");

        checkToElement(twoPetrolRadio);

        // Verify Radio Button
        Assert.assertTrue(driver.findElement(twoPetrolRadio).isSelected());
    }

    @Test
    public void TC_03_Default_Radio_Button_Angular() {
        driver.get("https://material.angular.io/components/radio/examples");
        acceptCookies("//span[text()='Okay, got it']");
        sleepInSeconds(3);

        By summerRadio = By.xpath("//label[text()='Summer']/preceding-sibling::div/input");

        checkToElement(summerRadio);

        // Verify Radio Button
        Assert.assertTrue(driver.findElement(summerRadio).isSelected());
    }

    @Test
    public void TC_04_Default_Checkbox_Angular() {
        driver.get("https://material.angular.io/components/checkbox/examples");
        acceptCookies("//span[text()='Okay, got it']");
        sleepInSeconds(3);

        By checkedCheckbox = By.xpath("//label[text()='Checked']/preceding-sibling::div/input");
        By indeterminateCheckbox = By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input");

        checkToElement(checkedCheckbox);
        checkToElement(indeterminateCheckbox);

        // Verify checkbox
        Assert.assertTrue(driver.findElement(checkedCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(indeterminateCheckbox).isSelected());

        uncheckToElement(checkedCheckbox);
        uncheckToElement(indeterminateCheckbox);

        // Verify checkbox
        Assert.assertFalse(driver.findElement(checkedCheckbox).isSelected());
        Assert.assertFalse(driver.findElement(indeterminateCheckbox).isSelected());
    }

    @Test
    public void TC_05_Select_All_Checkbox_And_Select_One_In_All() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> allCheckbox = driver.findElements(By.xpath("//label[text()=' Have you ever had (Please check all that apply) ']/following-sibling::div//input"));

        // Select all checkbox
        for (WebElement checkbox : allCheckbox) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
            //sleepInSeconds(1);
        }

        // Verify all checkbox are selected
        for (WebElement checkbox : allCheckbox) {
            Assert.assertTrue(checkbox.isSelected());
        }

        // Select one in all checkbox
        checkToElement(By.xpath("//label[text()=' Heart Attack ']/preceding-sibling::input"));

        // Verify " Heart Attack " is selected
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()=' Heart Attack ']/preceding-sibling::input")).isSelected());
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddress() {
        Random rand = new Random();
        return "automation" + rand.nextInt(9999) + "@gmail.net";
    }

    public void checkToElement(By byXpath) {
        // Neu nhu element chua dc chon thi moi click chon
        if (!driver.findElement(byXpath).isSelected()) {
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }

    public void uncheckToElement(By byXpath) {
        // Neu nhu element dc chon roi thi vao click lan nua cho no thanh bo chon
        if (driver.findElement(byXpath).isSelected()) {
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }

    public void acceptCookies(String xpath) {
        sleepInSeconds(3);
        explicitWait.until(ExpectedConditions.
                elementToBeClickable(By.xpath(xpath))).click();
    }
}
