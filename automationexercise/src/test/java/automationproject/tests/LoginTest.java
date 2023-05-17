package automationproject.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import automationproject.pages.CartPage;
import automationproject.pages.HomePage;
import automationproject.pages.LoginPage;

public class LoginTest extends BaseTest{
   private static String homeUrl = "https://automationexercise.com/";
   private static String loginUrl = "https://automationexercise.com/login";

   @BeforeMethod
   public void setUp(){
      driver.get(homeUrl);
      WebDriverWait wait = new WebDriverWait(driver, 60);
      wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
   }

   @Test(dataProvider = "credentials")
   public void testLogin(String email, String password){
      homePage = new HomePage(driver);
      loginPage = new LoginPage(driver);
      cartPage = new CartPage(driver);

      //assert title:
      String title = driver.getTitle();
      Assert.assertEquals(title, "Automation Exercise");
      homePage.clickLogin();
      //assert new Url:
      String actualUrl = driver.getCurrentUrl(); 
      Assert.assertEquals(actualUrl, loginUrl);
      //assert 'Login to your account' is visible:
      WebElement header = loginPage.getLoginHeader();
      Assert.assertTrue(header.isDisplayed());
      //type data:
      loginPage.typeEmail(email);
      loginPage.typePass(password);
      loginPage.clickLogin();
      //assert redirection to home:
      actualUrl = driver.getCurrentUrl(); 
      Assert.assertEquals(actualUrl, homeUrl);
      //assert 'Logged in as username' is visible:
      WebElement loggedUser = homePage.getLoggedUser();
      Assert.assertTrue(loggedUser.isDisplayed());
   }

   @DataProvider(name = "credentials")
      public Object[][] getCredentials() {
         return new Object[][]{
                {"test@automation.com", "seleniumjava"},
      };
   }

}
