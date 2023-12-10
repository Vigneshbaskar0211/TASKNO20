package datePickertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DatePickerAutomation {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
    }

    @Test
    public void selectDateFromDatePicker() {
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        driver.findElement(By.id("datepicker")).click(); // To open the datepicker

        driver.findElement(By.className("ui-datepicker-next")).click(); // Select next month
        driver.findElement(By.xpath("//a[text()='22']")).click(); // Select date 22

        String selectedDate = driver.findElement(By.id("datepicker")).getAttribute("value");
        System.out.println("Selected Date: " + selectedDate);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
