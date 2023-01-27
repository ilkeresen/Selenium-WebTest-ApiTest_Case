import Enums.TestTwoXpathEnum;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestTwo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestTwoXpathEnum.setPropertyKey.value,TestTwoXpathEnum.setPropertyValue.value);
        WebDriver _webDriver = new ChromeDriver();
        _webDriver.get(TestTwoXpathEnum.getValue.value);
        _webDriver.manage().window().maximize();
        AlertButtonClick(_webDriver);
        timerAlertButtonClick(_webDriver);
        comfirmButtonClick(_webDriver);
        promtButtonClick(_webDriver);
    }

    public static void AlertButtonClick(WebDriver _webDriver) throws InterruptedException {
        //WebDriver _webDriver = new ChromeDriver();
        //_webDriver.get(TestTwoXpathEnum.getValue.value);
        //_webDriver.manage().window().maximize();
        _webDriver.findElement(By.id(TestTwoXpathEnum.alertButton.value));
        _webDriver.findElement(By.id(TestTwoXpathEnum.alertButton.value)).click();
        Alert alertButtonView = _webDriver.switchTo().alert();
        alertButtonView.accept();
        Thread.sleep(5000);
    }
    public static void timerAlertButtonClick(WebDriver _webDriver) throws InterruptedException {
        _webDriver.findElement(By.id(TestTwoXpathEnum.timerAlertButton.value));
        _webDriver.findElement(By.id(TestTwoXpathEnum.timerAlertButton.value)).click();
        WebDriverWait wait = new WebDriverWait(_webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert timerAlertButtonView = _webDriver.switchTo().alert();
        timerAlertButtonView.accept();
        Thread.sleep(5000);
    }
    public static void comfirmButtonClick(WebDriver _webDriver) throws InterruptedException {
        _webDriver.findElement(By.id(TestTwoXpathEnum.confirmButton.value));
        _webDriver.findElement(By.id(TestTwoXpathEnum.confirmButton.value)).click();
        Alert comfirmButtonView = _webDriver.switchTo().alert();
        comfirmButtonView.accept();
        _webDriver.findElement(By.xpath(TestTwoXpathEnum.confirmResult.value));
        //System.out.println("Yazı görüldü.");
        Thread.sleep(5000);
        _webDriver.findElement(By.id(TestTwoXpathEnum.confirmButton.value));
        _webDriver.findElement(By.id(TestTwoXpathEnum.confirmButton.value)).click();
        comfirmButtonView = _webDriver.switchTo().alert();
        comfirmButtonView.dismiss();
        _webDriver.findElement(By.xpath(TestTwoXpathEnum.confirmResult.value));
        //System.out.println("Yazı görüldü.");
        Thread.sleep(5000);
    }
    public static void promtButtonClick(WebDriver _webDriver) throws InterruptedException {
        WebElement element = _webDriver.findElement(By.id(TestTwoXpathEnum.promtButton.value));
        ((JavascriptExecutor) _webDriver).executeScript("arguments[0].click()", element);
        Alert promtButtonView  = _webDriver.switchTo().alert();
        promtButtonView.sendKeys(TestTwoXpathEnum.promtTextBoxValue.value);
        //Thread.sleep(2000);
        promtButtonView.accept();
        _webDriver.findElement(By.xpath(TestTwoXpathEnum.promptResult.value));
        //System.out.println("Yazı görüldü.");
        Thread.sleep(5000);
        _webDriver.close();
    }
}
