package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Part03_Topic_09_Button {
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
    public void TC_01_Egov_Button() {
        driver.get("https://egov.danang.gov.vn/reg");
        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));

        // Verify button disable before click on checkbox
        Assert.assertFalse(registerButton.isEnabled());
        driver.findElement(By.cssSelector("input#chinhSach")).click();
        sleepInSeconds(2);

        // Verify button enable after click on checkbox
        Assert.assertTrue(registerButton.isEnabled());

        // Lay ra ma mau nen cua button
        String registerBackgroundRGB = registerButton.getCssValue("background-color");

        // Convert from String (ma RGB) to Color
        Color registerBackgroundColor = Color.fromString(registerBackgroundRGB);

        // Convert to Hexa
        String registerBackgroundHexa = registerBackgroundColor.asHex();

        // Convert to lowerCase
        registerBackgroundHexa = registerBackgroundHexa.toLowerCase();
        Assert.assertEquals(registerBackgroundHexa, "#ef5a00");
        Assert.assertEquals(Color.fromString(registerButton.getCssValue("background-color")).asHex().toLowerCase(), "#ef5a00");
    }

    @Test
    public void TC_02_Fahasa_Button() {
        driver.get("https://www.fahasa.com/customer/account/create");
        // Chuyen qua tab Dang nhap
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        sleepInSeconds(2);

        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));

        //Verify login button is disable
        Assert.assertFalse(loginButton.isEnabled());

        // Verify login button by background
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#000000");

        // Nhap Email and pass
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("autotest123@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("12345678");
        sleepInSeconds(2);

        // Verify login button iss enabled
        Assert.assertTrue(loginButton.isEnabled());

        // Verify login button by background
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#c92127");
    }

    @Test
    public void TC_03_Goconsensus_Button() {
        driver.get("https://play.goconsensus.com/u5d5156df");
        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Continue' and @data-testid='lead form continue']"));

        //Verify login button is disable
        Assert.assertFalse(continueButton.isEnabled());

        // Verify login button by background
        Assert.assertEquals(Color.fromString(continueButton.getCssValue("background-color")).asHex().toLowerCase(), "#673ab7");

        // Enter data
        driver.findElement(By.cssSelector("input#firstName")).sendKeys("First");
        driver.findElement(By.cssSelector("input#lastName")).sendKeys("Last");
        driver.findElement(By.cssSelector("input#email")).sendKeys("autotest123@gmail.com");
        driver.findElement(By.cssSelector("input#confirmEmail")).sendKeys("autotest123@gmail.com");
        driver.findElement(By.cssSelector("input#phoneNumber")).sendKeys("0981234568");
        driver.findElement(By.cssSelector("input#organization")).sendKeys("organization");
        selectItemInEditableDropdownByCss("input#downshift-0-input","div#downshift-0-menu div div", "AL");
        selectItemInEditableDropdownByXpath("//label[text()='State']/following-sibling::div//input", "//label[text()='State']/following-sibling::div//div[@role='listbox']/div/div", "07");

        // Verify login button iss enabled
        Assert.assertTrue(continueButton.isEnabled());

        // Verify login button by background
        Assert.assertEquals(Color.fromString(continueButton.getCssValue("background-color")).asHex().toLowerCase(), "#673ab7");
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

    public void selectItemInEditableDropdownByCss(String partentCss, String childItemCss, String itemTextExpected) {
        explicitWait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(partentCss))).click();
        driver.findElement(By.cssSelector(partentCss)).clear();
        driver.findElement(By.cssSelector(partentCss)).sendKeys(itemTextExpected);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy((By.cssSelector(childItemCss))));
        for (WebElement item : allItems) {
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }
    public void selectItemInEditableDropdownByXpath(String partentXpath, String childItemXpath, String itemTextExpected) {
        explicitWait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath(partentXpath))).click();
        driver.findElement(By.xpath(partentXpath)).clear();
        driver.findElement(By.xpath(partentXpath)).sendKeys(itemTextExpected);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy((By.xpath(childItemXpath))));
        for (WebElement item : allItems) {
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }
}
