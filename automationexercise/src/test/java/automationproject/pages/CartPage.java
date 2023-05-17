package automationproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    //Constructor:
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Locators:
    By checkoutBtn = By.xpath("//a[normalize-space(text())='Proceed To Checkout']");
    
    //Methods:
    public void clickCheckout(){
        click(checkoutBtn);
    }
}
