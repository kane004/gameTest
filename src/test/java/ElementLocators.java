import org.openqa.selenium.By;

public class ElementLocators {


        /***
     *       登录页面
         *       id
         *       账号
         *       密码
         *       登录
     *
     */

    // 定义页面元素的定位方式
    public static By MerchantId = By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input");
    public static By usernameField = By.xpath("//*[@id=\"app\"]/div/form/div[3]/div/div/input");
    public static By passwordField = By.xpath("//*[@id=\"app\"]/div/form/div[4]/div/div/input");
    public static By loginButton = By.xpath("//*[@id=\"app\"]/div/form/button/span");





    // 添加其他页面元素的定位方式
}
