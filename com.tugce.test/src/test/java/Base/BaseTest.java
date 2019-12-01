package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest  {

    public static WebDriver driver;
    public WebDriverWait wait;

  //  private Logger LOGGER = Logger.getLogger(BaseTest.class);

    @Before
    public void beginTest() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

        ChromeOptions options = new ChromeOptions(); //Chrome ayarlarını tanımladık
        options.addArguments("--start-fullscreen");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");

        driver = new ChromeDriver(options);
        driver.get("http://thedemosite.co.uk/login.php");

        wait = new WebDriverWait(driver, 15, 1000);

    }

    @After
    public void afterTest() throws InterruptedException {
      //  LOGGER.info("Test finished.");
        driver.quit();
    }




}