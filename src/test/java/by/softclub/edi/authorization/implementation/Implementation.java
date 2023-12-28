package by.softclub.edi.authorization.implementation;

import by.softclub.edi.authorization.LoginPage;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static by.softclub.edi.testBase.Locators.getLocator;
import static by.softclub.edi.testBase.TestBase.driver;

public abstract class Implementation {
    Logger LOG = Logger.getLogger(LoginPage.class);

    @Step("Getting web-element's text")
    public String getText(String locator) throws Exception {
        LOG.info("Get text of " + locator);
        return driver.findElement(getLocator(locator)).getText();
    }

    @Step("Getting web-element's attribute")
    public String getAttribute(String locator, String attribute) throws Exception {
        LOG.info("Get attribute " + attribute + " of element");
        return driver.findElement(getLocator(locator)).getAttribute(attribute);
    }
}
