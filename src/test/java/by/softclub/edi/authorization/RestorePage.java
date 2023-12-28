package by.softclub.edi.authorization;

import by.softclub.edi.authorization.implementation.Implementation;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static by.softclub.edi.testBase.Locators.getLocator;

public class RestorePage extends Implementation {

    Logger LOG = Logger.getLogger(LoginPage.class);
    WebDriver driver;

    public RestorePage(WebDriver driver) {
        this.driver = driver;
    }

//    public String getAttribute(String locator, String attribute) throws Exception {
//        return driver.findElement(getLocator(locator)).getAttribute(attribute);
//    }

    @Step("Click to restore button")
    public void redirectToRestorePage() throws Exception {
        LOG.info("Click to \"Forgot password\" button");
        driver.findElement(getLocator("loginPage.forgotPasswordButton")).click();
    }
}
