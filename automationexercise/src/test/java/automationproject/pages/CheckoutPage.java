package automationproject.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    //Constructor:
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //Locators:
    By addressInfo = By.xpath("//ul[@id='address_delivery']/li");
    
    //Methods:
    public void assertAddress(String name, String address, String city, String country, String phone){
        List<WebElement> elements = (driver.findElements(addressInfo));	
        String actualName = elements.get(1).getText();
        String actualAddress = elements.get(3).getText();
        String actualCity = elements.get(5).getText();
        String actualCountry = elements.get(6).getText();
        String actualPhone = elements.get(7).getText();
        Assert.assertEquals(actualName,name);
        Assert.assertEquals(actualAddress,address);
        Assert.assertEquals(actualCity,city);
        Assert.assertEquals(actualCountry, country);
        Assert.assertEquals(actualPhone, phone);
    }
}
