import annotation.Injector;
import annotation.Instance;
import driver.TLDriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.GooglePO;

public class Google {

    @Injector
    public GooglePO googlePO;

    @BeforeMethod
    public void setup() {
        TLDriverFactory.setDriver("chrome");
//        googlePO = new pageObjects.GooglePO();
        Instance.create(this);
        System.out.println("Inside before " + Thread.currentThread().getId());
        System.out.println(TLDriverFactory.getDriver().hashCode());

    }


    @Test
    public void test1() throws InterruptedException {
        System.out.println("Inside test1 " + Thread.currentThread().getId());
//        System.out.println(googlePO.hashCode());
//        pageObjects.GooglePO googlePO = new pageObjects.GooglePO();
        googlePO.getUrl();
        googlePO.typeWOrd("Joey");

        Thread.sleep(5000);
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("Inside test3 " + Thread.currentThread().getId());
//        System.out.println(googlePO.hashCode());
//        pageObjects.GooglePO googlePO = new pageObjects.GooglePO();
        googlePO.getUrl();
        googlePO.typeWOrd("Ross");

        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        TLDriverFactory.getDriver().quit();
    }
}
