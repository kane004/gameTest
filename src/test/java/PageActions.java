import org.openqa.selenium.WebDriver;

public class PageActions {
    private WebDriver driver;

    public PageActions(WebDriver driver) {
        this.driver = driver;
    }




    /**
     *  登录功能
     *
     *   1.输入id
     *   2.清空输入用户名
     *   3.清空输入密码
     *   4.获取验证码
     *   5.输入验证码
     *   6.点击登录
     *
     *
     * */

    public void sendKeyID(String sendID) {
        driver.findElement(ElementLocators.MerchantId).sendKeys(sendID);
    }
    public void enterUsername(String username) {
        driver.findElement(ElementLocators.usernameField).clear();
        driver.findElement(ElementLocators.usernameField).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(ElementLocators.passwordField).clear();
        driver.findElement(ElementLocators.passwordField).sendKeys(password);
    }
    public void clickCode() {
        driver.findElement(ElementLocators.code).click();
    }

    public void clickLoginButton() {

        driver.findElement(ElementLocators.loginButton).click();
    }



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

    public void Home() {
        driver.findElement(ElementLocators.Home).click();
    }
    public void userList() {
        driver.findElement(ElementLocators.userList).click();

    }
    public void nickname(String nickname) {
        driver.findElement(ElementLocators.nickname).clear();
        driver.findElement(ElementLocators.nickname).sendKeys(nickname);
    }
    public void dateClose() {
        driver.findElement(ElementLocators.dateClose).click();
    }
    public void clickID() {
        driver.findElement(ElementLocators.clickID).click();

    }
    public void AmountMessage() {
        driver.findElement(ElementLocators.AmountMessage).click();

    }
    public String rechargeTotal() {
       return driver.findElement(ElementLocators.rechargeTotal).getText();

    }
    public String rechargeToday() {
       return driver.findElement(ElementLocators.rechargeToday).getText();

    }
    public String rechargeYesterday() {
       return driver.findElement(ElementLocators.rechargeYesterday).getText();

    }
    public String rechargeBefore() {
        return driver.findElement(ElementLocators.rechargeBefore).getText();

    }


    /**

     *   获取充值金额总计
     *   获取今日提现
     *   获取昨日提现
     *   获取前日提现
     *
     *
     * */


    public String withdrawTotal() {
        return driver.findElement(ElementLocators.withdrawTotal).getText();

    }
    public String withdrawToday() {
        return driver.findElement(ElementLocators.withdrawToday).getText();

    }
    public String withdrawYesterday() {
        return driver.findElement(ElementLocators.withdrawYesterday).getText();

    }
    public String withdrawBefore() {
        return driver.findElement(ElementLocators.withdrawBefore).getText();

    }


    /**

     *   获取优惠金额总计
     *   获取今日优惠
     *   获取昨日优惠
     *   获取前日优惠
     *
     *
     * */


    public String discountTotal() {
        return driver.findElement(ElementLocators.discountTotal).getText();

    }
    public String discountToday() {
        return driver.findElement(ElementLocators.discountToday).getText();

    }
    public String discountYesterday() {
        return driver.findElement(ElementLocators.discountYesterday).getText();

    }
    public String discountBefore() {
        return driver.findElement(ElementLocators.discountBefore).getText();

    }



    /**

     *   获取活动金额总计
     *   获取今日活动
     *   获取昨日活动
     *   获取前日活动
     *
     *
     * */


    public String activityTotal() {
        return driver.findElement(ElementLocators.activityTotal).getText();

    }
    public String activityToday() {
        return driver.findElement(ElementLocators.activityToday).getText();

    }
    public String activityYesterday() {
        return driver.findElement(ElementLocators.activityYesterday).getText();

    }
    public String activityBefore() {
        return driver.findElement(ElementLocators.activityBefore).getText();

    }


    /**

     *   获取下级返点金额总计
     *   获取今日下级返点
     *   获取昨日下级返点
     *   获取前日下级返点
     *
     *
     * */


    public String subordinateWaterTotal() {
        return driver.findElement(ElementLocators.subordinateWaterTotal).getText();

    }
    public String subordinateWaterToday() {
        return driver.findElement(ElementLocators.subordinateWaterToday).getText();

    }
    public String subordinateWaterYesterday() {
        return driver.findElement(ElementLocators.subordinateWaterYesterday).getText();

    }
    public String subordinateWaterBefore() {
        return driver.findElement(ElementLocators.subordinateWaterBefore).getText();

    }



    /**
     *   获取自身返水总计金额
     *   获取今日自身返水
     *   获取昨日自身返水
     *   获取前日自身返水
     *
     * */


    public String selfWaterTotal() {
        return driver.findElement(ElementLocators.selfWaterTotal).getText();

    }
    public String selfWaterToday() {
        return driver.findElement(ElementLocators.selfWaterToday).getText();

    }
    public String selfWaterYesterday() {
        return driver.findElement(ElementLocators.selfWaterYesterday).getText();

    }
    public String selfWaterBefore() {
        return driver.findElement(ElementLocators.selfWaterBefore).getText();

    }


    /**
     *   获取礼物总计金额
     *   获取今日礼物
     *   获取昨日礼物
     *   获取前日礼物
     *
     * */


    public String giftTotal() {
        return driver.findElement(ElementLocators.giftTotal).getText();

    }
    public String giftToday() {
        return driver.findElement(ElementLocators.giftToday).getText();

    }
    public String giftYesterday() {
        return driver.findElement(ElementLocators.giftYesterday).getText();

    }
    public String giftBefore() {
        return driver.findElement(ElementLocators.giftBefore).getText();

    }



    /**
     *   获取订阅总计金额
     *   获取今日订阅
     *   获取昨日订阅
     *   获取前日订阅
     *
     * */


    public String subscriptionTotal() {
        return driver.findElement(ElementLocators.subscriptionTotal).getText();

    }
    public String subscriptionToday() {
        return driver.findElement(ElementLocators.subscriptionToday).getText();

    }
    public String subscriptionYesterday() {
        return driver.findElement(ElementLocators.subscriptionYesterday).getText();

    }
    public String subscriptionBefore() {
        return driver.findElement(ElementLocators.subscriptionBefore).getText();

    }



    /**
     *   获取互动总计金额
     *   获取今日互动
     *   获取昨日互动
     *   获取前日互动
     *
     * */


    public String interactTotal() {
        return driver.findElement(ElementLocators.interactTotal).getText();

    }
    public String interactToday() {
        return driver.findElement(ElementLocators.interactToday).getText();

    }
    public String interactYesterday() {
        return driver.findElement(ElementLocators.interactYesterday).getText();

    }
    public String interactBefore() {
        return driver.findElement(ElementLocators.interactBefore).getText();

    }


    /**
     *   获取打赏总计金额
     *   获取今日打赏
     *   获取昨日打赏
     *   获取前日打赏
     *
     * */


    public String rewardTotal() {
        return driver.findElement(ElementLocators.rewardTotal).getText();

    }
    public String rewardToday() {
        return driver.findElement(ElementLocators.rewardToday).getText();

    }
    public String rewardYesterday() {
        return driver.findElement(ElementLocators.rewardYesterday).getText();

    }
    public String rewardBefore() {
        return driver.findElement(ElementLocators.rewardBefore).getText();

    }



    /**
     *   获取DFG中奖金额总计
     *   获取今日DFG中奖
     *   获取昨日DFG中奖
     *   获取前日DFG中奖
     *
     * */


    public String DFGLuckyTotal() {
        return driver.findElement(ElementLocators.DFGLuckyTotal).getText();

    }
    public String DFGLuckyToday() {
        return driver.findElement(ElementLocators.DFGLuckyToday).getText();

    }
    public String DFGLuckyYesterday() {
        return driver.findElement(ElementLocators.DFGLuckyYesterday).getText();

    }
    public String DFGLuckyBefore() {
        return driver.findElement(ElementLocators.DFGLuckyBefore).getText();

    }


    /**
     *   获取DFG投注金额总计
     *   获取今日DFG投注
     *   获取昨日DFG投注
     *   获取前日DFG投注
     *
     * */


    public String DFGBetTotal() {
        return driver.findElement(ElementLocators.DFGBetTotal).getText();

    }
    public String DFGBetToday() {
        return driver.findElement(ElementLocators.DFGBetToday).getText();

    }
    public String DFGBetYesterday() {
        return driver.findElement(ElementLocators.DFGBetYesterday).getText();

    }
    public String DFGBetBefore() {
        return driver.findElement(ElementLocators.DFGBetBefore).getText();

    }



    /**
     *   获取DFG玩家盈亏金额总计
     *   获取今日DFG玩家盈亏
     *   获取昨日DFG玩家盈亏
     *   获取前日DFG玩家盈亏
     *
     * */


    public String DFGWinLoseTotal() {
        return driver.findElement(ElementLocators.DFGWinLoseTotal).getText();

    }
    public String DFGWinLoseToday() {
        return driver.findElement(ElementLocators.DFGWinLoseToday).getText();

    }
    public String DFGWinLoseYesterday() {
        return driver.findElement(ElementLocators.DFGWinLoseYesterday).getText();

    }
    public String DFGWinLoseBefore() {
        return driver.findElement(ElementLocators.DFGWinLoseBefore).getText();

    }

    /**
     *   获取三方游戏中奖金额总计
     *   获取今日三方游戏中奖
     *   获取昨日三方游戏中奖
     *   获取前日三方游戏中奖
     *
     * */


    public String threeGameLuckyTotal() {
        return driver.findElement(ElementLocators.threeGameLuckyTotal).getText();

    }
    public String threeGameLuckyToday() {
        return driver.findElement(ElementLocators.threeGameLuckyToday).getText();

    }
    public String threeGameLuckyYesterday() {
        return driver.findElement(ElementLocators.threeGameLuckyYesterday).getText();

    }
    public String threeGameLuckyBefore() {
        return driver.findElement(ElementLocators.threeGameLuckyBefore).getText();

    }



    /**
     *   获取三方游戏投注金额总计
     *   获取今日三方游戏投注
     *   获取昨日三方游戏投注
     *   获取前日三方游戏投注
     *
     * */



    public String threeGameBetTotal() {
        return driver.findElement(ElementLocators.threeGameBetTotal).getText();

    }
    public String threeGameBetToday() {
        return driver.findElement(ElementLocators.threeGameBetToday).getText();

    }
    public String threeGameBetYesterday() {
        return driver.findElement(ElementLocators.threeGameBetYesterday).getText();

    }
    public String threeGameBetBefore() {
        return driver.findElement(ElementLocators.threeGameBetBefore).getText();

    }


    /**
     *   获取三方游戏盈亏金额总计
     *   获取今日三方游戏盈亏
     *   获取昨日三方游戏盈亏
     *   获取前日三方游戏盈亏
     *
     * */



    public String threeGameWinLoseTotal() {
        return driver.findElement(ElementLocators.threeGameWinLoseTotal).getText();

    }
    public String threeGameWinLoseToday() {
        return driver.findElement(ElementLocators.threeGameWinLoseToday).getText();

    }
    public String threeGameWinLoseYesterday() {
        return driver.findElement(ElementLocators.threeGameWinLoseYesterday).getText();

    }
    public String threeGameWinLoseBefore() {
        return driver.findElement(ElementLocators.threeGameWinLoseBefore).getText();

    }


}
