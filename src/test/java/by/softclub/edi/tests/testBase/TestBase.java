package by.softclub.edi.tests.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners(ScreenshotListener.class)

public class TestBase {

    public static final URL hubUrl;

    static {
        try {
            hubUrl = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome").toUpperCase());

        switch (browser) {
            case CHROME -> driver = new ChromeDriver();
            case FIREFOX -> driver = new FirefoxDriver();
            case MICROSOFTEDGE -> driver = new EdgeDriver();
        }

        Contour contour = Contour.valueOf(System.getProperty("contour", "TEST").toUpperCase());
        driver.manage().window().maximize();
        driver.get(contour.getUrl());
    }

//    @BeforeMethod(alwaysRun = true)
//    public void setup() {
//        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome").toUpperCase());
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//
//        switch (browser) {
//            case CHROME:
//                caps.setBrowserName(String.valueOf(CHROME));
//                break;
//            case FIREFOX:
//                caps.setBrowserName(String.valueOf(FIREFOX));
//                break;
//            case MICROSOFTEDGE:
//                caps.setBrowserName(String.valueOf(MICROSOFTEDGE));
//                break;
//        }
//        caps.setPlatform(Platform.WINDOWS);
//        WebDriver driver = new RemoteWebDriver(hubUrl, caps);
//        driver.manage().window().maximize();
//        driver.get("https://litecart.stqa.ru/en/");
//    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}

