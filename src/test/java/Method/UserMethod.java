package Method;

import Element.UserElement;
import org.openqa.selenium.WebDriver;

public class UserMethod {
    private WebDriver driver;

    public UserMethod(WebDriver driver) {
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
        driver.findElement(UserElement.MerchantId).sendKeys(sendID);
    }
    public void enterUsername(String username) {
        driver.findElement(UserElement.usernameField).clear();
        driver.findElement(UserElement.usernameField).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(UserElement.passwordField).clear();
        driver.findElement(UserElement.passwordField).sendKeys(password);
    }
    public void clickCode() {
        driver.findElement(UserElement.code).click();
    }

    public void clickLoginButton() {

        driver.findElement(UserElement.loginButton).click();
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
        driver.findElement(UserElement.Home).click();
    }
    public void userList() {
        driver.findElement(UserElement.userList).click();

    }
    public void nickname(String nickname) {
        driver.findElement(UserElement.nickname).clear();
        driver.findElement(UserElement.nickname).sendKeys(nickname);
    }
    public void dateClose() {
        driver.findElement(UserElement.dateClose).click();
    }
    public void clickID() {
        driver.findElement(UserElement.clickID).click();

    }
    public void AmountMessage() {
        driver.findElement(UserElement.AmountMessage).click();

    }
    public String rechargeTotal() {
       return driver.findElement(UserElement.rechargeTotal).getText();

    }
    public String rechargeToday() {
       return driver.findElement(UserElement.rechargeToday).getText();

    }
    public String rechargeYesterday() {
       return driver.findElement(UserElement.rechargeYesterday).getText();

    }
    public String rechargeBefore() {
        return driver.findElement(UserElement.rechargeBefore).getText();

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
        return driver.findElement(UserElement.withdrawTotal).getText();

    }
    public String withdrawToday() {
        return driver.findElement(UserElement.withdrawToday).getText();

    }
    public String withdrawYesterday() {
        return driver.findElement(UserElement.withdrawYesterday).getText();

    }
    public String withdrawBefore() {
        return driver.findElement(UserElement.withdrawBefore).getText();

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
        return driver.findElement(UserElement.discountTotal).getText();

    }
    public String discountToday() {
        return driver.findElement(UserElement.discountToday).getText();

    }
    public String discountYesterday() {
        return driver.findElement(UserElement.discountYesterday).getText();

    }
    public String discountBefore() {
        return driver.findElement(UserElement.discountBefore).getText();

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
        return driver.findElement(UserElement.activityTotal).getText();

    }
    public String activityToday() {
        return driver.findElement(UserElement.activityToday).getText();

    }
    public String activityYesterday() {
        return driver.findElement(UserElement.activityYesterday).getText();

    }
    public String activityBefore() {
        return driver.findElement(UserElement.activityBefore).getText();

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
        return driver.findElement(UserElement.subordinateWaterTotal).getText();

    }
    public String subordinateWaterToday() {
        return driver.findElement(UserElement.subordinateWaterToday).getText();

    }
    public String subordinateWaterYesterday() {
        return driver.findElement(UserElement.subordinateWaterYesterday).getText();

    }
    public String subordinateWaterBefore() {
        return driver.findElement(UserElement.subordinateWaterBefore).getText();

    }



    /**
     *   获取自身返水总计金额
     *   获取今日自身返水
     *   获取昨日自身返水
     *   获取前日自身返水
     *
     * */


    public String selfWaterTotal() {
        return driver.findElement(UserElement.selfWaterTotal).getText();

    }
    public String selfWaterToday() {
        return driver.findElement(UserElement.selfWaterToday).getText();

    }
    public String selfWaterYesterday() {
        return driver.findElement(UserElement.selfWaterYesterday).getText();

    }
    public String selfWaterBefore() {
        return driver.findElement(UserElement.selfWaterBefore).getText();

    }


    /**
     *   获取礼物总计金额
     *   获取今日礼物
     *   获取昨日礼物
     *   获取前日礼物
     *
     * */


    public String giftTotal() {
        return driver.findElement(UserElement.giftTotal).getText();

    }
    public String giftToday() {
        return driver.findElement(UserElement.giftToday).getText();

    }
    public String giftYesterday() {
        return driver.findElement(UserElement.giftYesterday).getText();

    }
    public String giftBefore() {
        return driver.findElement(UserElement.giftBefore).getText();

    }



    /**
     *   获取订阅总计金额
     *   获取今日订阅
     *   获取昨日订阅
     *   获取前日订阅
     *
     * */


    public String subscriptionTotal() {
        return driver.findElement(UserElement.subscriptionTotal).getText();

    }
    public String subscriptionToday() {
        return driver.findElement(UserElement.subscriptionToday).getText();

    }
    public String subscriptionYesterday() {
        return driver.findElement(UserElement.subscriptionYesterday).getText();

    }
    public String subscriptionBefore() {
        return driver.findElement(UserElement.subscriptionBefore).getText();

    }



    /**
     *   获取互动总计金额
     *   获取今日互动
     *   获取昨日互动
     *   获取前日互动
     *
     * */


    public String interactTotal() {
        return driver.findElement(UserElement.interactTotal).getText();

    }
    public String interactToday() {
        return driver.findElement(UserElement.interactToday).getText();

    }
    public String interactYesterday() {
        return driver.findElement(UserElement.interactYesterday).getText();

    }
    public String interactBefore() {
        return driver.findElement(UserElement.interactBefore).getText();

    }


    /**
     *   获取打赏总计金额
     *   获取今日打赏
     *   获取昨日打赏
     *   获取前日打赏
     *
     * */


    public String rewardTotal() {
        return driver.findElement(UserElement.rewardTotal).getText();

    }
    public String rewardToday() {
        return driver.findElement(UserElement.rewardToday).getText();

    }
    public String rewardYesterday() {
        return driver.findElement(UserElement.rewardYesterday).getText();

    }
    public String rewardBefore() {
        return driver.findElement(UserElement.rewardBefore).getText();

    }



    /**
     *   获取DFG中奖金额总计
     *   获取今日DFG中奖
     *   获取昨日DFG中奖
     *   获取前日DFG中奖
     *
     * */


    public String DFGLuckyTotal() {
        return driver.findElement(UserElement.DFGLuckyTotal).getText();

    }
    public String DFGLuckyToday() {
        return driver.findElement(UserElement.DFGLuckyToday).getText();

    }
    public String DFGLuckyYesterday() {
        return driver.findElement(UserElement.DFGLuckyYesterday).getText();

    }
    public String DFGLuckyBefore() {
        return driver.findElement(UserElement.DFGLuckyBefore).getText();

    }


    /**
     *   获取DFG投注金额总计
     *   获取今日DFG投注
     *   获取昨日DFG投注
     *   获取前日DFG投注
     *
     * */


    public String DFGBetTotal() {
        return driver.findElement(UserElement.DFGBetTotal).getText();

    }
    public String DFGBetToday() {
        return driver.findElement(UserElement.DFGBetToday).getText();

    }
    public String DFGBetYesterday() {
        return driver.findElement(UserElement.DFGBetYesterday).getText();

    }
    public String DFGBetBefore() {
        return driver.findElement(UserElement.DFGBetBefore).getText();

    }



    /**
     *   获取DFG玩家盈亏金额总计
     *   获取今日DFG玩家盈亏
     *   获取昨日DFG玩家盈亏
     *   获取前日DFG玩家盈亏
     *
     * */


    public String DFGWinLoseTotal() {
        return driver.findElement(UserElement.DFGWinLoseTotal).getText();

    }
    public String DFGWinLoseToday() {
        return driver.findElement(UserElement.DFGWinLoseToday).getText();

    }
    public String DFGWinLoseYesterday() {
        return driver.findElement(UserElement.DFGWinLoseYesterday).getText();

    }
    public String DFGWinLoseBefore() {
        return driver.findElement(UserElement.DFGWinLoseBefore).getText();

    }

    /**
     *   获取三方游戏中奖金额总计
     *   获取今日三方游戏中奖
     *   获取昨日三方游戏中奖
     *   获取前日三方游戏中奖
     *
     * */


    public String threeGameLuckyTotal() {
        return driver.findElement(UserElement.threeGameLuckyTotal).getText();

    }
    public String threeGameLuckyToday() {
        return driver.findElement(UserElement.threeGameLuckyToday).getText();

    }
    public String threeGameLuckyYesterday() {
        return driver.findElement(UserElement.threeGameLuckyYesterday).getText();

    }
    public String threeGameLuckyBefore() {
        return driver.findElement(UserElement.threeGameLuckyBefore).getText();

    }



    /**
     *   获取三方游戏投注金额总计
     *   获取今日三方游戏投注
     *   获取昨日三方游戏投注
     *   获取前日三方游戏投注
     *
     * */



    public String threeGameBetTotal() {
        return driver.findElement(UserElement.threeGameBetTotal).getText();

    }
    public String threeGameBetToday() {
        return driver.findElement(UserElement.threeGameBetToday).getText();

    }
    public String threeGameBetYesterday() {
        return driver.findElement(UserElement.threeGameBetYesterday).getText();

    }
    public String threeGameBetBefore() {
        return driver.findElement(UserElement.threeGameBetBefore).getText();

    }


    /**
     *   获取三方游戏盈亏金额总计
     *   获取今日三方游戏盈亏
     *   获取昨日三方游戏盈亏
     *   获取前日三方游戏盈亏
     *
     * */



    public String threeGameWinLoseTotal() {
        return driver.findElement(UserElement.threeGameWinLoseTotal).getText();

    }
    public String threeGameWinLoseToday() {
        return driver.findElement(UserElement.threeGameWinLoseToday).getText();

    }
    public String threeGameWinLoseYesterday() {
        return driver.findElement(UserElement.threeGameWinLoseYesterday).getText();

    }
    public String threeGameWinLoseBefore() {
        return driver.findElement(UserElement.threeGameWinLoseBefore).getText();

    }






}
