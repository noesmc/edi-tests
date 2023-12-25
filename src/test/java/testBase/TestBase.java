package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)

public class TestBase {

    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome").toUpperCase());

        switch (browser) {
            case CHROME -> driver = new ChromeDriver();
            case FIREFOX -> driver = new FirefoxDriver();
            case EDGE -> driver = new EdgeDriver();
        }

        Contour contour = Contour.valueOf(System.getProperty("contour", "TEST").toUpperCase());
        driver.manage().window().maximize();
        driver.get(contour.getUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}

