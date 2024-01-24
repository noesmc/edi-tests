package by.softclub.edi.pages.authorization;

import by.softclub.edi.tests.implementation.Implementation;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static by.softclub.edi.tests.testBase.Locators.getLocator;

public class RestorePage extends Implementation {

    Logger LOG = Logger.getLogger(LoginPage.class);
    WebDriver driver;

    public RestorePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to restore button")
    public void redirectToRestorePage() throws Exception {
        LOG.info("Click to \"Forgot password\" button");
        driver.findElement(getLocator("loginPage.forgotPasswordButton")).click();
    }
}
