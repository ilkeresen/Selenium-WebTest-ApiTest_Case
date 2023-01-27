import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOne {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\İlker ESEN\\Desktop\\choromeDriver\\chromedriver.exe");
        WebDriver _webDriver = new ChromeDriver();
        _webDriver.get("https://demoqa.com/checkbox");
        _webDriver.manage().window().maximize();
        _webDriver.findElement(By.xpath("//label[@for='tree-node-home']/preceding-sibling::button[@class='rct-collapse rct-collapse-btn']"));
        _webDriver.findElement(By.xpath("//label[@for='tree-node-home']/preceding-sibling::button[@class='rct-collapse rct-collapse-btn']")).click();
        _webDriver.findElement(By.xpath("//label[@for='tree-node-documents']/preceding-sibling::button[@class='rct-collapse rct-collapse-btn']"));
        _webDriver.findElement(By.xpath("//label[@for='tree-node-documents']/preceding-sibling::button[@class='rct-collapse rct-collapse-btn']")).click();
        _webDriver.findElement(By.xpath("//span[@class='rct-title' and text()='Office']/ancestor::label//span/*[@class='rct-icon rct-icon-uncheck']"));
        _webDriver.findElement(By.xpath("//span[@class='rct-title' and text()='Office']/ancestor::label//span/*[@class='rct-icon rct-icon-uncheck']")).click();
        //_webDriver.findElement(By.xpath("//input[@id='tree-node-office']")).click();
        _webDriver.findElement(By.xpath("//span[@class='rct-title' and text()='Office']/ancestor::label//span/*[@class='rct-icon rct-icon-check']"));
        _webDriver.findElement(By.xpath("//span[text()='office']"));
        Thread.sleep(5000);
        _webDriver.close();
    }
}





