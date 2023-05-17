package automationproject.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import automationproject.pages.CartPage;
import automationproject.pages.HomePage;
import automationproject.pages.LoginPage;

import org.openqa.selenium.JavascriptExecutor;

public class CheckoutTest extends BaseTest{
   private static String homeUrl = "https://automationexercise.com/";
   private static String loginUrl = "https://automationexercise.com/login";
   private static String cartUrl = "https://automationexercise.com/view_cart";
   private static String checkoutUrl = "https://automationexercise.com/checkout";

   @BeforeMethod
   public void setUp(){
      driver.get(homeUrl);
      WebDriverWait wait = new WebDriverWait(driver, 60);
      wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
      homePage = new HomePage(driver);
      loginPage = new LoginPage(driver);
      cartPage = new CartPage(driver);
   }

   @Test(dataProvider = "credentials", priority = 0)
   public void testLogin(String email, String password) {
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

   @Test(priority = 1)
   public void checkoutExecution(){
      JavascriptExecutor js = (JavascriptExecutor) driver;
      //assert title:
      String title = driver.getTitle();
      Assert.assertEquals(title, "Automation Exercise");
      //scroll down to product:
      WebElement firstProduct = homePage.getFirstProduct();
      js.executeScript("arguments[0].scrollIntoView(true);", firstProduct);
      //mouse over product:
      Actions action = new Actions(driver);
      action.moveToElement(firstProduct).perform();
      //add to cart:
      homePage.clickAddToCart();
      WebElement modal =  homePage.getModal();
      //assert modal is displayed:
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.visibilityOf(modal));
      Assert.assertTrue(modal.isDisplayed());
      //assert added msg:
      WebElement addedMsg = homePage.getAddedMsg();
      Assert.assertTrue(addedMsg.isDisplayed());
      //click view cart:
      homePage.clickViewCart();
      String actualUrl = driver.getCurrentUrl(); 
      Assert.assertEquals(actualUrl, cartUrl);
      //checkout:
      cartPage.clickCheckout();
      actualUrl = driver.getCurrentUrl(); 
      Assert.assertEquals(actualUrl, checkoutUrl);
   }

   @DataProvider(name = "credentials")
      public Object[][] getCredentials() {
         return new Object[][]{
                {"test@automation.com", "seleniumjava"},
      };
   }
}