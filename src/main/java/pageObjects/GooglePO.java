package pageObjects;

import driver.TLDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePO {

    @FindBy(name = "q")
    private WebElement webElement;

    public GooglePO() {
        System.out.println("iNSIDE PO : " + TLDriverFactory.getDriver().hashCode());
        PageFactory.initElements(TLDriverFactory.getDriver(), this);
    }

    public void getUrl() {
        TLDriverFactory.getDriver().get("http://google.com");
    }

    public void typeWOrd(String s) {
        WebElement webElement = TLDriverFactory.getDriver().findElement(By.name("q"));
        webElement.sendKeys(s);
        webElement.submit();
    }

}
