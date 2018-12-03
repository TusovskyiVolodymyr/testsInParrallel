import driver.TLDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.GooglePO;

public class SecondTest {

    WebDriver driver;

    private WebDriver getDriver() {
        return driver = TLDriverFactory.getDriver();
    }

    private GooglePO  googlePO;

    @BeforeMethod
    public void setup(){
        googlePO = new GooglePO();
    }


    @Test
    public void GOOGLE1() throws Exception {
        WebDriver driver = TLDriverFactory.getDriver();
        System.out.println("Google1 Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        System.out.println("GOOGLE1-TEST - driver: " + driver);
        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("Joey");
        webElement.submit();
    }

    @Test
    public void YANDEX() throws Exception {
        WebDriver driver = TLDriverFactory.getDriver();
        System.out.println("Facebook Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        System.out.println("YANDEX-TEST - driver: " + driver);
        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("Chandler");
        webElement.submit();

    }
}