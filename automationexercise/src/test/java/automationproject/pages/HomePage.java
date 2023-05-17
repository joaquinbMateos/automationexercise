package automationproject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    //Constructor:
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators:
    By loginBtn = By.xpath("//a[starts-with(@href, '/login')]");
    By loggedUser = By.xpath("//a[i[contains(@class, 'fa fa-user')]]/b[text()='testAutomation']");
    By product = By.xpath("//div[@class='single-products']");
    By addToCartBtn = By.xpath("//a[@class='btn btn-default add-to-cart']"); 
    By modal = By.xpath("//div[@class='modal-content']");
    By addedMsg = By.xpath("//div[@class='modal-body']//p[contains(text(),'Your product has been added to cart')]");
    By viewCartBtn = By.xpath("//u[text()='View Cart']"); //a[starts-with(@href, '/view_cart')]
    
    //Methods:
    public void clickLogin(){
        click(loginBtn);
    }

    public WebElement getLoggedUser() {
        return find(loggedUser);
    }

    public WebElement getFirstProduct(){
        List<WebElement> productList = driver.findElements(product);
        WebElement firstProduct = productList.get(0);
        return firstProduct;
    }

    public void clickAddToCart(){
        List<WebElement> elements = driver.findElements(addToCartBtn);
        WebElement firstElement = elements.get(0);
        firstElement.click();
    }

    public WebElement getModal(){
        return find(modal);
    }

    public WebElement getAddedMsg(){
        return find(addedMsg);
    }

    public void clickViewCart(){
        click(viewCartBtn);
    }
}
