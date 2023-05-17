package automationproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    //Constructor:
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Locators:
    By loginHeader = By.xpath("//h2[normalize-space(text())='Login to your account']");
    By emailInput = By.xpath("//div[@class='login-form']/form/input[@type='email']"); 
    By passwordInput = By.xpath("//div[@class='login-form']/form/input[@type='password']");
    By loginBtn = By.xpath("//div[@class='login-form']/form/button[@type='submit']");
    

    //Methods:
    public WebElement getLoginHeader() {
        return find(loginHeader);
    }

    public void typeEmail(String email){
        type(emailInput, email);
    }

    public void typePass(String password){
        type(passwordInput, password);
    }

    public void clickLogin(){
        click(loginBtn);
    }
}