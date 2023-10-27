package Element;

import org.openqa.selenium.By;

public class UserElement {


        /***
     *       登录页面
         *       id
         *       账号
         *       密码
         *       验证码
         *       登录
     *
     */

    // 定义页面元素的定位方式
    public static By MerchantId = By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input");
    public static By usernameField = By.xpath("//*[@id=\"app\"]/div/form/div[3]/div/div/input");
    public static By passwordField = By.xpath("//*[@id=\"app\"]/div/form/div[4]/div/div/input");
    public static By loginButton = By.xpath("//*[@id=\"app\"]/div/form/button/span");
    public static By code = By.xpath("//*[@id=\"app\"]/div/form/div[6]/div/div[2]/button/span");
    public static By inputCode = By.xpath("//*[@id=\"app\"]/div/form/div[6]/div/div[1]/div/input");


    /**
     *   点击首页
     *   点击用户列表
     *   输入昵称
     *   点击时间关闭按钮
     *   点击ID
     *   点击资金明细
     *   获取充值总计金额
     *   获取今日充值
     *   获取昨日充值
     *   获取前日充值
     *
     *
     * */

    public static By Home = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span");
    public static By userList = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[1]/div/a/li/span");
    public static By nickname = By.xpath("//*[@id=\"app\"]/div/div[2]/section/div/div[1]/div[9]/input");
    public static By dateClose = By.xpath("//*[@id=\"app\"]/div/div[2]/section/div/div[1]/div[1]/div/div[1]/i[2]");
    public static By clickID = By.xpath("//*[@id=\"app\"]/div/div[2]/section/div/div[3]/div[3]/table/tbody/tr/td[3]/div/span/button/span");
    public static By AmountMessage = By.xpath("//*[@id=\"tab-second\"]");
    public static By rechargeTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[2]/td[2]");
    public static By rechargeToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[2]/td[3]");
    public static By rechargeYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[2]/td[4]");
    public static By rechargeBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[2]/td[4]");



    /**
     *   获取提现总计金额
     *   获取今日提现
     *   获取昨日提现
     *   获取前日提现
     *
     * */


    public static By withdrawTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[3]/td[2]");
    public static By withdrawToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[3]/td[3]");
    public static By withdrawYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[3]/td[4]");
    public static By withdrawBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[3]/td[5]");



    /**
     *   获取优惠总计金额
     *   获取今日优惠
     *   获取昨日优惠
     *   获取前日优惠
     *
     * */


    public static By discountTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[4]/td[2]");
    public static By discountToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[4]/td[3]");
    public static By discountYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[4]/td[4]");
    public static By discountBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[4]/td[5]");


    /**
     *   获取活动总计金额
     *   获取今日活动
     *   获取昨日活动
     *   获取前日活动
     *
     * */


    public static By activityTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[5]/td[2]");
    public static By activityToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[5]/td[3]");
    public static By activityYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[5]/td[4]");
    public static By activityBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[5]/td[5]");



    /**
     *   获取下级返点总计金额
     *   获取今日下级返点
     *   获取昨日下级返点
     *   获取前日下级返点
     *
     * */


    public static By subordinateWaterTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[2]");
    public static By subordinateWaterToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[3]");
    public static By subordinateWaterYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[4]");
    public static By subordinateWaterBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[5]");


    /**
     *   获取自身返水总计金额
     *   获取今日自身返水
     *   获取昨日自身返水
     *   获取前日自身返水
     *
     * */


    public static By selfWaterTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[2]");
    public static By selfWaterToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[3]");
    public static By selfWaterYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[4]");
    public static By selfWaterBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[5]");



    /**
     *   获取礼物总计金额
     *   获取今日礼物
     *   获取昨日礼物
     *   获取前日礼物
     *
     * */


    public static By giftTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[2]");
    public static By giftToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[3]");
    public static By giftYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[4]");
    public static By giftBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[6]/td[5]");



    /**
     *   获取订阅总计金额
     *   获取今日订阅
     *   获取昨日订阅
     *   获取前日订阅
     *
     * */


    public static By subscriptionTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[2]/span[2]");
    public static By subscriptionToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[3]/span[2]");
    public static By subscriptionYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[4]/span[2]");
    public static By subscriptionBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[5]/span[2]");



    /**
     *   获取互动总计金额
     *   获取今日互动
     *   获取昨日互动
     *   获取前日互动
     *
     * */


    public static By interactTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[2]/span[3]");
    public static By interactToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[3]/span[3]");
    public static By interactYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[4]/span[3]");
    public static By interactBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[4]/span[3]");




    /**
     *   获取打赏总计金额
     *   获取今日打赏
     *   获取昨日打赏
     *   获取前日打赏
     *
     * */


    public static By rewardTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[2]/span[4]");
    public static By rewardToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[3]/span[4]");
    public static By rewardYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[4]/span[4]");
    public static By rewardBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[8]/td[5]/span[4]");



    /**
     *   获取DFG中奖金额总计
     *   获取今日DFG中奖
     *   获取昨日DFG中奖
     *   获取前日DFG中奖
     *
     * */


    public static By DFGLuckyTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[2]/span[1]");
    public static By DFGLuckyToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[3]/span[1]");
    public static By DFGLuckyYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[4]/span[1]");
    public static By DFGLuckyBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[5]/span[1]");


    /**
     *   获取DFG投注金额总计
     *   获取今日DFG投注
     *   获取昨日DFG投注
     *   获取前日DFG投注
     *
     * */


    public static By DFGBetTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[2]/span[2]");
    public static By DFGBetToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[3]/span[2]");
    public static By DFGBetYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[4]/span[2]");
    public static By DFGBetBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[5]/span[2]");


    /**
     *   获取DFG玩家盈亏金额总计
     *   获取今日DFG玩家盈亏
     *   获取昨日DFG玩家盈亏
     *   获取前日DFG玩家盈亏
     *
     * */


    public static By DFGWinLoseTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[2]/span[3]");
    public static By DFGWinLoseToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[3]/span[3]");
    public static By DFGWinLoseYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[4]/span[3]");
    public static By DFGWinLoseBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[9]/td[5]/span[3]");


    /**
     *   获取三方游戏中奖金额总计
     *   获取今日三方游戏中奖
     *   获取昨日三方游戏中奖
     *   获取前日三方游戏中奖
     *
     * */


    public static By threeGameLuckyTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[2]/span[1]");
    public static By threeGameLuckyToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[3]/span[1]");
    public static By threeGameLuckyYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[4]/span[1]");
    public static By threeGameLuckyBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[5]/span[1]");


    /**
     *   获取三方游戏投注金额总计
     *   获取今日三方游戏投注
     *   获取昨日三方游戏投注
     *   获取前日三方游戏投注
     *
     * */


    public static By threeGameBetTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[2]/span[2]");
    public static By threeGameBetToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[3]/span[2]");
    public static By threeGameBetYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[4]/span[2]");
    public static By threeGameBetBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[5]/span[2]");


    /**
     *   获取三方游戏盈亏金额总计
     *   获取今日三方游戏盈亏
     *   获取昨日三方游戏盈亏
     *   获取前日三方游戏盈亏
     *
     * */


    public static By threeGameWinLoseTotal = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[2]/span[3]");
    public static By threeGameWinLoseToday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[3]/span[3]");
    public static By threeGameWinLoseYesterday = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[4]/span[3]");
    public static By threeGameWinLoseBefore = By.xpath("//*[@id=\"pane-second\"]/div[1]/div/div[2]/table/tr[10]/td[5]/span[3]");






}
