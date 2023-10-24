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

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class userList {
    private WebDriver driver;
    private PageActions pageActions;


    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {

        // 设置 Docker 中 Selenium 服务器的地址
       // String seleniumServer = "http://localhost:4444/wd/hub";
        // 配置 Chrome WebDriver
        //ChromeOptions options = new ChromeOptions();
        //WebDriver driver = new RemoteWebDriver(new URL(seleniumServer), options);

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();


        driver.get("https://uat.marke88.com/cms/?#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageActions = new PageActions(driver);

        //登录
        pageActions.sendKeyID("800");
        pageActions.enterUsername("kane01");
        pageActions.enterPassword("kane01");
        pageActions.clickCode();
        Thread.sleep(5000);
        pageActions.clickLoginButton();
        Thread.sleep(4000);
    }


    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员充值金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取充值总计金额；5.获取今日充值+昨日充值+前日充值；6.计算充值总计")
    @Description("验证会员充值金额总计")
    @Test(priority = 1)
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

        String rechargeTotal = pageActions.rechargeTotal();
        String rechargeToday = pageActions.rechargeToday();
        String rechargeYesterday = pageActions.rechargeYesterday();
        String rechargeBefore = pageActions.rechargeBefore();

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
            BugTracker.submitBug(bugTitle, bugDetails);
        }
        **/
    }



    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员提现金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取提现总计金额；5.获取今日提现+昨日提现+前日提现；6.计算提现总计")
    @Description("验证会员提现金额总计")
    @Test(priority = 2)
    public void withdrawTotal() throws InterruptedException {
        String withdrawTotal = pageActions.withdrawTotal();
        String withdrawToday = pageActions.withdrawToday();
        String withdrawYesterday = pageActions.withdrawYesterday();
        String withdrawBefore = pageActions.withdrawBefore();

        BigDecimal withdrawTotal1 = new BigDecimal(withdrawTotal);
        BigDecimal withdrawToday1 = new BigDecimal(withdrawToday);
        BigDecimal withdrawYesterday1 = new BigDecimal(withdrawYesterday);
        BigDecimal withdrawBefore1 = new BigDecimal(withdrawBefore);

        System.out.println("充值金额总计："+withdrawTotal1);
        System.out.println("今日充值："+withdrawToday1);
        System.out.println("昨日充值："+withdrawYesterday1);
        System.out.println("前日充值："+withdrawBefore1);


        BigDecimal result = withdrawToday1.add(withdrawYesterday1).add(withdrawBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(withdrawTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }




    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员优惠金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取优惠总计金额；5.获取今日+昨日+前日；6.计算优惠总计")
    @Description("验证会员优惠金额总计")
    @Test(priority = 3)
    public void discountTotal() throws InterruptedException {
        String discountTotal = pageActions.discountTotal();
        String discountToday = pageActions.discountToday();
        String discountYesterday = pageActions.discountYesterday();
        String discountBefore = pageActions.discountBefore();

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



    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员活动金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取活动总计金额；5.获取今日+昨日+前日；6.计算活动总计")
    @Description("验证会员活动金额总计")
    @Test(priority = 4)
    public void activityTotal() throws InterruptedException {
        String activityTotal = pageActions.activityTotal();
        String activityToday = pageActions.activityToday();
        String activityYesterday = pageActions.activityYesterday();
        String activityBefore = pageActions.activityBefore();

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



    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员下级返点金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取下级返点总计金额；5.获取今日+昨日+前日；6.计算下级返点金额总计")
    @Description("验证会员下级返点金额总计")
    @Test(priority = 5)
    public void subordinateWaterTotal() throws InterruptedException {
        String subordinateWaterTotal = pageActions.subordinateWaterTotal();
        String subordinateWaterToday = pageActions.subordinateWaterToday();
        String subordinateWaterYesterday = pageActions.subordinateWaterYesterday();
        String subordinateWaterBefore = pageActions.subordinateWaterBefore();

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


    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员自身返水金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取自身返水总计金额；5.获取今日+昨日+前日；6.计算自身返水金额总计")
    @Description("验证会员自身返水金额总计")
    @Test(priority = 6)
    public void selfWaterTotal() throws InterruptedException {
        String selfWaterTotal = pageActions.selfWaterTotal();
        String selfWaterToday = pageActions.selfWaterToday();
        String selfWaterYesterday = pageActions.selfWaterYesterday();
        String selfWaterBefore = pageActions.selfWaterBefore();

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

    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员礼物金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取礼物总计金额；5.获取今日+昨日+前日；6.计算礼物金额总计")
    @Description("验证会员礼物金额总计")
    @Test(priority = 7)
    public void giftTotal() throws InterruptedException {
        String giftTotal = pageActions.giftTotal();
        String giftToday = pageActions.giftToday();
        String giftYesterday = pageActions.giftYesterday();
        String giftBefore = pageActions.giftBefore();

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



    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员订阅金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取订阅总计金额；5.获取今日+昨日+前日；6.计算订阅金额总计")
    @Description("验证会员订阅金额总计")
    @Test(priority = 8)
    public void subscriptionTotal() throws InterruptedException {
        String subscriptionTotal = pageActions.subscriptionTotal();
        String subscriptionToday = pageActions.subscriptionToday();
        String subscriptionYesterday = pageActions.subscriptionYesterday();
        String subscriptionBefore = pageActions.subscriptionBefore();

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



    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员互动金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取互动总计金额；5.获取今日+昨日+前日；6.计算互动金额总计")
    @Description("验证会员互动金额总计")
    @Test(priority = 9)
    public void interactTotal() throws InterruptedException {
        String interactTotal = pageActions.interactTotal();
        String interactToday = pageActions.interactToday();
        String interactYesterday = pageActions.interactYesterday();
        String interactBefore = pageActions.interactBefore();

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




    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员打赏金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取打赏总计金额；5.获取今日+昨日+前日；6.计算打赏金额总计")
    @Description("验证会员打赏金额总计")
    @Test(priority = 10)
    public void rewardTotal() throws InterruptedException {
        String rewardTotal = pageActions.rewardTotal();
        String rewardToday = pageActions.rewardToday();
        String rewardYesterday = pageActions.rewardYesterday();
        String rewardBefore = pageActions.rewardBefore();

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


    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员DFG中奖金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取DFG中奖总计金额；5.获取今日+昨日+前日；6.计算DFG中奖金额总计")
    @Description("验证会员DFG中奖金额总计")
    @Test(priority = 11)
    public void DFGLuckyTotal() throws InterruptedException {
        String DFGLuckyTotal = pageActions.DFGLuckyTotal();
        String DFGLuckyToday = pageActions.DFGLuckyToday();
        String DFGLuckyYesterday = pageActions.DFGLuckyYesterday();
        String DFGLuckyBefore = pageActions.DFGLuckyBefore();

        BigDecimal DFGLuckyTotal1 = new BigDecimal(DFGLuckyTotal);
        BigDecimal DFGLuckyToday1 = new BigDecimal(DFGLuckyToday);
        BigDecimal DFGLuckyYesterday1 = new BigDecimal(DFGLuckyYesterday);
        BigDecimal DFGLuckyBefore1 = new BigDecimal(DFGLuckyBefore);

        System.out.println("DFG中奖金额总计："+DFGLuckyTotal);
        System.out.println("今日DFG中奖："+DFGLuckyToday);
        System.out.println("昨日DFG中奖："+DFGLuckyYesterday);
        System.out.println("前日DFG中奖："+DFGLuckyBefore);


        BigDecimal result = DFGLuckyToday1.add(DFGLuckyYesterday1).add(DFGLuckyBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(DFGLuckyTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员DFG投注金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取DFG投注总计金额；5.获取今日+昨日+前日；6.计算DFG投注金额总计")
    @Description("验证会员DFG投注金额总计")
    @Test(priority = 12)
    public void DFGBetTotal() throws InterruptedException {
        String DFGBetTotal = pageActions.DFGBetTotal();
        String DFGBetToday = pageActions.DFGBetToday();
        String DFGBetYesterday = pageActions.DFGBetYesterday();
        String DFGBetBefore = pageActions.DFGBetBefore();

        BigDecimal DFGBetTotal1 = new BigDecimal(DFGBetTotal);
        BigDecimal DFGBetToday1 = new BigDecimal(DFGBetToday);
        BigDecimal DFGBetYesterday1 = new BigDecimal(DFGBetYesterday);
        BigDecimal DFGBetBefore1 = new BigDecimal(DFGBetBefore);

        System.out.println("DFG投注金额总计："+DFGBetTotal);
        System.out.println("今日DFG投注："+DFGBetToday);
        System.out.println("昨日DFG投注："+DFGBetYesterday);
        System.out.println("前日DFG投注："+DFGBetBefore);


        BigDecimal result = DFGBetToday1.add(DFGBetYesterday1).add(DFGBetBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(DFGBetTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }



    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员DFG玩家盈亏金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取DFG玩家盈亏总计金额；5.获取今日+昨日+前日；6.计算DFG玩家盈亏金额总计")
    @Description("验证会员DFG投注金额总计")
    @Test(priority = 13)
    public void DFGWinLoseTotal() throws InterruptedException {
        String DFGWinLoseTotal = pageActions.DFGWinLoseTotal();
        String DFGWinLoseToday = pageActions.DFGWinLoseToday();
        String DFGWinLoseYesterday = pageActions.DFGWinLoseYesterday();
        String DFGWinLoseBefore = pageActions.DFGWinLoseBefore();

        BigDecimal DFGWinLoseTotal1 = new BigDecimal(DFGWinLoseTotal);
        BigDecimal DFGWinLoseToday1 = new BigDecimal(DFGWinLoseToday);
        BigDecimal DFGWinLoseYesterday1 = new BigDecimal(DFGWinLoseYesterday);
        BigDecimal DFGWinLoseBefore1 = new BigDecimal(DFGWinLoseBefore);

        System.out.println("DFG玩家盈亏金额总计："+DFGWinLoseTotal);
        System.out.println("今日DFG玩家盈亏："+DFGWinLoseToday);
        System.out.println("昨日DFG玩家盈亏："+DFGWinLoseYesterday);
        System.out.println("前日DFG玩家盈亏："+DFGWinLoseBefore);


        BigDecimal result = DFGWinLoseToday1.add(DFGWinLoseYesterday1).add(DFGWinLoseBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(DFGWinLoseTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员三方游戏中奖金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取三方游戏中奖总计金额；5.获取今日+昨日+前日；6.计算三方游戏中奖金额总计")
    @Description("验证会员三方游戏中奖金额总计")
    @Test(priority = 14)
    public void threeGameLuckyTotal() throws InterruptedException {
        String threeGameLuckyTotal = pageActions.threeGameLuckyTotal();
        String threeGameLuckyToday = pageActions.threeGameLuckyToday();
        String threeGameLuckyYesterday = pageActions.threeGameLuckyYesterday();
        String threeGameLuckyBefore = pageActions.threeGameLuckyBefore();

        BigDecimal threeGameLuckyTotal1 = new BigDecimal(threeGameLuckyTotal);
        BigDecimal threeGameLuckyToday1 = new BigDecimal(threeGameLuckyToday);
        BigDecimal threeGameLuckyYesterday1 = new BigDecimal(threeGameLuckyYesterday);
        BigDecimal threeGameLuckyBefore1 = new BigDecimal(threeGameLuckyBefore);

        System.out.println("三方游戏中奖金额总计："+threeGameLuckyTotal);
        System.out.println("今日三方游戏中奖："+threeGameLuckyToday);
        System.out.println("昨日三方游戏中奖："+threeGameLuckyYesterday);
        System.out.println("前日三方游戏中奖："+threeGameLuckyBefore1);


        BigDecimal result = threeGameLuckyToday1.add(threeGameLuckyYesterday1).add(threeGameLuckyBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(threeGameLuckyTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }


    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员三方游戏投注金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取三方游戏投注总计金额；5.获取今日+昨日+前日；6.计算三方游戏投注金额总计")
    @Description("验证会员三方游戏投注金额总计")
    @Test(priority = 15)
    public void threeGameBetTotal() throws InterruptedException {
        String threeGameBetTotal = pageActions.threeGameBetTotal();
        String threeGameBetToday = pageActions.threeGameBetToday();
        String threeGameBetYesterday = pageActions.threeGameBetYesterday();
        String threeGameBetBefore = pageActions.threeGameBetBefore();

        BigDecimal threeGameBetTotal1 = new BigDecimal(threeGameBetTotal);
        BigDecimal threeGameBetToday1 = new BigDecimal(threeGameBetToday);
        BigDecimal threeGameBetYesterday1 = new BigDecimal(threeGameBetYesterday);
        BigDecimal threeGameBetBefore1 = new BigDecimal(threeGameBetBefore);

        System.out.println("三方游戏投注金额总计："+threeGameBetTotal);
        System.out.println("今日三方游戏投注："+threeGameBetToday);
        System.out.println("昨日三方游戏投注："+threeGameBetYesterday);
        System.out.println("前日三方游戏投注："+threeGameBetBefore1);


        BigDecimal result = threeGameBetToday1.add(threeGameBetYesterday1).add(threeGameBetBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(threeGameBetTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }



    @Features("用户列表")
    @Stories("会员资金信息")
    @Title("验证会员三方游戏盈亏金额总计")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.点击用户列表，2.输入用户昵称：凯恩一；3.进入资金信息’4.获取三方游戏盈亏总计金额；5.获取今日+昨日+前日；6.计算三方游戏盈亏金额总计")
    @Description("验证会员三方游戏盈亏金额总计")
    @Test(priority = 16)
    public void threeGameWinLoseTotal() throws InterruptedException {
        String threeGameWinLoseTotal = pageActions.threeGameWinLoseTotal();
        String threeGameWinLoseToday = pageActions.threeGameWinLoseToday();
        String threeGameWinLoseYesterday = pageActions.threeGameWinLoseYesterday();
        String threeGameWinLoseBefore = pageActions.threeGameWinLoseBefore();

        BigDecimal threeGameWinLoseTotal1 = new BigDecimal(threeGameWinLoseTotal);
        BigDecimal threeGameWinLoseToday1 = new BigDecimal(threeGameWinLoseToday);
        BigDecimal threeGameWinLoseYesterday1 = new BigDecimal(threeGameWinLoseYesterday);
        BigDecimal threeGameWinLoseBefore1 = new BigDecimal(threeGameWinLoseBefore);

        System.out.println("三方游戏盈亏金额总计："+threeGameWinLoseTotal);
        System.out.println("今日三三方游戏盈亏："+threeGameWinLoseToday);
        System.out.println("昨日三方游戏盈亏注："+threeGameWinLoseYesterday);
        System.out.println("前日三方游戏盈亏："+threeGameWinLoseBefore1);


        BigDecimal result = threeGameWinLoseToday1.add(threeGameWinLoseYesterday1).add(threeGameWinLoseBefore1);
        System.out.println("今日+昨日+前日："+result);

        Assertion.verifyEquals(threeGameWinLoseTotal1,result);
        Assert.assertTrue(Assertion.currentFlag());
    }



    @AfterClass
    public void tearDown() {
        // 清理和关闭 WebDriver
        driver.quit();
    }
}
