package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends PageObjectBase {
    @FindBy(xpath = "//input[@type=\"email\"]")
    public WebElement txtEmail;
    @FindBy(css = ".next-btn-primary")
    public WebElement btnSubscription;
    @FindBy(css = ".body-message")
    public WebElement errormssg;
    @FindBy(xpath = "//button[@id=\"ddlGender\"]")
    public WebElement dpxGender;
    @FindBy(xpath = "//button[@id=\"ddlNewsType\"]")
    public WebElement dpxNews;
    @FindBy(xpath = "//button[@id=\"ddlGender\"]//span[@class=\"content-display\"]")
    public WebElement defaultGender;
    @FindBy(xpath = "//button[@id=\"ddlNewsType\"]//span[@class=\"content-display\"]")
    public WebElement defaultNews;
    @FindBy(id = "fullname")
    public WebElement txbname;
    @FindBy(id = "allow-button")
    public WebElement btnAgree;
    @FindBy(xpath = "//div[contains(@class,\"form in\")]")
    public WebElement formInfo;
    @FindBy(className = "body-message")
    public WebElement contentPopupSuccess;
    By lcErrorEmail = By.xpath("//div[@class=\"mod-input error\"]/div[@style=\"clear:both;\"]");
    By lcErrorAlert = By.xpath("//div[contains(@class,\"alert in\")]");
    //By lcContentPopup = By.xpath("//b[contains(text(),\"thông tin\")]");
    By lcContentPopup = By.xpath("//div[contains(@class,\"form in\")]//div[@class=\"popover-body\"]//p[1]");
    By lcErrorMssgName= By.xpath("//div[@class=\"error\"]");
    By lcErrorUIName= By.cssSelector("input.error");
    By lcformInfo=By.xpath("//div[contains(@class,\"form in\")]");
    By lcformAccess=By.xpath("//div[contains(@class,\"alert in\")]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void Open() {

        this.driver.get("http://testmaster.vn/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(this.driver, this);
    }

    public String getErrorMessageWhenInputInvalidEmail() {
        return this.getDynamic(lcErrorEmail).getText();
    }

    public String getErrorMessageWhenInputExistEmail() {

        return this.getDynamic(lcErrorAlert).getText();
    }

    public String getContentPopupAfterInputValidEmail() {

        return this.getDynamic(lcContentPopup).getText();
    }
    public String checkBorderColorEmailField(){
        this.getDynamic(lcErrorEmail);
        return this.txtEmail.getCssValue("border-bottom-color");

    }

    public boolean checkNameFieldIsRequired() {
        if (this.txbname.getAttribute("isrequire").contains("true")) {
            return true;
        }
        return false;
    }
    public String getErrorMessageWhenEmptyName(){
        return this.getDynamic(lcErrorMssgName).getText();
    }
    public String checkBorderColorNameField(){
        this.getDynamic(lcErrorUIName);
        return this.txbname.getCssValue("border-bottom-color");

    }
    public String checkBackgroundColorNameField(){
        this.getDynamic(lcErrorUIName);
        return this.txbname.getCssValue("background-color");
    }
    public void Exit(){
        //Actions action = new Actions(this.driver);
        this.formInfo.sendKeys(Keys.ESCAPE);
    }
    public boolean checkInformationFormExist(){
        WebDriverWait wait = new WebDriverWait(this.driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lcformInfo));

        if (this.driver.findElements(lcformInfo).size()>0){
            return true;
        }
        return false;
    }
    public void selectOptionGender(String option) {

        this.getDynamic(By.linkText(option)).click();
    }
    public void selectOptionNews(String option)  {
        this.getDynamic(By.linkText(option)).click();

    }
    public WebElement optionNews(String option){
        return this.driver.findElement(By.linkText(option));
    }
    public String getContentPopupSuccess(){
        this.getDynamic(lcformAccess);
        return this.contentPopupSuccess.getText();
    }

}
