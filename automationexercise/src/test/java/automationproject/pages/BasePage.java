package automationproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Elementos comunes a todas las páginas:

    // Métodos comunes a todas las páginas:
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }
    
    protected void click(By locator) {
        find(locator).click();
    }

    protected void type(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected boolean isElementDisplayed(By locator) {
        return driver.findElement(locator)
        .isDisplayed();
    }

    protected String text(By locator) {
        return driver.findElement(locator).getText();
    }
}
