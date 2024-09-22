package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class Topic_04_XPath_Css {
    WebDriver driver;

    @BeforeClass
    public void beforeClass () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void Register_01_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
    }

    @Test
    public void Register_02_Invalid_Email_Address() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.id("txtFirstname")).sendKeys("John Kennedy");
        driver.findElement(By.id("txtEmail")).sendKeys("Abc123@456@789");
        driver.findElement(By.id("txtCEmail")).sendKeys("Abc123@456@789");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtPhone")).sendKeys("09812345678");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
        driver.findElement(By.id("txtEmail")).sendKeys("johnwick@gmail.net");
        driver.findElement(By.id("txtCEmail")).sendKeys("johnwick@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtPhone")).sendKeys("09812345678");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void Register_04_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
        driver.findElement(By.id("txtEmail")).sendKeys("johnwick@gmail.net");
        driver.findElement(By.id("txtCEmail")).sendKeys("johnwick@gmail.net");
        driver.findElement(By.id("txtPassword")).sendKeys("123");
        driver.findElement(By.id("txtCPassword")).sendKeys("123");
        driver.findElement(By.id("txtPhone")).sendKeys("09812345678");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
        driver.findElement(By.id("txtEmail")).sendKeys("johnwick@gmail.net");
        driver.findElement(By.id("txtCEmail")).sendKeys("johnwick@gmail.net");
        driver.findElement(By.id("txtPassword")).sendKeys("123456789");
        driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtPhone")).sendKeys("09812345678");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void Register_06_Invalid_Phone_Number() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action: Phone ít hơn 10 số
        driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
        driver.findElement(By.id("txtEmail")).sendKeys("johnwick@gmail.net");
        driver.findElement(By.id("txtCEmail")).sendKeys("johnwick@gmail.net");
        driver.findElement(By.id("txtPassword")).sendKeys("123456789");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
        driver.findElement(By.id("txtPhone")).sendKeys("098123456");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        // Action: Phone lớn hơn 11 số
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("098123456789");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();
        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        // Action: Phone không có đầu số nhà mạng
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("1234567890");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();
        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
