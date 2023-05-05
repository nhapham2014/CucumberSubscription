package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectBase {
    public WebDriver driver;
   public PageObjectBase(WebDriver driver){
        this.driver=driver;
    }
    WebElement getDynamic(By locator){
        WebDriverWait waiter = new WebDriverWait(this.driver, Duration.ofSeconds(50));
        return waiter.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
    public void scrollDownToElement(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }
    public void alertisPresent(){
       WebDriverWait waiter = new WebDriverWait(this.driver, Duration.ofSeconds(50));
        waiter.until(ExpectedConditions.alertIsPresent());
    }


}
