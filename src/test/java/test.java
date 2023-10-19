import ListenerPackage.Assertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class test {
    private WebDriver driver;
    private PageActions pageActions;


    @BeforeClass
    public void setUp() throws MalformedURLException {

        // 设置 Docker 中 Selenium 服务器的地址
        String seleniumServer = "http://localhost:4444/wd/hub";

        // 配置 Chrome WebDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL(seleniumServer), options);

        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        //driver = new ChromeDriver();


        driver.get("https://uat.marke88.com/cms/?#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageActions = new PageActions(driver);
    }


    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证会员对账差别金额数据第一条数据")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入会员对账，2.计算对账差别金额")
    @Description("验证会员对账差别金额第一条数据")
    @Test(priority = 1)
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
