package datePickertest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class GuviSignupLoginTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {

        // Initialize ChromeDriver
        driver = new ChromeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void signUp() {
        // Launch the website
        driver.get("https://www.guvi.in/");

        // Locate and click Signup button
        WebElement signUpButton = driver.findElement(By.xpath("//*[@id=\"accountGroup\"]/ul/li[2]/a"));
        signUpButton.click();

        // Fill in the signup form
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("Vignesh");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("vigneshbaskar020511@gmail.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Vicky@020511");

        WebElement phoneNumberField = driver.findElement(By.id("mobileNumber"));
        phoneNumberField.sendKeys("8778436575");

        // Click on Signup button to submit the form
        WebElement submitButton = driver.findElement(By.id("signup-btn"));
        submitButton.click();
        
        //Get Title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        
		if(driver.getTitle().equals("GUVI | Sign Up")) {
			System.out.println("Registration Successfully...");
		}else {
			System.out.println("Landed wrong Title of the page");
		}

    }
    

    @Test(priority = 2)
    public void logIn() throws InterruptedException {
        // Locate and click Login button
        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Login']"));
        loginButton.click();

        // Fill in the login form
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("vigneshbaskar020511@gmail.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Vicky@020511");

        // Click on Login button to submit the form
        WebElement submitButton = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/form/a"));
        submitButton.click();
        
      //Get Title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        
		if(driver.getTitle().equals("GUVI | Login")) {
			System.out.println("Logedin Successfully...");
		}else {
			System.out.println("Landed wrong Title of the page");
		}


        Thread.sleep(5000);

    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
