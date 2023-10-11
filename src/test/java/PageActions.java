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
     *   4.点击登录
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

    public void clickLoginButton() {
        driver.findElement(ElementLocators.loginButton).click();
    }









}
