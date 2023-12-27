package Test;

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
import java.util.concurrent.TimeUnit;



public class User {
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
    @Test(priority = 1 )
    public void rechargeTotal() throws InterruptedException {
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
        pageActions.rechargeTotal();
        pageActions.rechargeToday();
        pageActions.rechargeYesterday();

        String rechargeTotal = pageActions.rechargeTotal().replace(",","");
        String rechargeToday = pageActions.rechargeToday().replace("","");
        String rechargeYesterday = pageActions.rechargeYesterday().replace(",","");
        String rechargeBefore = pageActions.rechargeBefore().replace(",","");

        BigDecimal rechargeTotal1 = new BigDecimal(rechargeTotal);
        BigDecimal rechargeToday1 = new BigDecimal(rechargeToday);
        BigDecimal rechargeYesterday1 = new BigDecimal(rechargeYesterday);
        BigDecimal rechargeBefore1 = new BigDecimal(rechargeBefore);

        System.out.println("充值金额总计："+rechargeTotal1);
        System.out.println("今日充值："+rechargeToday1);
        System.out.println("昨日充值："+rechargeYesterday1);
        System.out.println("前日充值："+rechargeYesterday1);


        BigDecimal result = rechargeToday1.add(rechargeYesterday1).add(rechargeBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(rechargeTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());


        /**
         if (!Assertion.currentFlag()) {
            String bugTitle = "Bug Title";
            String bugDetails = "Detailed bug description...";
            Bug.BugTracker.submitBug(bugTitle, bugDetails);
        }
        **/
    }


    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员提现金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取提现总计金额；5.获取今日提现+昨日提现+前日提现；6.计算提现总计")
    @Description("验证会员提现金额总计")
    @Test(priority = 2)
    public void withdrawTotal() throws InterruptedException {
        String withdrawTotal = pageActions.withdrawTotal().replace(",","");
        String withdrawToday = pageActions.withdrawToday().replace(",","");
        String withdrawYesterday = pageActions.withdrawYesterday().replace(",","");
        String withdrawBefore = pageActions.withdrawBefore().replace(",","");

        BigDecimal withdrawTotal1 = new BigDecimal(withdrawTotal);
        BigDecimal withdrawToday1 = new BigDecimal(withdrawToday);
        BigDecimal withdrawYesterday1 = new BigDecimal(withdrawYesterday);
        BigDecimal withdrawBefore1 = new BigDecimal(withdrawBefore);

        System.out.println("提现金额总计："+withdrawTotal1);
        System.out.println("今日提现："+withdrawToday1);
        System.out.println("昨日提现："+withdrawYesterday1);
        System.out.println("前日提现："+withdrawBefore1);


        BigDecimal result = withdrawToday1.add(withdrawYesterday1).add(withdrawBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(withdrawTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }



    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员优惠金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取优惠总计金额；5.获取今日+昨日+前日；6.计算优惠总计")
    @Description("验证会员优惠金额总计")
    @Test(priority = 3)
    public void discountTotal() throws InterruptedException {
        String discountTotal = pageActions.discountTotal().replace(",","");
        String discountToday = pageActions.discountToday().replace(",","");
        String discountYesterday = pageActions.discountYesterday().replace(",","");
        String discountBefore = pageActions.discountBefore().replace(",","");

        BigDecimal discountTotal1 = new BigDecimal(discountTotal);
        BigDecimal discountToday1 = new BigDecimal(discountToday);
        BigDecimal discountYesterday1 = new BigDecimal(discountYesterday);
        BigDecimal discountBefore1 = new BigDecimal(discountBefore);

        System.out.println("优惠金额总计："+discountTotal);
        System.out.println("今日优惠："+discountToday);
        System.out.println("昨日优惠："+discountYesterday);
        System.out.println("前日优惠："+discountBefore);


        BigDecimal result = discountToday1.add(discountYesterday1).add(discountBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(discountTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员活动金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取活动总计金额；5.获取今日+昨日+前日；6.计算活动总计")
    @Description("验证会员活动金额总计")
    @Test(priority = 4)
    public void activityTotal() throws InterruptedException {
        String activityTotal = pageActions.activityTotal().replace(",","");
        String activityToday = pageActions.activityToday().replace(",","");
        String activityYesterday = pageActions.activityYesterday().replace(",","");
        String activityBefore = pageActions.activityBefore().replace(",","");

        BigDecimal activityTotal1 = new BigDecimal(activityTotal);
        BigDecimal activityToday1 = new BigDecimal(activityToday);
        BigDecimal activityYesterday1 = new BigDecimal(activityYesterday);
        BigDecimal activityBefore1 = new BigDecimal(activityBefore);

        System.out.println("活动金额总计："+activityTotal);
        System.out.println("今日活动："+activityToday);
        System.out.println("昨日活动："+activityYesterday);
        System.out.println("前日活动："+activityBefore);


        BigDecimal result = activityToday1.add(activityYesterday1).add(activityBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(activityTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员下级返点金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取下级返点总计金额；5.获取今日+昨日+前日；6.计算下级返点金额总计")
    @Description("验证会员下级返点金额总计")
    @Test(priority = 5)
    public void subordinateWaterTotal() throws InterruptedException {
        String subordinateWaterTotal = pageActions.subordinateWaterTotal().replace(",","");
        String subordinateWaterToday = pageActions.subordinateWaterToday().replace(",","");
        String subordinateWaterYesterday = pageActions.subordinateWaterYesterday().replace(",","");
        String subordinateWaterBefore = pageActions.subordinateWaterBefore().replace(",","");

        BigDecimal subordinateWaterTotal1 = new BigDecimal(subordinateWaterTotal);
        BigDecimal subordinateWaterToday1 = new BigDecimal(subordinateWaterToday);
        BigDecimal subordinateWaterYesterday1 = new BigDecimal(subordinateWaterYesterday);
        BigDecimal subordinateWaterBefore1 = new BigDecimal(subordinateWaterBefore);

        System.out.println("下级返点金额总计："+subordinateWaterTotal);
        System.out.println("今日下级返点："+subordinateWaterToday);
        System.out.println("昨日下级返点："+subordinateWaterYesterday);
        System.out.println("前日下级返点："+subordinateWaterBefore);


        BigDecimal result = subordinateWaterToday1.add(subordinateWaterYesterday1).add(subordinateWaterBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(subordinateWaterTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }

    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员自身返水金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取自身返水总计金额；5.获取今日+昨日+前日；6.计算自身返水金额总计")
    @Description("验证会员自身返水金额总计")
    @Test(priority = 6)
    public void selfWaterTotal() throws InterruptedException {
        String selfWaterTotal = pageActions.selfWaterTotal().replace(",","");
        String selfWaterToday = pageActions.selfWaterToday().replace(",","");
        String selfWaterYesterday = pageActions.selfWaterYesterday().replace(",","");
        String selfWaterBefore = pageActions.selfWaterBefore().replace(",","");

        BigDecimal selfWaterTotal1 = new BigDecimal(selfWaterTotal);
        BigDecimal selfWaterToday1 = new BigDecimal(selfWaterToday);
        BigDecimal selfWaterYesterday1 = new BigDecimal(selfWaterYesterday);
        BigDecimal selfWaterBefore1 = new BigDecimal(selfWaterBefore);

        System.out.println("自身返水金额总计："+selfWaterTotal);
        System.out.println("今日自身返水："+selfWaterToday);
        System.out.println("昨日自身返水："+selfWaterYesterday);
        System.out.println("前日自身返水："+selfWaterBefore);


        BigDecimal result = selfWaterToday1.add(selfWaterYesterday1).add(selfWaterBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(selfWaterTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员礼物金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取礼物总计金额；5.获取今日+昨日+前日；6.计算礼物金额总计")
    @Description("验证会员礼物金额总计")
    @Test(priority = 7)
    public void giftTotal() throws InterruptedException {
        String giftTotal = pageActions.giftTotal().replace(",","");
        String giftToday = pageActions.giftToday().replace(",","");
        String giftYesterday = pageActions.giftYesterday().replace(",","");
        String giftBefore = pageActions.giftBefore().replace(",","");

        BigDecimal giftTotal1 = new BigDecimal(giftTotal);
        BigDecimal giftToday1 = new BigDecimal(giftToday);
        BigDecimal giftYesterday1 = new BigDecimal(giftYesterday);
        BigDecimal giftBefore1 = new BigDecimal(giftBefore);

        System.out.println("礼物金额总计："+giftTotal);
        System.out.println("今日礼物："+giftToday);
        System.out.println("昨日礼物："+giftYesterday);
        System.out.println("前日礼物："+giftBefore);


        BigDecimal result = giftToday1.add(giftYesterday1).add(giftBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(giftTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员订阅金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取订阅总计金额；5.获取今日+昨日+前日；6.计算订阅金额总计")
    @Description("验证会员订阅金额总计")
    @Test(priority = 8)
    public void subscriptionTotal() throws InterruptedException {
        String subscriptionTotal = pageActions.subscriptionTotal().replace(",","");
        String subscriptionToday = pageActions.subscriptionToday().replace(",","");
        String subscriptionYesterday = pageActions.subscriptionYesterday().replace(",","");
        String subscriptionBefore = pageActions.subscriptionBefore().replace(",","");

        BigDecimal subscriptionTotal1 = new BigDecimal(subscriptionTotal);
        BigDecimal subscriptionToday1 = new BigDecimal(subscriptionToday);
        BigDecimal subscriptionYesterday1 = new BigDecimal(subscriptionYesterday);
        BigDecimal subscriptionBefore1 = new BigDecimal(subscriptionBefore);

        System.out.println("订阅金额总计："+subscriptionTotal);
        System.out.println("今日订阅："+subscriptionToday);
        System.out.println("昨日订阅："+subscriptionYesterday);
        System.out.println("前日订阅："+subscriptionBefore);


        BigDecimal result = subscriptionToday1.add(subscriptionYesterday1).add(subscriptionBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(subscriptionTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员互动金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取互动总计金额；5.获取今日+昨日+前日；6.计算互动金额总计")
    @Description("验证会员互动金额总计")
    @Test(priority = 9)
    public void interactTotal() throws InterruptedException {
        String interactTotal = pageActions.interactTotal().replace(",","");
        String interactToday = pageActions.interactToday().replace(",","");
        String interactYesterday = pageActions.interactYesterday().replace(",","");
        String interactBefore = pageActions.interactBefore().replace(",","");

        BigDecimal interactTotal1 = new BigDecimal(interactTotal);
        BigDecimal interactToday1 = new BigDecimal(interactToday);
        BigDecimal interactYesterday1 = new BigDecimal(interactYesterday);
        BigDecimal interactBefore1 = new BigDecimal(interactBefore);

        System.out.println("互动金额总计："+interactTotal);
        System.out.println("今日互动："+interactToday);
        System.out.println("昨日互动："+interactYesterday);
        System.out.println("前日互动："+interactBefore);


        BigDecimal result = interactToday1.add(interactYesterday1).add(interactBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(interactTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }



    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员打赏金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表 2.输入用户昵称：凯恩一；3.进入资金信息’4.获取打赏总计金额；5.获取今日+昨日+前日；6.计算打赏金额总计")
    @Description("验证会员打赏金额总计")
    @Test(priority = 10)
    public void rewardTotal() throws InterruptedException {
        String rewardTotal = pageActions.rewardTotal().replace(",","");
        String rewardToday = pageActions.rewardToday().replace(",","");
        String rewardYesterday = pageActions.rewardYesterday().replace(",","");
        String rewardBefore = pageActions.rewardBefore().replace(",","");

        BigDecimal rewardTotal1 = new BigDecimal(rewardTotal);
        BigDecimal rewardToday1 = new BigDecimal(rewardToday);
        BigDecimal rewardYesterday1 = new BigDecimal(rewardYesterday);
        BigDecimal rewardBefore1 = new BigDecimal(rewardBefore);

        System.out.println("打赏金额总计："+rewardTotal);
        System.out.println("今日打赏："+rewardToday);
        System.out.println("昨日打赏："+rewardYesterday);
        System.out.println("前日打赏："+rewardBefore);


        BigDecimal result = rewardToday1.add(rewardYesterday1).add(rewardBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(rewardTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }

    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员DFG中奖金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取DFG中奖总计金额；5.获取今日+昨日+前日；6.计算DFG中奖金额总计")
    @Description("验证会员DFG中奖金额总计")
    @Test(priority = 11)
    public void DFGLuckyTotal() throws InterruptedException {
        String DFGLuckyTotal = pageActions.DFGLuckyTotal().replace(",","");
        String DFGLuckyToday = pageActions.DFGLuckyToday().replace(",","");
        String DFGLuckyYesterday = pageActions.DFGLuckyYesterday().replace(",","");
        String DFGLuckyBefore = pageActions.DFGLuckyBefore().replace(",","");

        // 截取最后一个字符并保留前面的部分
        String remainingTotal = DFGLuckyTotal.substring(0, DFGLuckyTotal.length() - 1);
        String remainingToday = DFGLuckyToday.substring(0, DFGLuckyToday.length() - 1);
        String remainingYesterday = DFGLuckyYesterday.substring(0, DFGLuckyYesterday.length() - 1);
        String remainingBefore = DFGLuckyBefore.substring(0, DFGLuckyBefore.length() - 1);

        BigDecimal remainingTotal1 = new BigDecimal(remainingTotal);
        BigDecimal DFGLuckyToday1 = new BigDecimal(remainingToday);
        BigDecimal DFGLuckyYesterday1 = new BigDecimal(remainingYesterday);
        BigDecimal DFGLuckyBefore1 = new BigDecimal(remainingBefore);

        System.out.println("DFG中奖金额总计："+remainingTotal);
        System.out.println("今日DFG中奖："+remainingToday);
        System.out.println("昨日DFG中奖："+remainingYesterday);
        System.out.println("前日DFG中奖："+remainingBefore);


        BigDecimal result = DFGLuckyToday1.add(DFGLuckyYesterday1).add(DFGLuckyBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(remainingTotal1, result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员DFG投注金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取DFG投注总计金额；5.获取今日+昨日+前日；6.计算DFG投注金额总计")
    @Description("验证会员DFG投注金额总计")
    @Test(priority = 12)
    public void DFGBetTotal() throws InterruptedException {
        String DFGBetTotal = pageActions.DFGBetTotal().replace(",","");
        String DFGBetToday = pageActions.DFGBetToday().replace(",","");
        String DFGBetYesterday = pageActions.DFGBetYesterday().replace(",","");
        String DFGBetBefore = pageActions.DFGBetBefore().replace(",","");

        // 截取第一个字符并保留后面的部分
        String DFGBetTotal1 = DFGBetTotal.substring(0, DFGBetTotal.length() - 1);
        String DFGBetToday1 = DFGBetToday.substring(0, DFGBetToday.length() - 1);
        String DFGBetYesterday1 = DFGBetYesterday.substring(0, DFGBetYesterday.length() - 1);
        String DFGBetBefore1 = DFGBetBefore.substring(0, DFGBetBefore.length() - 1);

        BigDecimal DFGBetTotal2 = new BigDecimal(DFGBetTotal1);
        BigDecimal DFGBetToday2 = new BigDecimal(DFGBetToday1);
        BigDecimal DFGBetYesterday2 = new BigDecimal(DFGBetYesterday1);
        BigDecimal DFGBetBefore2 = new BigDecimal(DFGBetBefore1);

        System.out.println("DFG投注金额总计："+DFGBetTotal1);
        System.out.println("今日DFG投注："+DFGBetToday1);
        System.out.println("昨日DFG投注："+DFGBetYesterday1);
        System.out.println("前日DFG投注："+DFGBetBefore1);


        BigDecimal result = DFGBetToday2.add(DFGBetYesterday2).add(DFGBetBefore2);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(DFGBetTotal2,result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员DFG玩家盈亏金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取DFG玩家盈亏总计金额；5.获取今日+昨日+前日；6.计算DFG玩家盈亏金额总计")
    @Description("验证会员DFG投注金额总计")
    @Test(priority = 13)
    public void DFGWinLoseTotal() throws InterruptedException {
        String DFGWinLoseTotal = pageActions.DFGWinLoseTotal().replace(",","");
        String DFGWinLoseToday = pageActions.DFGWinLoseToday().replace(",","");
        String DFGWinLoseYesterday = pageActions.DFGWinLoseYesterday().replace(",","");
        String DFGWinLoseBefore = pageActions.DFGWinLoseBefore().replace(",","");

        // 截取第一个字符并保留后面的部分
        String DFGWinLoseTotal1 = DFGWinLoseTotal.substring(0, DFGWinLoseTotal.length() - 1);
        String DFGWinLoseToday1 = DFGWinLoseToday.substring(0, DFGWinLoseToday.length() - 1);
        String DFGWinLoseYesterday1 = DFGWinLoseYesterday.substring(0, DFGWinLoseYesterday.length() - 1);
        String DFGWinLoseBefore1 = DFGWinLoseBefore.substring(0, DFGWinLoseBefore.length() - 1);

        BigDecimal DFGWinLoseTotal2 = new BigDecimal(DFGWinLoseTotal1);
        BigDecimal DFGWinLoseToday2 = new BigDecimal(DFGWinLoseToday1);
        BigDecimal DFGWinLoseYesterday2 = new BigDecimal(DFGWinLoseYesterday1);
        BigDecimal DFGWinLoseBefore2 = new BigDecimal(DFGWinLoseBefore1);

        System.out.println("DFG玩家盈亏金额总计："+DFGWinLoseTotal1);
        System.out.println("今日DFG玩家盈亏："+DFGWinLoseToday1);
        System.out.println("昨日DFG玩家盈亏："+DFGWinLoseYesterday1);
        System.out.println("前日DFG玩家盈亏："+DFGWinLoseBefore1);


        BigDecimal result = DFGWinLoseToday2.add(DFGWinLoseYesterday2).add(DFGWinLoseBefore2);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(DFGWinLoseTotal2,result);
        Assert.assertTrue(Assertion.currentFlag());
    }

    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员三方游戏中奖金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取三方游戏中奖总计金额；5.获取今日+昨日+前日；6.计算三方游戏中奖金额总计")
    @Description("验证会员三方游戏中奖金额总计")
    @Test(priority = 14)
    public void threeGameLuckyTotal() throws InterruptedException {
        String threeGameLuckyTotal = pageActions.threeGameLuckyTotal().replace(",","");
        String threeGameLuckyToday = pageActions.threeGameLuckyToday().replace(",","");
        String threeGameLuckyYesterday = pageActions.threeGameLuckyYesterday().replace(",","");
        String threeGameLuckyBefore = pageActions.threeGameLuckyBefore().replace(",","");

        // 截取第一个字符并保留后面的部分
        String threeGameLuckyTotal1 = threeGameLuckyTotal.substring(0, threeGameLuckyTotal.length() - 1);
        String threeGameLuckyToday1 = threeGameLuckyToday.substring(0, threeGameLuckyToday.length() - 1);
        String threeGameLuckyYesterday1 = threeGameLuckyYesterday.substring(0, threeGameLuckyYesterday.length() - 1);
        String threeGameLuckyBefore1 = threeGameLuckyBefore.substring(0, threeGameLuckyBefore.length() - 1);

        BigDecimal threeGameLuckyTotal2 = new BigDecimal(threeGameLuckyTotal1);
        BigDecimal threeGameLuckyToday2 = new BigDecimal(threeGameLuckyToday1);
        BigDecimal threeGameLuckyYesterday2 = new BigDecimal(threeGameLuckyYesterday1);
        BigDecimal threeGameLuckyBefore2 = new BigDecimal(threeGameLuckyBefore1);

        System.out.println("三方游戏中奖金额总计："+threeGameLuckyTotal1);
        System.out.println("今日三方游戏中奖："+threeGameLuckyToday1);
        System.out.println("昨日三方游戏中奖："+threeGameLuckyYesterday1);
        System.out.println("前日三方游戏中奖："+threeGameLuckyBefore1);


        BigDecimal result = threeGameLuckyToday2.add(threeGameLuckyYesterday2).add(threeGameLuckyBefore2);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(threeGameLuckyTotal2,result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员三方游戏投注金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取三方游戏投注总计金额；5.获取今日+昨日+前日；6.计算三方游戏投注金额总计")
    @Description("验证会员三方游戏投注金额总计")
    @Test(priority = 15)
    public void threeGameBetTotal() throws InterruptedException {
        String threeGameBetTotal = pageActions.threeGameBetTotal().replace(",","");
        String threeGameBetToday = pageActions.threeGameBetToday().replace(",","");
        String threeGameBetYesterday = pageActions.threeGameBetYesterday().replace(",","");
        String threeGameBetBefore = pageActions.threeGameBetBefore().replace(",","");

        // 截取第一个字符并保留后面的部分
        String threeGameBetTotal1 = threeGameBetTotal.substring(0, threeGameBetTotal.length() - 1);
        String threeGameBetToday1 = threeGameBetToday.substring(0, threeGameBetToday.length() - 1);
        String threeGameBetYesterday1 = threeGameBetYesterday.substring(0, threeGameBetYesterday.length() - 1);
        String threeGameBetBefore1 = threeGameBetBefore.substring(0, threeGameBetBefore.length() - 1);

        BigDecimal threeGameBetTotal2 = new BigDecimal(threeGameBetTotal1);
        BigDecimal threeGameBetToday2 = new BigDecimal(threeGameBetToday1);
        BigDecimal threeGameBetYesterday2 = new BigDecimal(threeGameBetYesterday1);
        BigDecimal threeGameBetBefore2 = new BigDecimal(threeGameBetBefore1);

        System.out.println("三方游戏投注金额总计："+threeGameBetTotal1);
        System.out.println("今日三方游戏投注："+threeGameBetToday1);
        System.out.println("昨日三方游戏投注："+threeGameBetYesterday1);
        System.out.println("前日三方游戏投注："+threeGameBetBefore1);


        BigDecimal result = threeGameBetToday2.add(threeGameBetYesterday2).add(threeGameBetBefore2);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(threeGameBetTotal2,result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Epic("用户管理")
    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员三方游戏盈亏金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取三方游戏盈亏总计金额；5.获取今日+昨日+前日；6.计算三方游戏盈亏金额总计")
    @Description("验证会员三方游戏盈亏金额总计")
    @Test(priority = 16)
    public void threeGameWinLoseTotal() throws InterruptedException {
        String threeGameWinLoseTotal = pageActions.threeGameWinLoseTotal().replace(",","");
        String threeGameWinLoseToday = pageActions.threeGameWinLoseToday().replace(",","");
        String threeGameWinLoseYesterday = pageActions.threeGameWinLoseYesterday().replace(",","");
        String threeGameWinLoseBefore = pageActions.threeGameWinLoseBefore().replace(",","");

        // 截取第一个字符并保留后面的部分
        String threeGameWinLoseTotal1 = threeGameWinLoseTotal.substring(0, threeGameWinLoseTotal.length() - 1);
        String threeGameWinLoseToday1 = threeGameWinLoseToday.substring(0, threeGameWinLoseToday.length() - 1);
        String threeGameWinLoseYesterday1 = threeGameWinLoseYesterday.substring(0, threeGameWinLoseYesterday.length() - 1);
        String threeGameWinLoseBefore1 = threeGameWinLoseBefore.substring(0, threeGameWinLoseBefore.length() - 1);

        BigDecimal threeGameWinLoseTotal2 = new BigDecimal(threeGameWinLoseTotal1);
        BigDecimal threeGameWinLoseToday2 = new BigDecimal(threeGameWinLoseToday1);
        BigDecimal threeGameWinLoseYesterday2 = new BigDecimal(threeGameWinLoseYesterday1);
        BigDecimal threeGameWinLoseBefore2 = new BigDecimal(threeGameWinLoseBefore1);

        System.out.println("三方游戏盈亏金额总计："+threeGameWinLoseTotal1);
        System.out.println("今日三方游戏盈亏："+threeGameWinLoseToday1);
        System.out.println("昨日三方游戏盈亏注："+threeGameWinLoseYesterday1);
        System.out.println("前日三方游戏盈亏："+threeGameWinLoseBefore1);


        BigDecimal result = threeGameWinLoseToday2.add(threeGameWinLoseYesterday2).add(threeGameWinLoseBefore2);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(threeGameWinLoseTotal2,result);
        Assert.assertTrue(Assertion.currentFlag());
    }






    @AfterClass
    public void tearDown() {
        // 清理和关闭 WebDriver
        driver.quit();
    }
}
