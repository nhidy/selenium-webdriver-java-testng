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

public class Part03_Topic_08_Custom_Dropdown {
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
    public void TC_01_Click_Items() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        driver.findElement(By.cssSelector("span#number-button")).click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div"));
        String selectItem = "15";
        for (WebElement item : allItems) {
            String textItem = item.getText();
            System.out.println("Text item = " + textItem);
            if (textItem.equals(selectItem)) {
                item.click();
                break;
            }
        }
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(), selectItem);
    }

    @Test
    public void TC_02_JQuery() {
        // Step 01
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        // Step 02
        String itemMedium = "Medium";
        /*driver.findElement(By.cssSelector("span#speed-button")).click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#speed-menu li")));
        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#speed-menu li"));
        for (WebElement item : allItems) {
            String textItem = item.getText();
            if (textItem.equals(itemMedium)) {
                item.click();
                break;
            }
        }*/
        selectItemInDropdown("span#speed-button", "ul#speed-menu li", itemMedium);
        // Step 03
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']/span[@class='ui-selectmenu-text']")).getText(), itemMedium);
        // Step 04 - Slower
        String itemSlower = "Slower";
        /*driver.findElement(By.cssSelector("span#speed-button")).click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#speed-menu li")));
        for (WebElement item : allItems) {
            String textItem = item.getText();
            if (textItem.equals(itemSlower)) {
                item.click();
                break;
            }
        }*/
        selectItemInDropdown("span#speed-button", "ul#speed-menu li", itemSlower);
        // Verify
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']/span[@class='ui-selectmenu-text']")).getText(), itemSlower);
        // Step 04 - Faster
        String itemFaster = "Faster";
        /*driver.findElement(By.cssSelector("span#speed-button")).click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#speed-menu li")));
        for (WebElement item : allItems) {
            String textItem = item.getText();
            if (textItem.equals(itemFaster)) {
                item.click();
                break;
            }
        }*/
        // Verify
        selectItemInDropdown("span#speed-button", "ul#speed-menu li", itemFaster);
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']/span[@class='ui-selectmenu-text']")).getText(), itemFaster);
    }

    @Test
    public void TC_03_ReactJS() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        String expectedItem = "Stevie Feliciano";
        selectItemInDropdown("div.divider", "div.visible div.item", expectedItem);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(), expectedItem);
    }

    @Test
    public void TC_04_VueJS() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        String expectedItem = "Second Option";
        selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu li", expectedItem);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), expectedItem);
    }

    @Test
    public void TC_05_Editable() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        String expectedItem ="Barbados";
        selectItemInEditableDropdown("input.search", "div.menu div.item", expectedItem);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(), expectedItem);
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

    public void selectItemInDropdown(String partentCss, String childItemCss, String itemTextExpected) {
        driver.findElement(By.cssSelector(partentCss)).click();
        sleepInSeconds(1);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy((By.cssSelector(childItemCss))));
        for (WebElement item : allItems) {
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }

    public void selectItemInEditableDropdown(String partentCss, String childItemCss, String itemTextExpected) {
        driver.findElement(By.cssSelector(partentCss)).clear();
        driver.findElement(By.cssSelector(partentCss)).sendKeys(itemTextExpected);
        sleepInSeconds(1);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy((By.cssSelector(childItemCss))));
        for (WebElement item : allItems) {
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }
}
