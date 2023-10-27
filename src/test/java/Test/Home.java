package Test;

import Database.DatabaseHelper;
import ListenerAssertion.Assertion;
import Method.UserMethod;
import io.qameta.allure.Epic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class Home {
    private WebDriver driver;
    private UserMethod pageActions;

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {

        // 设置 Docker 中 Selenium 服务器的地址
        // String seleniumServer = "http://localhost:4444/wd/hub";
        // 配置 Chrome WebDriver
        //ChromeOptions options = new ChromeOptions();
        //WebDriver driver = new RemoteWebDriver(new URL(seleniumServer), options);

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();


        driver.get("");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageActions = new UserMethod(driver);

        //登录
        pageActions.sendKeyID("800");
        pageActions.enterUsername("kane01");
        pageActions.enterPassword("kane01");
        pageActions.clickCode();
        Thread.sleep(5000);
        pageActions.clickLoginButton();
        Thread.sleep(4000);
    }



    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员充值金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表<br>2.输入用户昵称：凯恩一<br>3.进入资金信息<br>4.获取充值总计金额<br>5.获取今日充值金额，昨日充值金额，前日充值金额<br>6.计算充值总计")
    @Description("验证会员充值金额总计")
    @Test(priority = 1)
    public void DateTest() throws InterruptedException {
        pageActions.Home();
        pageActions.userList();
        Thread.sleep(2000);
        pageActions.nickname("凯恩一");
        pageActions.dateClose();
        Thread.sleep(2000);
        pageActions.clickID();
        Thread.sleep(2000);
        pageActions.AmountMessage();
        Thread.sleep(2000);

        pageActions.rechargeToday();

        String rechargeToday = pageActions.rechargeToday();
        BigDecimal rechargeToday1 = new BigDecimal(rechargeToday);
        System.out.println("今日充值："+rechargeToday1);

        DatabaseHelper dbHelper = new DatabaseHelper("");
        String sqlQuery = "select balance from `lg-membership-uat`.old_member where nickname = 'eysjskd'";
        ResultSet resultSet = dbHelper.executeQuery(sqlQuery);

        try {
            while (resultSet.next()) {
                // 处理查询结果
                BigDecimal balance = resultSet.getBigDecimal("balance");

                System.out.println(" Balance: " + balance);
                // 断言余额与 rechargeToday 是否相等
                Assertion.verifyEquals(rechargeToday1,balance);
                Assert.assertTrue(Assertion.currentFlag());
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @AfterClass
    public void tearDown() {
        // 清理和关闭 WebDriver
        driver.quit();
    }

}