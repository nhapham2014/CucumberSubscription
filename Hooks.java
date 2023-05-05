package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void Before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void After(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] imgbuffer= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(imgbuffer,"image/png","Screenshot");
        }
        driver.quit();
    }
}
