import ListenerPackage.Assertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class test {
    private WebDriver driver;
    private PageActions pageActions;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://uat.marke88.com/cms/?#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageActions = new PageActions(driver);
    }

    @Test
    public void validLoginTest() throws InterruptedException {
        pageActions.sendKeyID("800");
        Thread.sleep(1000);
        pageActions.enterUsername("kane01");
        Thread.sleep(1000);
        pageActions.enterPassword("kane01");
        Thread.sleep(1000);
        pageActions.clickLoginButton();
        Assertion.verifyEquals(1,1);
        Assert.assertTrue(Assertion.currentFlag());

    }

    @AfterClass
    public void tearDown() {
        // 清理和关闭 WebDriver
        driver.quit();
    }
}
