package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TgGet {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Win_x64_1135619_chrome-win\\chrome-win\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://web.telegram.org/k/#@SuperIndexCNBot");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(20000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\output.txt"));

            int maxAttempts = 3;

            while (true) {
                try {
                    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='message spoilers-container']/a[contains(@class, 'anchor-url')]"));

                    for (WebElement element : elements) {
                        String text = element.getText();
                        String link = element.getAttribute("href");

                        System.out.println(text + " " + link);
                        writer.write(text + " " + link + "\n");
                    }

                    // 定位 "下一页" 按钮并等待它可点击
                    WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'reply-markup-button-text') and contains(text(), '下一页')]/parent::button")));

                    // 点击 "下一页" 按钮
                    nextPageButton.click();

                    // 等待下一页加载完成
                    wait.until(ExpectedConditions.stalenessOf(nextPageButton));
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message spoilers-container']/a[contains(@class, 'anchor-url')]")));

                } catch (StaleElementReferenceException e) {
                    // 处理元素过时的情况
                    if (maxAttempts <= 0) {
                        throw e;
                    }
                    maxAttempts--;
                    System.out.println("尝试重新定位元素...");
                    // 可以尝试重新定位元素或执行其他操作
                } catch (Exception e) {
                    // 处理其他异常
                    e.printStackTrace();
                }

                // 等待一段时间后继续尝试
                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }
}



