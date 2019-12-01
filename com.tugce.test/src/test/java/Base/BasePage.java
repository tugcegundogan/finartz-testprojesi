package Base;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage  {


    protected WebDriver driver = BaseTest.driver;
    private WebDriverWait wait = new WebDriverWait(driver, 15, 1000);

    protected WebElement getElementBy(By by) {
        return driver.findElement(by);
    }

    protected WebElement setObjectByCss(String elm, String value) {
        WebElement element = getElementBy(By.cssSelector(elm));
        element.clear();
        element.click();
        element.sendKeys(value);

        return element;
    }

    protected WebElement setObjectByXpath(String elm, String value) {
        WebElement element = getElementBy(By.xpath(elm));
        element.clear();
        element.click();
        element.sendKeys(value);

        return element;
    }
    protected WebElement clickObjectBy(By by) {
     //   WaitTool.waitForElementClickable(driver, by, 10);
        WebElement element = driver.findElement(by);
        element.click();
        return element;
    }

    protected WebElement clickObjectByCss(String css) {

        return clickObjectBy(By.cssSelector(css));
    }

    protected WebElement clickObjectByXpath(String xpath) {

        return clickObjectBy(By.xpath(xpath));
    }

    protected boolean isElementVisible(String xpath, int timeout){

        try{
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    protected String getText (String css)
    {
        WebElement element = driver.findElement(By.cssSelector(css));
        String elementText=element.getText();
        return elementText;
    }

    protected String getTextAlert ()
    {
        Alert alert = driver.switchTo().alert();
       String alertMessage = alert.getText();
       return alertMessage;

    }
    protected  void acceptAlert()
    {

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}