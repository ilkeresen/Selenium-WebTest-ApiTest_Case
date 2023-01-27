package Enums;
public enum TestTwoXpathEnum {
    setPropertyKey("webdriver.chrome.driver"),
    setPropertyValue("C:\\Users\\İlker ESEN\\Desktop\\choromeDriver\\chromedriver.exe"),
    getValue("https://demoqa.com/alerts"),
    alertButton("alertButton"),
    timerAlertButton("timerAlertButton"),
    confirmButton("confirmButton"),
    confirmResult("//span[@id='confirmResult']"),
    promtButton("promtButton"),
    promtTextBoxValue("İlker ESEN"),
    promptResult("//span[@id='promptResult']");
    public final String value;

    private TestTwoXpathEnum(String value) {
        this.value = value;
    }
}