package automationproject.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import automationproject.pages.CartPage;
import automationproject.pages.HomePage;
import automationproject.pages.LoginPage;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static CartPage cartPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }


}
