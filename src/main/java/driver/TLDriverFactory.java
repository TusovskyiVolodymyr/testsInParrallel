package driver;

import driver.OptionsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TLDriverFactory {

    private static OptionsManager optionsManager = new OptionsManager();
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void setDriver(String browser) {
        if (browser.equals("chrome")) {
            if (getDriver() == null) {
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//            tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
                tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(optionsManager.getChromeOptions()));
            }
        }
    }

    public static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, 20);
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }
}
